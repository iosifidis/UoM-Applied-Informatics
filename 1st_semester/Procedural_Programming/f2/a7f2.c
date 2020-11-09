/*  Αρχείο: a7f2.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να γραφεί ένα πρόγραμμα C για τον υπολογισμό και την εμφάνιση της εβδομαδιαίας αμοιβής ενός εργαζομένου ως εξής:
    Το πρόγραμμα θα διαβάζει τον κωδικό αριθμό (long) του εργαζομένου. Αν ο κωδικός αριθμός είναι μεγαλύτερος ή ίσος του 1000,
    τότε το πρόγραμμα θα διαβάζει τον ετήσιο μισθό του εργαζομένου (double) και θα υπολογίζει την εβδομαδιαία αμοιβή (double)
    του διαιρώντας τον ετήσιο μισθό δια 52.
    Αν ο κωδικός είναι μικρότερος του 1000, τότε το πρόγραμμα θα διαβάζει τις ώρες εβδομαδιαίας εργασίας (int) του εργαζομένου,
    την αμοιβή ανά ώρα (double) και στη συνέχεια θα υπολογίζει την εβδομαδιαία αμοιβή. Αν η εβδομαδιαία εργασία είναι άνω των
    40 ωρών, τότε για τις ώρες πέρα των 40 ωρών η αμοιβή έχει προσαύξηση 50%.
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    double et_misth, amoibh, misthos_w;
    long kwd;
    int wres_ebd;

    printf("Dose ton kodiko: ");
    kwd = GetLong();
    if (kwd>=1000)
    {
        printf("Dose etisio mistho: ");
        et_misth = GetReal();
        amoibh = et_misth / 52;
    }
    else
    {
        printf("Dose tis wres ebdomadiaias ergasias: ");
        wres_ebd = GetInteger();
        printf("Dose tin amoivi ana wra: ");
        misthos_w = GetReal();
        amoibh = misthos_w * wres_ebd;
        if (wres_ebd > 40)
        {
        amoibh += (wres_ebd-40) * misthos_w * 0.5;
        }
    }
    printf("H ebdomadiaia amoivi einai %g\n",amoibh);

    return 0;

}



