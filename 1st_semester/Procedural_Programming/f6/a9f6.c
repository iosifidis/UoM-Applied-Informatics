/*  Αρχείο: a9f6.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

*/

#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

#define SALESMEN 4
#define PRODUCTS 5

void calculateSales(int S, int P, int salesTable[S][P], int price[P], int sp[S]);
void calculateProductSales(int S, int P, int salesTable[S][P], int prods[P]);
void maxArray(int size, int table[size], int *max, int *pos);
void printArray(int size, int table[]);

int main()
{
    int price[PRODUCTS]={250,150,320,210,920};
    int sales[SALESMEN][PRODUCTS]=
                {
                    {10,4,5,6,7},
                    {7,0,12,1,3},
                    {4,19,5,0,8},
                    {3,2,1,5,6}
                };
    int salesPerson[SALESMEN];
    int productSale[PRODUCTS];
    int MaxSalesMan,MaxProduct;
    int income,items;

    calculateSales(SALESMEN,PRODUCTS,sales,price,salesPerson);
    calculateProductSales(SALESMEN,PRODUCTS,sales,productSale);
    maxArray(SALESMEN, salesPerson, &income, &MaxSalesMan);
    maxArray(PRODUCTS, productSale, &items, &MaxProduct);

    printf("SalesMan-Sales \n");
    printArray(SALESMEN, salesPerson);
    printf("Best Salesman was %d with %d sales\n", MaxSalesMan, income);
    printf("Product-Items \n");
    printArray(PRODUCTS, productSale);
    printf("Best product was %d with %d items\n", MaxProduct, items);

    return 0;
}

void calculateSales(int S, int P, int salesTable[S][P], int price[P], int sp[S])
{
    int i,j;
    for(i=0;i<S;i++)
    {
        sp[i]=0;
        for(j=0;j<P;j++)
            sp[i] += salesTable[i][j] * price[j];
    }

}

void calculateProductSales(int S, int P, int salesTable[S][P], int prods[P])
{
    int i,j;
    for(i=0;i<P;i++)
    {
        prods[i]=0;
        for(j=0;j<S;j++)
            prods[i] += salesTable[j][i];
    }
}

void maxArray(int size, int table[], int *max, int *pos)
{
    int i;
    *max = table[0];
    *pos = 0;
    for(i=1;i<size;i++)
    {
        if (table[i] > *max)
        {
            *max = table[i];
            *pos = i;
        }
    }
}

void printArray(int size, int table[])
{
    int i;
    for(i=0;i<size;i++)
        printf("%d\t%d\n",i,table[i]);
}
