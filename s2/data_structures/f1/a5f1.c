/*  Αρχείο: a5f1.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Στα μαθηματικά, η ακολουθία Fibonacci ορίζεται ως το σύνολο των αριθμών που προκύπτουν από το
    άθροισμα των δύο προηγούμενων αριθμών του συνόλου. Εξ ορισμού, οι 2 πρώτοι αριθμοί του συνόλου είναι
    οι 0,1. Να γραφεί πρόγραμμα το οποίο θα υλοποιεί τις παρακάτω συναρτήσεις:
    a. Συνάρτηση isFibonacci, η οποία δέχεται έναν θετικό ακέραιο n και μία ακολουθία Fibonacci
    (typos_synolou) και επιστρέφει την τιμή TRUE ή FALSE ανάλογα εάν ο αριθμός ανήκει ή όχι
    αντίστοιχα στην ακολουθία Fibonacci
    b. Διαδικασία createFibonacciSet η οποία θα δέχεται έναν θετικό ακέραιο threshold και θα δημιουργεί
    και επιστρέφει το σύνολο Fibonacci, μέχρι και τον αριθμό που είναι μικρότερος ή ίσος από τον
    δοσμένο ακέραιο.
    Στη συνέχεια, γράψτε κυρίως πρόγραμμα το οποίο θα ζητάει από τον χρήστη έναν ακέραιο αριθμό max, ο
    οποίος ανήκει στο διάστημα [2...1000] και θα δημιουργεί και θα εμφανίζει την ακολουθία Fibonacci, όπου
    το μεγαλύτερο στοιχείο της θα είναι μικρότερο ή ίσο του max. Χρησιμοποιείστε την υλοποίηση ΑΔΤ
    σύνολο με πίνακα και τη διαδικασία displaySet από το TestSetADT.c για την εμφάνιση του συνόλου.
    Τέλος, μετά την εμφάνιση του συνόλου, ο χρήστης θα μπορεί να εισάγει αριθμούς επανηληπτικά, τους
    οποίους το πρόγραμμα θα ελέγχει για το εάν ανήκουν στην τρέχουσα ακολουθία Fibonacci και θα εκτυπώνει
    αντίστοιχο μήνυμα Το πρόγραμμα θα τερματίζει όταν λάβει αρνητικό αριθμό.

*/

#include <stdio.h>
#include <stdlib.h>

#define megisto_plithos 1001

typedef enum {
    FALSE, TRUE
} boolean;

typedef boolean typos_synolou[megisto_plithos];
typedef int stoixeio_synolou;

boolean isFibonacci(stoixeio_synolou n, typos_synolou fibonacci);
void createFibonacciSet(stoixeio_synolou threshold, typos_synolou fibonacci);

void Dimiourgia(typos_synolou synolo);
void displayset(typos_synolou set);
void Eisagogi(stoixeio_synolou stoixeio, typos_synolou synolo);
boolean Melos(stoixeio_synolou stoixeio, typos_synolou synolo);


int main()
{
    stoixeio_synolou max, tmp;
    typos_synolou fibonacci;

     do{
     printf("Dwse to megisto arithmo. ");
     scanf("%d", &max);
    }while(max < 2 || max > 1000);

/* ΕΝΑΛΛΑΚΤΙΚΟ ΣΕΝΑΡΙΟ
        while(TRUE){
        printf("Dwse to megisto arithmo. ");
        scanf("%d", &max);
        if(max>=2 && max<=1000) {break;}
        printf("O megistos arithmos prepei na anhkei sto diasthma [2...1000]\n");}

*/

    createFibonacciSet(max, fibonacci);
    displayset(fibonacci);

    while(TRUE){
        printf("Enter number to check: ");
        scanf("%d", &tmp);
        if(tmp<0) {break;}
        if(Melos(tmp, fibonacci))
            {printf("Fibonacci!\n");}
        else
            {printf("Not Fibonacci...\n");}
    }

    return 0;
}

boolean isFibonacci(stoixeio_synolou f, typos_synolou fibonacci)
{
        if(Melos(f,fibonacci))
        	{return TRUE;}
    return FALSE;
}

void createFibonacciSet(stoixeio_synolou threshold, typos_synolou fibonacci)
{
    stoixeio_synolou next=1,n1=0,n2=1;
    Dimiourgia(fibonacci);
    Eisagogi(0,fibonacci);
    Eisagogi(1,fibonacci);
    while(next<threshold)
    {
        Eisagogi(next,fibonacci);
        n1=n2;
        n2=next;
        next=n1+n2;
    }

}

void Dimiourgia(typos_synolou synolo)
{
    stoixeio_synolou i;

    for (i = 0; i < megisto_plithos; i++)
        synolo[i] = FALSE;
}

void displayset(typos_synolou set)
{
	stoixeio_synolou i;

	for (i=0;i < megisto_plithos;i++)
	{
		if(Melos(i,set))
			printf(" %d",i);
	}
	printf("\n");
}

void Eisagogi(stoixeio_synolou stoixeio, typos_synolou synolo)
{
    synolo[stoixeio] = TRUE;
}

boolean Melos(stoixeio_synolou stoixeio, typos_synolou synolo)
{
    return synolo[stoixeio];
}

