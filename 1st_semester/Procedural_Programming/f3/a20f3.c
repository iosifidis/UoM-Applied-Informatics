/*  Αρχείο: a20f3.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Γράψτε ένα πρόγραμμα που να διαβάζει μια σειρά από ηλικίες ανθρώπων (ακολουθία αριθμών int που εισάγεται από το χρήστη)
    και να βρίσκει την μικρότερη και τη μεγαλύτερη ηλικία. Το πρόγραμμα θα συνεχίζει να διαβάζει ηλικίες μέχρι να δοθεί ως ηλικία
     ο αριθμός -1
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
/* Δήλωση και αρχικοποίηση μεταβλητών */
    int ilikia, min, max;

/* Εισαγωγή δεδομένων */
    printf("Dose ilikia: ");
    ilikia=GetInteger();
    min = ilikia; /* Θέτουμε ως ελάχιστη ηλικία, τον αριθμό που εισήχθη από τον χρήστη */
    max = ilikia; /* Θέτουμε ως μέγιστη ηλικία, τον αριθμό που εισήχθη από τον χρήστη */

/* Υπολογισμοί*/
    while (ilikia != -1 )
    {
	max = (ilikia>max) ? ilikia : max;
	min = (ilikia<min) ? ilikia : min;

    	printf("Dose ilikia. Me -1 stamatas eisagwgi: ");
    	ilikia=GetInteger();
    }
    
/* Εκτύπωση αποτελεσμάτων */
    printf("H megaliteri ilikia einai: %d\n",max);
    printf("H mikroteri ilikia einai: %d\n",min);
    return 0;

}



