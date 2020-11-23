/*  Αρχείο: a13f3.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να γραφεί πρόγραμμα που ζητά από τον χρήστη έναν ακέραιο Ν (όριο) και υπολογίζει το άθροισμα των Ν κλασμάτων
	∑ ( 1/ x ) , δηλαδή 1/1+1/2+1/3+...+1/Ν
   (προσοχή στις μετατροπές τύπων, το άθροισμα είναι τύπου float). Θεωρείστε ότι ο χρήστης εισάγει πάντα
   έναν ακέραιο μεγαλύτερο ή ίσο του 1 (δεν απαιτείται έλεγχος).
   Το αποτέλεσμα να εμφανιστεί με ακρίβεια 2 δεκαδικών ψηφίων.
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    int N, i;
    float sum;

    printf("Dose orio: ");
    N=GetInteger();
    sum = 0;

    for (i=1 ; i <= N ; i++ )
	{
        sum += (1.0/i);
	}

    printf("%.2f\n",sum);
    return 0;

}


