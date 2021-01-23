/*  Αρχείο: a20f5.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να γραφεί ένα πρόγραμμα το οποίο να διαβάζει 5 ακεραίους και να τους αποθηκεύει σε έναν πίνακα. Στη
    συνέχεια, το πρόγραμμα να περιστρέφει τα στοιχεία του πίνακα μία θέση δεξιά και θα τυπώνει τον πίνακα
    στην οθόνη. Για παράδειγμα, αν τα στοιχεία του πίνακα είναι: 1, -9, 5, 3, 4 ο πίνακας μετά την περιστροφή
    θα είναι: 4, 1, -9, 5, 3. Η εκτέλεση φαίνεται παρακάτω.

*/

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

#define NUM 5 // Numbers


int main()
{
   int NUMBERS[NUM], i, temp;

   /* Read 5 numbers */
   for (i=0; i<NUM; i++){
            printf("Enter number: ");
            NUMBERS[i]=GetInteger();
  }
   /* Rotate */
   temp = NUMBERS[NUM-1];
   for (i=NUM-1;i>0;i--)
   {
        NUMBERS[i] = NUMBERS[i-1];
   }
   NUMBERS[0]=temp;
   for (i=0;i<NUM;i++)
   {
        printf("%d ",NUMBERS[i]);
   }
   return 0;

}
