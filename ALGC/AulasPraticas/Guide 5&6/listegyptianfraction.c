/*******************************************************************************
 Ficheiro de implementa��o do Tipo de Dados Abstracto EGYPTIAN FRACTION.
 A estrutura de dados de suporte da fra��o eg�pcia � uma estrutura, constitu�da
 pelo campo inteiro Size para indicar o n�mero de fra��es existentes, pelo campo
 inteiro Complete para indicar se a fra��o eg�pcia est� completa/incompleta, e
 pelos ponteiros Head e Tail para aceder � lista ligada que armazena as fra��es 
 unit�rias contituintes da fra��o eg�pcia.

 Autor : Ant�nio Manuel Adrego da Rocha    Data : Mar�o de 2019
 
 Implementation file of the abstract data type EGYPTIAN FRACTION.
 The supporting data structure of the egyptian fraction is a structure, constituted
 by the integer field Size to indicate the number of fractions, by the integer field
 Complete to indicate if the egyptian fraction is complete/incomplete, and by the
 Head and Tail pointers to access the linked list that stores the unit fractions
 constituent of the egyptian fraction.
*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#include "egyptianfraction.h"	/* Ficheiro de interface do TDA - ADT Interface file */

/********** Defini��o da Estrutura de Dados Interna da Fra��o Eg�pcia *********/
/************ Egiptian Fraction's Internal Data Structure Definition **********/

typedef struct node *PtNode;
struct node /* defini��o do n� da lista ligada - link list node definition */
{
	PtFraction PtElem;  /* elemento da lista - list element */
	PtNode PtNext;  /* ponteiro para o n� seguinte - next node pointer */
};

struct egyptianfraction
{
	int Size;	/* n�mero de fra��es unit�rias - number of unit fractions */
	int Complete;	/* fra��o eg�pcia completa/incompleta - complete/incomplete egyptian fraction */
	PtNode Head, Tail;  /* ponteiros para a lista de fra��es unit�rias - pointers to the list of unit fractions */
};

/*********************** Controlo Centralizado de Erro ************************/
/************************* Centralized Error Control **************************/

static unsigned int Error = OK;	/* inicializa��o do erro - error initialization */

static char *ErrorMessages[] = {
									"sem erro - without error",
									"fracao(fracoes) inexistente(s) - fraction(s) do not exist",
									"memoria esgotada - out of memory",
									"fracao nao propria - fraction not proper",
									"denominador nulo - null denominator",
									"indice errado - bad index",
									"ponteiro nulo - null pointer"
								};

static char *AbnormalErrorMessage = "erro desconhecido - unknown error";

/************** N�mero de mensagens de erro previstas no m�dulo ***************/
/************** Number of predicted error messages in the module **************/

#define N (sizeof (ErrorMessages) / sizeof (char *))

/************************ Alus�o �s Fun��es Auxiliares ************************/
/*********************** Allusion to Auxiliary Functions **********************/

PtNode NodeCreate (PtFraction);
void NodeDestroy (PtNode *);
void ListDestroy (PtNode *);
static PtFraction CreateUnitFraction (PtFraction *);

/*************************** Defini��o das Fun��es ****************************/
/*************************** Function Definitions *****************************/

void EgyptianFractionClearError (void)
{ Error = OK; }

int EgyptianFractionError (void)
{ return Error; }

char *EgyptianFractionErrorMessage (void)
{
	if (Error < N) return ErrorMessages [Error];
	else return AbnormalErrorMessage;	/* n�o h� mensagem de erro - - no error message */
}

PtEgyptianFraction EgyptianFractionCreate (PtFraction pfraction)	/* construtor inicializador - initializer constructor */
{
	if(pfraction == NULL) { Error=NO_FRACTION; return NULL; }
	if(!FractionIsProper(pfraction) || FractionGetNumerator(pfraction) <= 0) { Error=NOT_PROPER; return NULL; }
	PtEgyptianFraction pegyp = (PtEgyptianFraction) malloc (sizeof (struct egyptianfraction));
	if(pegyp == NULL) { Error = NO_MEM; return NULL;}

	if(FractionGetNumerator(pfraction) == 1) {
		pegyp -> Head = NodeCreate(FractionCopy(pfraction));
		if(pegyp -> Head == NULL){ Error = NO_MEM; EgyptianFractionDestroy(&pegyp); return NULL;}
		pegyp -> Tail = pegyp -> Head;
		pegyp -> Size = 1;
		pegyp -> Complete = 1;
	}
	else{
		PtNode* current = &(pegyp -> Head);
		PtFraction copy = FractionCopy(pfraction);
		if(copy == NULL){ Error = NO_MEM; EgyptianFractionDestroy(&pegyp); return NULL;}
		PtFraction tmp;
		do {
			tmp = CreateUnitFraction(&copy);
			if(tmp != NULL) {
				*current = NodeCreate(tmp);
				if(*current == NULL){ Error = NO_MEM; EgyptianFractionDestroy(&pegyp); return NULL;} 
				pegyp -> Size++;
			}

			if(copy != NULL) current = &((*current) -> PtNext);
			if(FractionGetNumerator(copy) == 1) { 
				*current = NodeCreate(copy);
				if(*current == NULL){ Error = NO_MEM; EgyptianFractionDestroy(&pegyp); return NULL;}
				pegyp -> Size++; 
				pegyp -> Complete = 1; 
			}

		} while((!EgyptianFractionIsComplete(pegyp)) && (copy != NULL) && (pegyp -> Size < MAX_SIZE));
		pegyp -> Tail = *current;
	}

	Error = OK;
	return pegyp;
}

void EgyptianFractionDestroy (PtEgyptianFraction *pegyp)	/* destrutor - destructor */
{
	PtEgyptianFraction Frac = *pegyp;
	if(Frac == NULL) { Error = NO_FRACTION; return; }
	ListDestroy(&(Frac -> Head));
	free (Frac);
	*pegyp = NULL;
	Error = OK;
}

int  EgyptianFractionGetSize (PtEgyptianFraction pegyp)
{
	if(pegyp == NULL) { Error=NO_FRACTION; return 0; }
	Error = OK;
	return pegyp -> Size;
}

int  EgyptianFractionIsComplete (PtEgyptianFraction pegyp)
{
	if(pegyp == NULL) { Error=NO_FRACTION; return 0; }
	Error = OK;
	return pegyp -> Complete;
}

PtEgyptianFraction EgyptianFractionCopy (PtEgyptianFraction pegyp)	/* construtor c�pia - copy constructor */
{
	if(pegyp == NULL) { Error = NO_FRACTION; return NULL; }
	PtEgyptianFraction new = (PtEgyptianFraction) malloc (sizeof (struct egyptianfraction));
	if(new == NULL) { Error = NO_MEM; return NULL;}
	Error = OK;
	
	PtNode source = pegyp -> Head;
	new -> Head = NodeCreate(FractionCopy(source -> PtElem));
	if(new -> Head == NULL){ Error = NO_MEM; EgyptianFractionDestroy(&new); return NULL;}
	PtNode dest = new -> Head;
	for(int i = 1; i < pegyp -> Size; i++){
		source = source -> PtNext;
		dest -> PtNext = NodeCreate(FractionCopy(source -> PtElem));
		if(dest -> PtNext == NULL){ Error = NO_MEM; EgyptianFractionDestroy(&new); return NULL;}
		dest = dest -> PtNext;
		new -> Tail = dest;
	}
	new -> Size = pegyp -> Size;
	
	printf("%s", FractionToString(new -> Head -> PtElem));
	new -> Complete = pegyp -> Complete;
	return new;
}

PtFraction EgyptianFractionToFraction (PtEgyptianFraction pegyp)
{
	if(pegyp == NULL) { Error = NO_FRACTION; return NULL; }
	PtFraction soma = FractionCopy(pegyp -> Head -> PtElem);
	if(soma == NULL){ Error = NO_MEM; FractionDestroy(&soma); return NULL;}

	PtNode node = pegyp -> Head -> PtNext;
	for(int i = 1; i < pegyp -> Size; i++){
		soma = FractionAddition(soma, node -> PtElem);
		if(soma == NULL){ Error = NO_MEM; FractionDestroy(&soma); return NULL;}
		node = node -> PtNext;
	}

	return soma;
}

int EgyptianFractionEquals (PtEgyptianFraction pegy1, PtEgyptianFraction pegy2)
{
	if((pegy1 == NULL) || (pegy2 == NULL)) { Error = NO_FRACTION; return 0; }
	if(pegy1 -> Size != pegy2 -> Size) return 0;
	Error = OK;

	PtNode node1 = pegy1 -> Head;
	PtNode node2 = pegy2 -> Head;
	for(int i = 0; i < pegy1 -> Size; i++){
		if(!FractionEquals(node1 -> PtElem, node2 -> PtElem)) return 0;
		node1 = node1 -> PtNext;
		node2 = node2 -> PtNext;
	}

	return 1;
}

int EgyptianFractionBelongs (PtEgyptianFraction pegyptian, PtFraction pfraction)
{
	if((pegyptian == NULL) || (pfraction == NULL)) { Error = NO_FRACTION; return 0; }
	if((FractionGetNumerator(pfraction) != 1) || (FractionGetDenominator(pfraction) == 1)) { Error = NOT_PROPER; return 0; }
	Error = OK;

	PtNode node = pegyptian -> Head;
	for(int i = 0; i < pegyptian -> Size; i++){
		if(FractionEquals(node -> PtElem, pfraction)) return 1;
		node = node -> PtNext;
	}

	return 0;
}

PtFraction EgyptianFractionGetPos (PtEgyptianFraction pegyp, int pindex)
{
	if(pegyp == NULL) { Error = NO_FRACTION; return NULL; }
	if((pindex < 0) || (pindex >= pegyp -> Size)) { Error = BAD_INDEX; return NULL; }
	Error = OK;

	if(pindex == 0) return (pegyp -> Head) -> PtElem;
	if(pindex == pegyp -> Size - 1) return (pegyp -> Tail) -> PtElem;

	PtNode* current = &(pegyp -> Head);
	for(int i = 1; i <= pindex; i++){
		current = &((*current) -> PtNext);
	}

	return (*current) -> PtElem;
}

/*********************** Defini��o das Fun��es Internas ***********************/
/*********************** Definition of Internal Functions *********************/

/*******************************************************************************
 Fun��o iterativa para decompor uma fra��o no seu primeiro termo unit�rio. Tem
 como par�metro de entrada uma fra��o (que se assume uma fra��o pr�pria positiva)
 e devolve a maior fra��o unit�ria existente ou uma refer�ncia nula no caso de 
 falta de mem�ria din�mica para alocar uma nova fra��o. A fun��o altera a fra��o 
 passada no par�metro de entrada para o valor do resto da fra��o que precisa de 
 continuar a ser convertida. Caso haja overflow no c�lculo do denominador desta 
 fra��o restante ent�o a fra��o de entrada fica com a refer�ncia nula para 
 indicar a impossibilidade de fazer a extra��o da fra��o unit�ria seguinte.
 Como o par�metro de entrada fica corrompido pela execu��o da fun��o, qualquer 
 fun��o que a utilize deve - depois das valida��es necess�rias - fazer uma c�pia 
 da fra��o e usar a c�pia, n�o se esquecendo de eliminar a fra��o no fim.
 
 Iterative function to decompose a fraction into its first unit term. Has as input
 parameter a fraction (assuming a positive proper fraction) and returns the largest
 existing unit fraction or a zero reference in the case of lack of dynamic memory 
 to allocate a new fraction. The function changes the input fraction to the value 
 of the remainder of the fraction that needs to continue to be converted. If there 
 is overflow in calculating the denominator of this remaining fraction, then the 
 input parameter is destoyed and assumes the null reference for indicate the 
 impossibility of extracting the next unit fraction. Because the input parameter is
 corrupted by the function execution, any function that uses it must - after the 
 necessary validations - make a copy of the fraction and use the copy, not forgetting
 to eliminate the fraction before terminating its execution.
*******************************************************************************/
static PtFraction CreateUnitFraction (PtFraction *pfraction)
{
	PtFraction UnitFraction; int Num, Den, NewNum, NewDen;

	Num = FractionGetNumerator (*pfraction);
	Den = FractionGetDenominator (*pfraction);

	NewNum = 1; NewDen = Den/Num;
	if (Den%Num != 0) NewDen++;

	if ((UnitFraction = FractionCreate (NewNum, NewDen)) == NULL)
	{ Error = FractionError (); return NULL; }

	unsigned long long Denominator = Den * NewDen;

	if (Denominator > INT_MAX) FractionDestroy (pfraction);
	else
	{
		NewNum = (-Den) % Num;
		if (NewNum < 0) NewNum += Num;
		NewDen = (int) Denominator;
		FractionSet (*pfraction, NewNum, NewDen);
		if (FractionError () != OK) FractionDestroy (pfraction);
	}

	return UnitFraction;
}

/*******************************************************************************
 Fun��o auxiliar para criar um n� da lista ligada. Valores de erro: OK ou NO_MEM.
 
 Auxiliary function to create a list node. Error codes: OK or NO_MEM.
*******************************************************************************/
PtNode NodeCreate (PtFraction pelem)	/* aloca��o do n� - node allocation */
{
	PtNode Node;

	if ((Node = (PtNode) malloc (sizeof (struct node))) == NULL)
    { Error = NO_MEM; return NULL; }

	Node->PtElem = pelem;		/* copiar o elemento - copy the element */
	Node->PtNext = NULL;	/* apontar para a frente para NULL - next is null */

	Error = OK;
	return Node;
}

/*******************************************************************************
 Fun��o auxiliar para libertar um n� da lista ligada. Valores de erro: OK ou NULL_PTR.
 
 Auxiliary function to free a link list node. Error codes: OK or NULL_PTR.
*******************************************************************************/
void NodeDestroy (PtNode *pnode)	/* liberta��o do n� - node releasing */
{
	if (*pnode == NULL) { Error = NULL_PTR; return; }
	free (*pnode);	/* liberta��o do n� - free the node */
	*pnode = NULL;	/* colocar o ponteiro a nulo - set the pointer to null */
	Error = OK;
}

/*******************************************************************************
 Fun��o auxiliar para destruir uma lista ligada. Valores de erro: OK ou NULL_PTR.
 
 Auxiliary function to destroy a link list. Error codes: OK or NULL_PTR.
*******************************************************************************/
void ListDestroy (PtNode *phead)
{
	PtNode TmpHead = *phead; PtNode Node;

	if (TmpHead == NULL) { Error = NULL_PTR; return; }
	while (TmpHead != NULL)
	{
		Node = TmpHead; TmpHead = TmpHead->PtNext;
		FractionDestroy (&Node->PtElem);
		NodeDestroy (&Node);
	}
	Error = OK; 
}

