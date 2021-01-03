/*  Αρχείο: a14f1.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027
    
    Άδεια χρήσης: GNU General Public License v3.0

    Να γραφεί πρόγραμμα που θα υπολογίζει και θα εμφανίζει πόσες θερμίδες χρειάζεται καθημερινά μια γυναίκα
    η οποία κάνει καθιστική ζωή.
    Η ενέργεια που απαιτείται για το βασικό μεταβολισμό του γυναικείου οργανισμού, BMR, υπολογίζεται ως εξής:
    BMR = 655 + (9.6 X Βάρος σε κιλά) + (1.8 X Ύψος σε cm) - (4.7 X Ηλικία σε χρόνια).
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{

/* Δήλωση και αρχικοποίηση μεταβλητών */
    int varos, ilikia, ipsos;
    double BMR;

/* Εισαγωγή δεδομένων */
    printf("Dose varos se kila: ");
    varos = GetInteger();
    printf("Dose upsos se cm: ");
    ipsos = GetInteger();
    printf("Dose ilikia se xronia: ");
    ilikia = GetInteger();
    
/* Υπολογισμοί*/
    BMR = 655 + (9.6*varos) + (1.8*ipsos) - (4.7*ilikia);
    
/* Εκτύπωση αποτελέσματος */
    printf("To BMR einai %g\n", BMR);
    return 0;

}



