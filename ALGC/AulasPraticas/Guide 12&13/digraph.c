/************ Implementa��o do D�grafo Din�mico - digraph.c ************/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <limits.h>

#include "digraph.h"	/* interface do d�grafo */
#include "queue.h"	/* interface da fila */

/************** Defini��o do Estrutura de Dados do D�grafo *************/

typedef struct binode *PtBiNode;
typedef struct vertex *PtVertex;
typedef struct edge *PtEdge;

struct binode	/* defini��o de um bin� gen�rico */
{
	unsigned int Number;	/* n�mero do v�rtice ou da aresta */
	PtBiNode PtPrev;	/* ponteiro para o n� anterior da lista */
	PtBiNode PtNext;	/* ponteiro para o n� seguinte da lista */
	PtBiNode PtAdj;	/* ponteiro para a lista de adjac�ncias */
	void *PtElem;	/* ponteiro para o elemento da lista */
	unsigned int Visit;	/* marca��o de v�rtice visitado */
};

struct vertex	/* defini��o de um v�rtice */
{
	unsigned int InDeg;	/* semigrau incidente do v�rtice */
	unsigned int OutDeg;	/* semigrau emergente do v�rtice */
};

struct edge	/* defini��o de uma aresta */
{
	int Cost;	/* custo da aresta */
};

struct digraph	/* defini��o do d�grafo */
{
	PtBiNode Head;	/* ponteiro para a cabe�a do d�grafo */
	unsigned int NVertexes;	/* n�mero de v�rtices do d�grafo */
	unsigned int NEdges;	/* n�mero de arestas do d�grafo */
	unsigned int Type;	/* tipo d�grafo (1)/grafo (0) */
};

/***************** Prot�tipos dos Subprogramas Internos ****************/

static PtVertex CreateVertex (void);
static PtEdge CreateEdge (int);
static PtBiNode CreateBiNode (unsigned int);
static void DestroyBiNode (PtBiNode *);
static PtBiNode InPosition (PtBiNode, unsigned int);
static PtBiNode OutPosition (PtBiNode, unsigned int);
static int InsertEdge (PtBiNode, PtBiNode, int);
static void DeleteEdge (PtBiNode, PtBiNode);

// função auxiliar
static int LastVertexNumber(PtDigraph);

/********************** Defini��o dos Subprogramas *********************/

PtDigraph Create (unsigned int ptype)
{
	PtDigraph Digraph;

	if ((Digraph = (PtDigraph) malloc (sizeof (struct digraph))) == NULL)
		return NULL;	/* alocar mem�ria para o d�grafo */
	Digraph->Head = NULL;	/* inicializa a cabe�a do d�grafo */
	Digraph->NVertexes = 0;	/* inicializa o n�mero de v�rtices */
	Digraph->NEdges = 0;	/* inicializa o n�mero de arestas */
	Digraph->Type = ptype;	/* inicializa o tipo d�grafo/grafo */

	return Digraph;	/* devolve a refer�ncia do d�grafo criado */
}

int Destroy (PtDigraph *pdig)
{
	PtDigraph TmpDigraph = *pdig; PtBiNode Vertex, Edge;

	if (TmpDigraph == NULL) return NO_DIGRAPH;

	while (TmpDigraph->Head != NULL)	/* libertar a mem�ria dos v�rtices */
	{
		Vertex = TmpDigraph->Head;	/* v�rtice da cabe�a do d�grafo */
		TmpDigraph->Head = TmpDigraph->Head->PtNext;	/* atualizar cabe�a */

		while (Vertex->PtAdj != NULL)	/* libertar a mem�ria das arestas */
		{
			Edge = Vertex->PtAdj;	/* cabe�a da lista das arestas */
			Vertex->PtAdj = Vertex->PtAdj->PtNext;	/* atualizar cabe�a */
			free (Edge->PtElem);	/* libertar a mem�ria da aresta */
			free (Edge);	/* libertar o bin� da lista de arestas */
		}

		free (Vertex->PtElem);	/* libertar a mem�ria do v�rtice */
		free (Vertex);	/* libertar o bin� da lista de v�rtices */
	}

	free (TmpDigraph);	/* libertar a mem�ria ocupada pelo d�grafo */
	*pdig = NULL;	/* colocar a refer�ncia do d�grafo a NULL */

	return OK;
}

PtDigraph Copy (PtDigraph pdig)
{
  PtDigraph Copy; PtBiNode Vert, PEdge; PtEdge Edge;

  if (pdig == NULL) return NULL;

  Copy = Create (pdig->Type);

  /* inserir os v�rtices */
  for (Vert = pdig->Head; Vert != NULL; Vert = Vert->PtNext)
    if (InVertex (Copy, Vert->Number)) { Destroy (&Copy); return NULL; }

  /* inserir as arestas */
  for (Vert = pdig->Head; Vert != NULL; Vert = Vert->PtNext)
    for (PEdge = Vert->PtAdj; PEdge != NULL; PEdge = PEdge->PtNext)
    {
      Edge = (PtEdge) PEdge->PtElem;
      if (InEdge (Copy, Vert->Number, PEdge->Number, Edge->Cost))
      { Destroy (&Copy); return NULL; }
    }

  return Copy;  /* devolver a refer�ncia do Digrafo criado */
}

int InVertex (PtDigraph pdig, unsigned int pv)
{
	PtBiNode Insert, Node;	/* posi��o de inser��o e novo v�rtice */

	if (pdig == NULL) return NO_DIGRAPH;

					/* criar o bin� e o v�rtice */
	if ((Node = CreateBiNode (pv)) == NULL) return NO_MEM;
	if ((Node->PtElem = CreateVertex ()) == NULL)
	{ free (Node); return NO_MEM; }

					/* determinar posi��o de coloca��o e inserir o v�rtice */
	if (pdig->Head == NULL || pdig->Head->Number > pv)
	{				/* inser��o � cabe�a do d�grafo */
		Node->PtNext = pdig->Head; pdig->Head = Node;
		if (Node->PtNext != NULL) Node->PtNext->PtPrev = Node;
	}
	else
	{				/* inser��o � frente do n� de inser��o */
		if ((Insert = InPosition (pdig->Head, pv)) == NULL)
		{			/* inser��o sem sucesso, porque o v�rtice j� existe */
			DestroyBiNode (&Node); return REP_VERTEX;
		}
		Node->PtNext = Insert->PtNext;
		if (Node->PtNext != NULL) Node->PtNext->PtPrev = Node;
		Node->PtPrev = Insert; Insert->PtNext = Node;
	}

	pdig->NVertexes++;	/* atualizar o n�mero de v�rtices */
	return OK;
}

int OutVertex (PtDigraph pdig, unsigned int pv)
{
	PtBiNode Vertex, Edge, Delete;	/* posi��o de remo��o do v�rtice */

	if (pdig == NULL) return NO_DIGRAPH;
	if (pdig->NVertexes == 0) return DIGRAPH_EMPTY;

					/* determinar posi��o de remo��o do v�rtice */
	if ((Delete = OutPosition (pdig->Head, pv)) == NULL)
		return NO_VERTEX;

	while (Delete->PtAdj != NULL)	/* remover a lista de adjac�ncias */
	{	/* atualizar semigrau incidente da cabe�a da lista das arestas */
		((PtVertex) Delete->PtAdj->PtAdj->PtElem)->InDeg--;
		Edge = Delete->PtAdj;
		Delete->PtAdj = Delete->PtAdj->PtNext;	/* atualizar cabe�a */
		DestroyBiNode (&Edge);	/* destruir bin� com aresta */
		pdig->NEdges--;	/* atualizar o n�mero de arestas */
	}
					/* remo��o do v�rtice */
	if (Delete == pdig->Head)
	{				/* remo��o do v�rtice da cabe�a do d�grafo */
		if (Delete->PtNext != NULL) Delete->PtNext->PtPrev = NULL;
		pdig->Head = Delete->PtNext;
	}
	else
	{				/* remo��o de outro v�rtice do d�grafo */
		Delete->PtPrev->PtNext = Delete->PtNext;
		if (Delete->PtNext != NULL) Delete->PtNext->PtPrev = Delete->PtPrev;
	}
	DestroyBiNode (&Delete);	/* destruir bin� com v�rtice */
	pdig->NVertexes--;	/* atualizar o n�mero de v�rtices */

					/* remover as arestas incidentes */
	Vertex = pdig->Head;	/* v�rtice da cabe�a do d�grafo */
	while (Vertex != NULL)
	{				/* remover a aresta deste v�rtice para o v�rtice removido */
		if ((Edge = OutPosition (Vertex->PtAdj, pv)) != NULL)
		{
			if (Edge == Vertex->PtAdj)
			{		/* remo��o da aresta da cabe�a da lista das arestas */
				if (Edge->PtNext != NULL) Edge->PtNext->PtPrev = NULL;
				Vertex->PtAdj = Vertex->PtAdj->PtNext;
			}
			else
			{		/* remo��o de outra aresta da lista das arestas */
				Edge->PtPrev->PtNext = Edge->PtNext;
				if (Edge->PtNext != NULL) Edge->PtNext->PtPrev = Edge->PtPrev;
			}
			((PtVertex) Vertex->PtElem)->OutDeg--;	/* atualizar semigrau */
			DestroyBiNode (&Edge);	/* destruir bin� com aresta */
			if (pdig->Type) pdig->NEdges--;	/* atualizar o n�mero de arestas */
		}
		Vertex = Vertex->PtNext;	/* v�rtice seguinte do d�grafo */
	}
	return OK;
}

int InEdge (PtDigraph pdig, unsigned int pv1, unsigned int pv2, int pcost)
{
	PtBiNode V1, V2;	/* posi��o dos v�rtices adjacentes */

	if (pdig == NULL) return NO_DIGRAPH;
	if (pdig->NVertexes == 0) return NO_VERTEX;	/* sem v�rtices */
	if (pv1 == pv2) return REP_EDGE;	/* lacetes proibidos */

			/* verificar se os v�rtices existem e se a aresta j� existe */
	if ((V1 = OutPosition (pdig->Head, pv1)) == NULL)
		return NO_VERTEX;	/* v�rtice emergente inexistente */
	if (V1->PtAdj != NULL && OutPosition (V1->PtAdj, pv2) != NULL)
		return REP_EDGE;	/* aresta existente */
	if ((V2 = OutPosition (pdig->Head, pv2)) == NULL)
		return NO_VERTEX;	/* v�rtice incidente inexistente */

					/* inserir a aresta v1-v2 */
	if (InsertEdge (V1, V2, pcost) != OK) return NO_MEM;
	if (!pdig->Type)	/* se � grafo, inserir tamb�m a aresta v2-v1 */
		if (InsertEdge (V2, V1, pcost) != OK)
		{		/* se a aresta v2-v1 n�o foi inserida, remover a aresta v1-v2 */
			DeleteEdge (V1, V2); return NO_MEM;
		}

	pdig->NEdges++;	/* incrementar o n�mero de arestas */
	return OK;
}

int OutEdge (PtDigraph pdig, unsigned int pv1, unsigned int pv2)
{
	PtBiNode V1, V2;	/* posi��o dos v�rtices adjacentes */

	if (pdig == NULL) return NO_DIGRAPH;
	if (pdig->NVertexes == 0) return NO_VERTEX;
	if (pdig->NEdges == 0 || pv1 == pv2) return NO_EDGE;

			/* verificar se os v�rtices e a aresta existem */
	if ((V1 = OutPosition (pdig->Head, pv1)) == NULL)
		return NO_VERTEX;	/* v�rtice emergente inexistente */
	if (V1->PtAdj == NULL || OutPosition (V1->PtAdj, pv2) == NULL)
		return NO_EDGE;	/* aresta inexistente */
	if ((V2 = OutPosition (pdig->Head, pv2)) == NULL)
		return NO_VERTEX;	/* v�rtice incidente inexistente */


	DeleteEdge (V1, V2);	/* remover a aresta v1-v2 */
					/* se � grafo, remover tamb�m a aresta v2-v1 */
	if (!pdig->Type) DeleteEdge (V2, V1);

	pdig->NEdges--;	/* decrementar o n�mero de arestas */
	return OK;
}

int Type (PtDigraph pdig, unsigned int *pty)
{
	if (pdig == NULL) return NO_DIGRAPH;
	if (pty == NULL) return NULL_PTR;

	*pty = pdig->Type;
	return OK;
}

int VertexNumber (PtDigraph pdig, unsigned int *pnv)
{
	if (pdig == NULL) return NO_DIGRAPH;
	if (pnv == NULL) return NULL_PTR;

	*pnv = pdig->NVertexes;
	return OK;
}

int EdgeNumber (PtDigraph pdig, unsigned int *pne)
{
	if (pdig == NULL) return NO_DIGRAPH;
	if (pne == NULL) return NULL_PTR;

	*pne = pdig->NEdges;
	return OK;
}

int GetVertexList (PtDigraph pdig, unsigned int ppos, char *pvlist)
{
	PtBiNode PVert, PEdge; PtEdge Edge; char NodeList[20];

	if (pdig == NULL) return NO_DIGRAPH;
	if (ppos > pdig->NVertexes) return NO_VERTEX;
	if (pvlist == NULL) return NULL_PTR;

	ppos--;
	for (PVert = pdig->Head; ppos > 0; ppos--) PVert = PVert->PtNext;

	sprintf (NodeList, "Vertice %2d > ", PVert->Number);
	strcpy (pvlist, NodeList);

	for (PEdge = PVert->PtAdj; PEdge != NULL; PEdge = PEdge->PtNext)
	{
		sprintf (NodeList, "%2d (", PEdge->Number);
		strcat (pvlist, NodeList);
		Edge = (PtEdge) PEdge->PtElem;
		sprintf (NodeList, "%2d) ", Edge->Cost);
		strcat (pvlist, NodeList);
	}

	return OK;
}

PtDigraph CreateFile (char *pfilename)
{
  PtDigraph Digraph; FILE *PtF;
  unsigned int Type, NVertexes, NEdges, V, E, Vert1, Vert2; int Status, Cost;

  /* abertura com valida��o do ficheiro para leitura */
  if ( (PtF = fopen (pfilename, "r")) == NULL) return NULL;

  /* leitura do tipo de digrafo/grafo e cria��o do vazio */
  fscanf (PtF, "%d", &Type); fscanf (PtF, "%*c");

  /* leitura do n�mero de v�rtices e de arestas do ficheiro e cria��o do digrafo vazio */
  fscanf (PtF, "%d %d", &NVertexes, &NEdges); fscanf (PtF, "%*c");

  if ((Digraph = Create (Type)) == NULL) { fclose (PtF); return NULL; }

  /* leitura dos v�rtices do ficheiro */
  for (V = 0; V < NVertexes ; V++)
    {
      fscanf (PtF, "%d", &Vert1); fscanf (PtF, "%*c");
      if (InVertex (Digraph, Vert1))
      { Destroy (&Digraph); fclose (PtF); return NULL; }
    }

  /* leitura das arestas do ficheiro */
  for (E = 0; E < NEdges ; E++)
    {
      Status = fscanf (PtF, "%d %d %d", &Vert1, &Vert2, &Cost); fscanf (PtF, "%*c");
      if (Status != 3)
      { Destroy (&Digraph); fclose (PtF); return NULL; }

      if (InEdge (Digraph, Vert1, Vert2, Cost))
      { Destroy (&Digraph); fclose (PtF); return NULL; }
    }

  fclose (PtF);  /* fecho do ficheiro */

  return Digraph;  /* devolve o digrafo criado */
}

int StoreFile (PtDigraph pdig, char *pfilename)
{
  FILE *PtF; PtBiNode Vert, PEdge; PtEdge Edge;

  if (pdig == NULL) return NO_DIGRAPH;

  /* abertura com valida��o do ficheiro para escrita */
  if ((PtF = fopen (pfilename, "w")) == NULL) return NO_FILE;

  /* escrita do tipo do digrafo no ficheiro */
  fprintf (PtF, "%u\n", pdig->Type);

  /* escrita do n�mero de v�rtices e de arestas do digrafo no ficheiro */
  fprintf (PtF, "%u\t%u\n", pdig->NVertexes, pdig->NEdges);

  /* escrita dos v�rtices do digrafo no ficheiro */
  for (Vert = pdig->Head; Vert != NULL; Vert = Vert->PtNext)
    fprintf (PtF, "%u\n", Vert->Number);

  /* escrita das arestas do digrafo no ficheiro */
  for (Vert = pdig->Head; Vert != NULL; Vert = Vert->PtNext)
    for (PEdge = Vert->PtAdj; PEdge != NULL; PEdge = PEdge->PtNext)
    {
      Edge = (PtEdge) PEdge->PtElem;
      fprintf (PtF, "%u\t%u\t%d\n", Vert->Number, PEdge->Number, Edge->Cost);
    }

  fclose (PtF);  /* fecho do ficheiro */

  return OK;
}

PtDigraph DigraphComplement (PtDigraph pdig)
{
  PtDigraph Comp; PtBiNode Vert1, Vert2; int Erro;

  if (pdig == NULL) return NULL;
  if ((Comp = Copy (pdig)) == NULL) return NULL;

  for (Vert1 = pdig->Head; Vert1 != NULL; Vert1 = Vert1->PtNext)
    for (Vert2 = pdig->Head; Vert2 != NULL; Vert2 = Vert2->PtNext)
    {
      if (Vert2 == Vert1) continue;

      Erro = InEdge (Comp, Vert1->Number, Vert2->Number, 1);

      if (Erro == REP_EDGE)
      {
        Erro = OutEdge (Comp, Vert1->Number, Vert2->Number);
	    if (Erro != OK) { Destroy (&Comp); return NULL; }
      }
      else if (Erro != OK) { Destroy (&Comp); return NULL; }
    }

  return Comp;  /* devolver a refer�ncia do Digrafo criado */
}

int VertexType (PtDigraph pdig, unsigned int pv)
{
  /* Insira o seu c�digo - Insert your code */
  if(pdig == NULL) return NO_DIGRAPH;
  if(pdig->NVertexes == 0 || pdig->Head == NULL) return DIGRAPH_EMPTY;
  PtBiNode node = OutPosition(pdig->Head, pv);
  if(node == NULL || node->Number != pv) return NO_VERTEX;
  if(((PtVertex) (node->PtElem))->InDeg == 0 && ((PtVertex) (node->PtElem))->OutDeg == 0) return DISC;
  if(((PtVertex) (node->PtElem))->OutDeg == 0) return SINK;
  if(((PtVertex) (node->PtElem))->InDeg == 0) return SOURCE;
  return OK;
}

int VertexClassification (PtDigraph pdig, unsigned int pv, double *pclass)
{
  /* Insira o seu c�digo - Insert your code */
  if(pdig == NULL) return NO_DIGRAPH;
  if(pclass == NULL) return NULL_PTR;
  if(pdig->NVertexes == 0 || pdig->Head == NULL) return DIGRAPH_EMPTY;
  PtBiNode node = OutPosition(pdig->Head, pv);
  if(node == NULL || node->Number != pv) return NO_VERTEX;
  PtVertex v = node->PtElem;
  int deg = v->InDeg + v->OutDeg;
  // Classificação 0.0 -> nó disconexo
  // Classificação 1.0 -> nó conectado aos V - 1 nós restantes. 2(V-1) arestas.
  *pclass = (double) deg / (2 * (((double) pdig->NVertexes) - 1.0)); // deg / (2(V-1))
  return OK;
}

PtDigraph DigraphTranspose (PtDigraph pdig)
{
  /* Insira o seu c�digo - Insert your code */
  if(pdig == NULL) return NULL;
  // if(pdig->NVertexes == 0 || pdig->Head == NULL) return NULL;
  // Transposto de um grafo vazio é um grafo vazio
  PtDigraph res = Create(pdig->Type);
  if(res == NULL) { return NULL; }
  PtBiNode node = pdig->Head;
  while(node != NULL){
	  if(InVertex(res, node->Number) != OK) { Destroy(&res); return NULL; };
	  node = node->PtNext;
  }
  node = pdig->Head;
  while(node != NULL){
	  PtBiNode adjNode = node->PtAdj;
	  while(adjNode != NULL){
		  if(InEdge(res, adjNode->Number, node->Number, ((PtEdge) adjNode->PtElem)->Cost) != OK) { Destroy(&res); return NULL; };
		  adjNode = adjNode->PtNext;
	  }
	  node = node->PtNext;
  }

  return res;
}

int DigraphEdgeSplit (PtDigraph pdig, unsigned int pve, unsigned int pvi)
{
  /* Insira o seu c�digo - Insert your code */
  if(pdig == NULL) return NO_DIGRAPH;
  if(pdig->NVertexes == 0 || pdig->Head == NULL) return DIGRAPH_EMPTY;

  PtBiNode origin = OutPosition(pdig->Head, pve);
  if(origin == NULL || origin->Number != pve) return NO_VERTEX;
  PtBiNode destination = OutPosition(origin->PtAdj, pvi);
  if(destination == NULL || destination->Number != pvi) return NO_EDGE;
  int cost = ((PtEdge) (destination->PtElem))->Cost;

  int number = LastVertexNumber(pdig) + 1; // próximo índice utilizável
  // não verifico se devolveu -1 porque já verifico nesta função a validade do pdig antes de chamar a LastVertexNumber
  // por isso sei que o valor de retorno é válido.

  // adicionar vértice intermédio com o próximo indice disponível
  int returnCode = InVertex(pdig, number);
  if(returnCode != OK) { return returnCode; }

  // adicionar aresta entre o pve e o vértice intermédio
  returnCode = InEdge(pdig, pve, number, cost/2);
  if(returnCode != OK) { OutVertex(pdig, number); return returnCode; }

  // adicionar aresta entre o vértice intermédio e o pvi
  returnCode = InEdge(pdig, number, pvi, (cost+1)/2);
  if(returnCode != OK) { OutVertex(pdig, number); return returnCode; }

  // apagar aresta original
  returnCode = OutEdge(pdig,pve,pvi);
  if(returnCode != OK) { OutVertex(pdig, number); return returnCode; } // OutVertex elimina também as arestas criadas

  // Se for grafo
  if (!pdig->Type){
    // A edge "contrária" existe certamente

	// Executar operações inversas
	returnCode = InEdge(pdig, pvi, number, (cost+1)/2);
	if(returnCode != OK) { OutVertex(pdig, number); return returnCode; }

    returnCode = InEdge(pdig, number, pve, cost/2);
	if(returnCode != OK) { OutVertex(pdig, number); return returnCode; }

	int returnCode = OutEdge(pdig,pvi,pve);
	if(returnCode != OK) { OutVertex(pdig, number); return returnCode; }
  }

  return OK;
}

int DigraphVertexSplit (PtDigraph pdig, unsigned int pv)
{
  /* Insira o seu c�digo - Insert your code */
  if(pdig == NULL) return NO_DIGRAPH;
  if(pdig->NVertexes == 0 || pdig->Head == NULL) return DIGRAPH_EMPTY;

  PtBiNode origin = OutPosition(pdig->Head, pv);
  if(origin == NULL || origin->Number != pv) return NO_VERTEX;

  int number = LastVertexNumber(pdig) + 1; // próximo índice utilizável
  // não verifico se devolveu -1 porque já verifico nesta função a validade do pdig antes de chamar a LastVertexNumber
  // por isso sei que o valor de retorno é válido.

  // criar novo nó
  int returnCode = InVertex(pdig, number);
  if(returnCode != OK) { return returnCode; }

  // - arestas incidentes em pv -
  // iterar sobre todos os binós
  for(PtBiNode Node = pdig->Head; Node != NULL; Node = Node->PtNext){
	  // apenas os nós que não o pv
	  if(Node->Number != pv){
		  // iterar binós adjacentes
		  for(PtBiNode Adj = Node->PtAdj; Adj != NULL; Adj = Adj->PtNext){
			// se a aresta é incidente em pv
			if(Adj->Number == pv){
				// redirecionar aresta para nó number (novo nó)
				returnCode = InEdge(pdig, Node->Number, number, ((PtEdge)(Adj->PtElem))->Cost);
				if(returnCode != OK) { OutVertex(pdig, number); return returnCode; }

				// se for grafo - adicionar aresta inversa
				if (!pdig->Type){
					returnCode = InEdge(pdig, number, Node->Number, ((PtEdge)(Adj->PtElem))->Cost);
					if(returnCode != OK) { OutVertex(pdig, number); return returnCode; }
				}
			}
  		  }
	  }
  }

  // criar segundo novo nó
  returnCode = InVertex(pdig, number+1);
  if(returnCode != OK) { return returnCode; }

  // - arestas "que saem" de pv -
  for(PtBiNode Node = origin->PtAdj; Node != NULL; Node = Node->PtNext){
	  // adicionar aresta do segundo novo nó para o nó adjacente a pv a ser visto atualmente no ciclo
	  returnCode = InEdge(pdig, number+1, Node->Number, ((PtEdge)(Node->PtElem))->Cost);
	  if(returnCode != OK) { OutVertex(pdig, number); OutVertex(pdig, number+1); return returnCode; }

	  // se for grafo - adicionar aresta inversa
	  if (!pdig->Type){
	    returnCode = InEdge(pdig, Node->Number, number+1, ((PtEdge)(Node->PtElem))->Cost);
	    if(returnCode != OK) { OutVertex(pdig, number); OutVertex(pdig, number+1); return returnCode; }
	  }
  }

  // adicionar aresta de custo zero entre os novos nós
  returnCode = InEdge(pdig, number, number+1, 0);
  if(returnCode != OK) { OutVertex(pdig, number); OutVertex(pdig, number+1); return returnCode; }

  // se for grafo - adicionar aresta inversa
  if (!pdig->Type){
	returnCode = InEdge(pdig, number+1, number, 0);
    if(returnCode != OK) { OutVertex(pdig, number); OutVertex(pdig, number+1); return returnCode; }
  }

  // apagar pv (apaga também todas as suas arestas)
  returnCode = OutVertex(pdig, pv);
  if(returnCode != OK) { OutVertex(pdig, number); OutVertex(pdig, number+1); return returnCode; }

  return OK;
}

int AllSuccDist (PtDigraph pdig, unsigned int pv, double pdst, PtQueue *pqueue)
{
  /* Insira o seu c�digo - Insert your code */
  if(pdig == NULL) return NO_DIGRAPH;
  if(pqueue == NULL) return NULL_PTR;
  *pqueue = QueueCreate(sizeof(int));
  if(*pqueue == NULL) return NO_MEM;
  if(pdig->NVertexes == 0 || pdig->Head == NULL) return DIGRAPH_EMPTY;
  PtBiNode node = OutPosition(pdig->Head, pv);
  if(node == NULL || node->Number != pv) return NO_VERTEX;

  // Percorrer todos os vértices adjacentes
  PtBiNode nodeAdj = node->PtAdj;
  while(nodeAdj != NULL){
	  // Apenas se o cost for menor do que pdst
	  if(((PtEdge) nodeAdj->PtElem)->Cost < pdst) {
		  int returnCode = QueueEnqueue(*pqueue, &(nodeAdj->Number));
		  if(returnCode != OK) return returnCode;
	  }
	  nodeAdj = nodeAdj->PtNext;
  }
  return OK;
}

int AllInEdgesVertex (PtDigraph pdig, unsigned int pv, PtQueue *pqueue)
{
  /* Insira o seu c�digo - Insert your code */
  if(pdig == NULL) return NO_DIGRAPH;
  if(pqueue == NULL) return NULL_PTR;
  *pqueue = QueueCreate(sizeof(int));
  if(*pqueue == NULL) return NO_MEM;
  if(pdig->NVertexes == 0 || pdig->Head == NULL) return DIGRAPH_EMPTY;

  // Percorrer todos os binós
  PtBiNode node = pdig->Head;
  while(node != NULL){
	  // Excetuando o próprio pv
	  if(node->Number != pv) {
		// percorrer todos os binós adjacentes
		PtBiNode adjNode = node->PtAdj;
		while(adjNode != NULL){
			// Se o nó adjacente for pv
			if(adjNode->Number == pv) {
				// Enqueue ambos os nós da aresta
				int returnCode = QueueEnqueue(*pqueue, &(node->Number));
				if(returnCode != OK) return returnCode;
				returnCode = QueueEnqueue(*pqueue, &pv);
				if(returnCode != OK) return returnCode;
				break;
			}
			adjNode = adjNode->PtNext;
		}
	  }
	  node = node->PtNext;
  }
  return OK;
}

/***************** Defini��o dos Subprogramas Internos *****************/

/* Fun��o que insere, de facto, uma aresta no d�grafo/grafo. Em caso de sucesso devolve OK, sen�o devolve NO_MEM para assinalar falta de mem�ria. */

static int InsertEdge (PtBiNode pv1, PtBiNode pv2, int pcost)
{
	PtBiNode Insert, Node;	/* posi��o de inser��o e nova aresta */

					/* criar o bin� e a aresta */
	if ((Node = CreateBiNode (pv2->Number)) == NULL) return NO_MEM;
	if ((Node->PtElem = CreateEdge (pcost)) == NULL)
	{ free (Node); return NO_MEM; }

					/* determinar posi��o de coloca��o e inserir a aresta */
	if (pv1->PtAdj == NULL || pv1->PtAdj->Number > pv2->Number)
	{				/* inser��o � cabe�a da lista das arestas */
		Node->PtNext = pv1->PtAdj; pv1->PtAdj = Node;
		if (Node->PtNext != NULL) Node->PtNext->PtPrev = Node;
	}
	else
	{				/* inser��o � frente do n� de inser��o */
		Insert = InPosition (pv1->PtAdj, pv2->Number);
		Node->PtNext = Insert->PtNext;
		if (Node->PtNext != NULL) Node->PtNext->PtPrev = Node;
		Node->PtPrev = Insert; Insert->PtNext = Node;
	}

	Node->PtAdj = pv2;	/* ligar o v�rtice 1 ao v�rtice 2 */
	/* incrementar semigraus dos v�rtices emergente do 1 e incidente do 2 */
	((PtVertex) pv1->PtElem)->OutDeg++;
	((PtVertex) pv2->PtElem)->InDeg++;

	return OK;
}

/* Fun��o que remove, de facto, uma aresta do d�grafo/grafo. */

static void DeleteEdge (PtBiNode pv1, PtBiNode pv2)
{
	PtBiNode Delete;	/* posi��o de remo��o da aresta */

					/* determinar posi��o de remo��o da aresta */
	Delete = OutPosition (pv1->PtAdj, pv2->Number);

	if (Delete == pv1->PtAdj)	/* remo��o da aresta */
	{				/* remo��o da aresta da cabe�a da lista das arestas */
		if (Delete->PtNext != NULL) Delete->PtNext->PtPrev = NULL;
		pv1->PtAdj = Delete->PtNext;
	}
	else
	{				/* remo��o de outra aresta do v�rtice */
		Delete->PtPrev->PtNext = Delete->PtNext;
		if (Delete->PtNext != NULL) Delete->PtNext->PtPrev = Delete->PtPrev;
	}

	DestroyBiNode (&Delete);	/* destruir bin� com aresta */

	/* decrementar semigraus dos v�rtices emergente do 1 e incidente do 2 */
	((PtVertex) pv1->PtElem)->OutDeg--;
	((PtVertex) pv2->PtElem)->InDeg--;
}

/* Fun��o que cria o v�rtice do d�grafo/grafo. Devolve a refer�ncia do v�rtice criado ou NULL, caso n�o consiga cri�-lo por falta de mem�ria. */

static PtVertex CreateVertex (void)
{
	PtVertex Vertex;

	if ((Vertex = (PtVertex) malloc (sizeof (struct vertex))) == NULL)
		return NULL;

	Vertex->InDeg = 0;	/* inicializa o semigrau incidente */
	Vertex->OutDeg = 0;	/* inicializa o semigrau emergente */
	return Vertex;	/* devolve o v�rtice criado */
}

/* Fun��o que cria a aresta do d�grafo/grafo. Devolve a refer�ncia da aresta criada ou NULL, caso n�o consiga cri�-la por falta de mem�ria. */

static PtEdge CreateEdge (int pcost)
{
	PtEdge Edge;

	if ((Edge = (PtEdge) malloc (sizeof (struct edge))) == NULL)
		return NULL;

	Edge->Cost = pcost;	/* armazena o custo da aresta */
	return Edge;	/* devolve a aresta criada */
}

/* Fun��o que cria o bin� da lista de v�rtices ou da lista de arestas. Devolve a refer�ncia do bin� criado ou NULL, caso n�o consiga cri�-lo por falta de mem�ria. */

static PtBiNode CreateBiNode (unsigned int pnumber)
{
	PtBiNode Node;

	if ((Node = (PtBiNode) malloc (sizeof (struct binode))) == NULL)
		return NULL;

	Node->PtNext = NULL;	/* bin� aponta para a frente para NULL */
	Node->PtPrev = NULL;	/* bin� aponta para a tr�s para NULL */
	Node->PtAdj = NULL;	/* lista de adjac�ncias nula */
	Node->Number = pnumber;	/* armazena o identificador do bin� */
	return Node;	/* devolve o bin� criado */
}

/* Fun��o que liberta a mem�ria ocupada pelo bin� e pelo seu elemento. */

static void DestroyBiNode (PtBiNode *pbinode)
{
	if (*pbinode == NULL) return;

	free ((*pbinode)->PtElem);
	free (*pbinode);
	*pbinode = NULL;
}

/* Fun��o de pesquisa para inser��o. Devolve um ponteiro para o bin� � frente do qual deve ser feita a inser��o do novo v�rtice (nova aresta) ou NULL, caso o v�rtice (a aresta) j� exista. */

static PtBiNode InPosition (PtBiNode phead, unsigned int pnumber)
{
	PtBiNode Node, Prev;

	for (Node = phead; Node != NULL; Node = Node->PtNext)
	{
		if (Node->Number >= pnumber) break;
		Prev = Node;
	}

	if (Node == NULL || Node->Number > pnumber) return Prev;
	else return NULL;	/* o elemento j� existe */
}

/* Fun��o de pesquisa para remo��o. Devolve um ponteiro para o bin� onde se encontra o v�rtice (a aresta) ou NULL, caso o v�rtice (a aresta) n�o exista. */

static PtBiNode OutPosition (PtBiNode phead, unsigned int pnumber)
{
	PtBiNode Node;

	for (Node = phead; Node != NULL; Node = Node->PtNext)
		if (Node->Number == pnumber) break;
	return Node;
}

/* Função auxiliar - Devolve o último número utilizado por um binó */
static int LastVertexNumber(PtDigraph pdig){
	if(pdig == NULL) return -1;
	PtBiNode Node = pdig->Head;

	for (; Node->PtNext != NULL; Node = Node->PtNext);
	return Node->Number;
}
