/*  Αρχείο: a2f6.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

*/

#include <stdio.h>
#include "simpio.h"

#define size 100

int readtable(int pinakas[]);
void maxminArray(int pinakas[], int counter, int *max, int *min);

int main()
{
    int pinakas[size];
    int min, max, counter;

    counter=readtable(pinakas);

    maxminArray(pinakas, counter, &max, &min);

    printf("The range of values is %d-%d",min,max);
    return 0;
}

int readtable(int pinakas[])
{
     int num;
     int i;
     printf("Enter the elements of the array, one per line.\nUse -1 to signal the end of the list.\n");
     for(i=0;i<size;i++)
     {
        printf("?");
        scanf("%d",&num);
        if (num!=-1)
            {pinakas[i]=num;}
        else
            {return i;}
 	}
 	return i;
}

void maxminArray(int pinakas[], int counter, int *max, int *min)
{
    int i;
    *max = pinakas[0];
    *min = pinakas[0];
    for(i=1;i<counter;i++)
    {
        if (pinakas[i] > *max)
            {*max = pinakas[i];}
        if (pinakas[i] < *min)
            {*min = pinakas[i];}
            }
}
