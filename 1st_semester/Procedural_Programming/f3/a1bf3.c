/*  Αρχείο: a1bf3.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να γράψετε πρόγραμμα για κάθε μία από τις παρακάτω περιπτώσεις:
    a. Ο σημερινός αριθμός αυτοκινήτων που κυκλοφορούν σε μια πόλη είναι 80000. Αν ο αριθμός αυτός αυξάνεται με ρυθμό 7%,
    να γραφεί πρόγραμμα που να υπολογίζει σε πόσα χρόνια ο αριθμός των αυτοκινήτων θα ξεπεράσει τις 160000.
    Πόσα θα είναι τότε τα αυτοκίνητα;
    b. Γενικεύστε το πρόγραμμα για Αrithmo_Αytok (long) αυτοκίνητα, που αυξάνονται με ετήσιο ρυθμό Rythmos και ξεπερνούν
    ένα δοσμένο όριο Οrio (long), στοιχεία τα οποία θα εισάγει ο χρήστης.
    Τα προγράμματα a και b να εμφανίζουν τα έτη (long) και τον αριθμό των αυτοκινήτων (long) όταν θα ξεπεράσει το δοσμένο όριο.
    Για τον υπολογισμό του ετήσιου αριθμού αυτοκινήτων να χρησιμοποιηθεί ο τύπος:
	Αριθμός αυτοκινήτων = ceil(Αριθμός αυτοκινήτων *(1+Ρυθμός αύξησης))
    */

#include <stdio.h>
#include <math.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    long xronia, Arithmo_Aytok, Orio;
    double Rythmos;

    printf("Dose ton arxiko arithmo autokiniton: ");
    Arithmo_Aytok=GetLong();
    printf("Dose ton etisio ruthmo ayxisis: ");
    Rythmos=GetReal();
    printf("Dose to orio: ");
    Orio=GetLong();

    xronia = 0;

    while (Arithmo_Aytok <= Orio)
    {
        Arithmo_Aytok= ceil(Arithmo_Aytok * (1+ Rythmos));
        xronia +=1;
    }
    printf("%ld\n",xronia);
    printf("%ld\n",Arithmo_Aytok);
    return 0;

}



