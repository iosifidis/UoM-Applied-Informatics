/*  Αρχείο: a13f6.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

*/

#include <stdio.h>
#include "simpio.h"

void decompose(long num, int *plithos, double *mo, int *max);

int main()
{
	int plithos, max;
	double mo;
	long num;
	printf("Please insert non-negative number: ");
	scanf("%ld",&num);
	decompose(num, &plithos, &mo, &max);
	printf("Digits: %d\n",plithos);
	printf("Average: %.3f\n",mo);
	printf("Max: %d",max);

    return 0;
}

void decompose(long num, int *plithos, double *mo, int *max)
{
    int i;
    double sum=0;
    *max=0;
    *plithos=0;
    while (num != 0)
    {
    	sum += num%10;
    	if (num%10>*max)
    		{*max=num%10;}
        num /= 10;
        *plithos+=1;
    }

    *mo=sum / *plithos;
}
