    /*  Αρχείο: a20f2.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να γραφεί ένα πρόγραμμα στο οποίο θα εισάγουμε έναν τυχαίο αριθμό (int) από το 1 έως το 7
    και ανάλογα θα τυπώνει την αντίστοιχη μέρα της εβδομάδας. Η πρώτη μέρα της εβδομάδας (1) είναι η Δευτέρα (Monday).
    Τα ονόματα των ημερών θα εμφανίζονται στα Αγγλικά (Monday, Tuesday, ... Sunday). Σε περίπτωση μη έγκυρου αριθμού
    ημέρας θα εμφανίζεται το μήνυμα "ERROR".
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    int tixaios_arithmos;

    printf("Dose enan arithmo apo to 1 ews to 7: ");
    tixaios_arithmos = GetInteger();
    switch (tixaios_arithmos)
    {
        case 1:
            printf("The day is Monday\n");
            break;
        case 2:
            printf("The day is Tuesday\n");
            break;
        case 3:
            printf("The day is Wednesday\n");
            break;
        case 4:
            printf("The day is Thursday\n");
            break;
        case 5:
            printf("The day is Friday\n");
            break;
        case 6:
            printf("The day is Saturday\n");
            break;
        case 7:
            printf("The day is Sunday\n");
            break;
        default:
            printf("ERROR\n");
            break;
    }

    return 0;

}



