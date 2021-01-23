/*  Αρχείο: a5f1.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027
    
    Άδεια χρήσης: GNU General Public License v3.0

    Να γραφεί πρόγραμμα που διαβάζει τις ώρες εργασίας (int), την ωριαία αντιμισθία (long) και το ποσοστό (double)
    των κρατήσεων ενός εργάτη και στη συνέχεια υπολογίζει κι εμφανίζει τις ακαθάριστες αποδοχές του (double),
    το ποσό των κρατήσεων (double) που έχει     και τις καθαρές του αποδοχές (double).

    Ο υπολογισμός των ποσών θα γίνεται ως εξής:
    Καθ. Αποδοχές= ώρες * ωριαία αντιμισθία
    κρατήσεις= καθαρές αποδοχές * ποσοστό
    ακαθάριστες αποδοχές= καθαρές αποδοχές + κρατήσεις
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{

/* Δήλωση και αρχικοποίηση μεταβλητών */
    int oresErgasias;
    double posostoKrariseon, akatharistesApodoxes, posoKratiseon, katharesApodoxes;
    long antimisthia;

/* Εισαγωγή δεδομένων */
    printf("Dose tis wres ergasias: ");
    oresErgasias = GetInteger();
    printf("Dose tin wriaia antimisthia: ");
    antimisthia = GetLong();
    printf("Dose pososto kratiseon: ");
    posostoKrariseon = GetReal();

/* Υπολογισμοί*/
    katharesApodoxes = (double) antimisthia * oresErgasias;
    posoKratiseon = katharesApodoxes * posostoKrariseon;
    akatharistesApodoxes = katharesApodoxes + posoKratiseon;

/* Εκτύπωση αποτελεσμάτων */
    printf("Oi akatharistes apodoxes einai %g.\n", akatharistesApodoxes);
    printf("Oi kratiseis einai %g.\n", posoKratiseon);
    printf("Oi kathares apodoxes einai %g.\n", katharesApodoxes);
    return 0;

}



