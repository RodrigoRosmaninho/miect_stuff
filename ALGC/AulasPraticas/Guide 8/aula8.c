#include <stdio.h>
#include <stdlib.h>

/* alus�o das fun��es que implementam os algoritmos pretendidos */
/* allusion to the functions that implement the required algorithms */
int PerrinRec (int);
int PerrinDin (int);

/* vari�vel global para contar as adi��es executadas pelo algoritmo */
/* global variable for counting the sums executed by the algorithm */
int Sum;

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

    /* impress�o da tabela de execu��o do algoritmo */
    /* impression of the table values for the algorithm's execution */
	int Last_R = 1;
	int Last_S = 1;
	for (Line = 0; Line <= N; Line++)
	{
        /* inicializa��o da vari�vel global contadora das adi��es */
        /* initialization of the global variable for counting the sums */
		Sum = 0;

		/* invoca��o do algoritmo pretendido */
		/* invocation of the pretended algorithm */
		Result = PerrinDin (Line);

		/* apresenta��o do resultado e do n�mero de adi��es executadas pelo algoritmo */
		fprintf (stdout, "P(%2d) = %4d e fez %2d somas - racio %f - racio %f\n", Line, Result, Sum, (double) Result / (double) Last_R, (double) Sum / (double) Last_S);

		/* presenting the result and the number of sums executed by the algorithm */
		//fprintf (stdout, "P(%2d) = %4d and made %2d sums\n", Line, Result, Sum);
		Last_R = Result;
		Last_S = Sum;
	}

	scanf ("%*c");
	exit (EXIT_SUCCESS);
}

/* implementa��o dos algoritmos pretendidos */
/* acrescentar a contagem das invoca��es recursivas executadas pelos algoritmos usando a vari�vel global */

/* implementation of the pretended algorithms */
/* do not forget to count the recursive calls using the global variable */

int PerrinRec (int n)
{
	if(n == 0) return 3;
	if(n == 1) return 0;
	if(n == 2) return 2;
	Sum++;
	return PerrinRec(n-2) + PerrinRec(n-3);
}

int PerrinDin (int n)
{
	int din[n+1];
	din[0] = 3; din[1] = 0; din[2] = 2;
	for(int i = 3; i <= n; i++){
		Sum++;
		din[i] = din[i-2] + din[i-3];
	}
	return din[n];
}



