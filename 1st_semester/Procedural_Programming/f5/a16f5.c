/*  Αρχείο: a16f5.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να αναπτυχθεί (με τη χρήση των συναρτήσεων που περιγράφονται) πρόγραμμα στο οποίο,
    - θα γεμίζει τον πίνακα a μεγέθους 50 με τυχαίους αριθμούς από το 0 έως το 9 χρησιμοποιώντας την
    συνάρτηση rand() (a[i]=rand() % 10), της βιβλιοθήκης <stdlib.h> (συνάρτηση populate)
    - θα εμφανίζει τον πίνακα a στην οθόνη (συνάρτηση printArr),
    - θα ζητά έναν ακέραιο αριθμό Ν από το 0 έως και το 9 από τον χρήστη - δεν απαιτείται έλεγχος,
    - θα καλεί την συνάρτηση checkTable, η οποία θα υπολογίζει τον αριθμό των εμφανίσεων του αριθμού Ν στον πίνακα a
    και τις θέσεις του πίνακα στις οποίες εμφανίζεται ο αριθμός
    - θα εμφανίζει τα αποτελέσματα στο χρήστη, όπως φαίνεται στο παράδειγμα εκτέλεσης. Η εμφάνιση των αποτελεσμάτων
    θα γίνεται από τη συνάρτηση main() (κυρίως πρόγραμμα), και των θέσεων που εμφανίζεται ο αριθμός Ν καλώντας την printArr.

    Άδεια χρήσης: GNU General Public License v3.0

*/

#include <stdio.h>
#include <stdlib.h>
#include "genlib.h"
#include "simpio.h"

#define r 50

void populate(int a[]);
void printArr(int digits, int a[]);
int checkTable(int N, int a[], int thesia[]);

int main()
{
    int a[r], thesia[r];
    int N;

	/* Create the table a */
	populate(a);

    /*Print initial table*/
    printArr(r, a);
    printf("--------------\n");

    /*Read Data*/
    printf("Dwse arithmo apo to 0 ews to 9: ");
    N=GetInteger();

    /*Print results*/
    printf("\n");
    printf("o Arithmos %d emfanizetai %d fores.\n",N,checkTable(N, a, thesia));

   	printf("Stis theseis:\n");
  	printArr(checkTable(N, a, thesia), thesia);

    return 0;
}

void populate(int a[])
{
    int i;
    for (i=0; i<r; i++)
    	{a[i]=rand() % 10;}
}

void printArr(int digits, int a[])
{
    int i;
    for (i=0; i<digits; i++)
    	{printf("%d\t",a[i]);}
    printf("\n");
}

int checkTable(int N, int a[], int thesia[])
{
    int count, i;
    count=0;
    for (i=0; i<=r; i++)
    {
        if (a[i]==N)
        {
            thesia[count]=i;
            count+=1;
        }
    }
    return count;
}
