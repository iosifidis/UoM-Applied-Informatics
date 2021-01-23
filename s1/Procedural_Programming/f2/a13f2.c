/*  Αρχείο: a13f2.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027
    
    Άδεια χρήσης: GNU General Public License v3.0

    Μία μηχανή αυτόματης πώλησης καφέ δέχεται μόνο ΕΝΑ χαρτονόμισμα των 5 € κάθε φορά και δίνει τα ρέστα σε κέρματα
    των 10, 20 & 50 λεπτών καθώς και σε κέρματα του 1 και 2 ευρώ . Κάθε καφές κοστίζει 70 λεπτά.
    Να γραφεί πρόγραμμα το οποίο να ζητάει τον αριθμό των καφέδων (int) και να εμφανίζει τα ρέστα (σε κέρματα) (int)
    που πρέπει να δώσει από το χαρτονόμισμα των 5€. Στην περίπτωση που τα χρήματα δεν επαρκούν εμφανίζει το κατάλληλο μήνυμα.
    (Τα χρήματα υπολογίζονται σε λεπτά του ευρώ).
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{

/* Δήλωση και αρχικοποίηση μεταβλητών */
    int kafedes, resta, kermata;

/* Εισαγωγή δεδομένων */
    printf("Dose Kafedes: ");
    kafedes = GetInteger();
    
/* Υπολογισμοί και εκτύπωση αποτελέσματος*/    
    resta = 500 - kafedes * 70; // Για αποφυγή μπερδέματος, θεωρούμε ότι τα 5€ = 5*100 = 500 cents (λεπτά)
    if (resta<0)
    {
                printf("Den ftanoun ta xrimata gia tosous kafedes\n");
    }
    else
    {
        printf("Resta\n");
        kermata = resta / 200; // 2€ = 200 cents
        printf("Kermata 2E: %d\n", kermata);
        resta -= kermata * 200; // Αφαιρώ τα 2€
        kermata = resta / 100; // 1€ = 100 cents
        printf("Kermata 1E: %d\n", kermata);
        resta -= kermata * 100; // Αφαιρώ το 1€
        kermata = resta / 50; // 50 cents
        printf("Kermata 50L: %d\n", kermata);
        resta -= kermata * 50; // Αφαιρώ τα 50 cents
        kermata = resta / 20; // 20 cents
        printf("Kermata 20L: %d\n", kermata);
        resta -= kermata * 20; // Αφαιρώ τα 20 cents
        kermata = resta / 10; // 10 cents
        printf("Kermata 10L: %d\n", kermata);
    }

    return 0;

}



