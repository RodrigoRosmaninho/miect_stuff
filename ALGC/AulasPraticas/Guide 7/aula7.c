#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

/* alusão das funções que implementam os algoritmos pretendidos */
/* allusion to the functions that implement the required algorithms */
int T1 (int);
int T2 (int);
int T3 (int);

/* variável global para contar as invocações recursivas executadas pelo algoritmo */
/* global variable for counting the recursive calls executed by the algorithm */
int Inv;

int main (void)
{
	int Result, Line, N, Test;

	/* leitura do valor limite da tabela */
	/* reading the limit value for the table */
	do
	{
		printf ("N? "); Test = scanf ("%d", &N);
		scanf ("%*[^\n]"); scanf ("%*c");
	} while (Test == 0);

    /* impressão da tabela de execução do algoritmo */
    /* impression of the table values for the algorithm's execution */
	for (Line = 1; Line <= N; Line++)
	{
        /* inicialização da variável global contadora das invocações recursivas */
        /* initialization of the global variable for counting the recursive calls */
		Inv = 0;

		/* invocação do algoritmo pretendido */
		/* invocation of the pretended algorithm */
		Result = T3 (Line);

		/* apresentação do resultado e do número de invocações recursivas executadas pelo algoritmo */
		fprintf (stdout, "T(%2d) = %4d e fez %2d invocacoes\n", Line, Result, Inv);

		/* presenting the result and the number of recursive calls executed by the algorithm */
		//fprintf (stdout, "T(%2d) = %4d and made %2d invocations\n", Line, Result, Inv);
	}

	scanf ("%*c");
	exit (EXIT_SUCCESS);
}

/* implementação dos algoritmos pretendidos */
/* acrescentar a contagem das invocações recursivas executadas pelos algoritmos usando a variável global */

/* implementation of the pretended algorithms */
/* do not forget to count the recursive calls using the global variable */

int T1 (int n)
{
    assert(n >= 0);
	if(n==1) return 1;
    Inv++;
    return T1((int)(n/2)) + n;
}

int T2 (int n)
{
    assert(n >= 0);
	if(n==1) return 1;
    Inv+=2;
    return T2((int)(n/2)) + T2((int)((n+1)/2)) + n;
}

int T3 (int n)
{
    assert(n >= 0);
	if(n==1) return 1;
    if(n % 2 != 0) {Inv+=2; return T3((int)(n/2)) + T3((int)((n+1)/2)) + n;}
    Inv++;
    return 2*T3(n/2) + n;
    
}