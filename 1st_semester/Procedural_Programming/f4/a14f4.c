/*  Αρχείο: a14f4.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να γίνει πρόγραμμα το οποίο:
	 Θα διαβάζει τις τιμές τριών ακεραίων αριθμών a, b, c,
	 Θα υπολογίζει και θα εμφανίζει την τιμή της παράστασης (double):

	όπου max(a, b) είναι η συνάρτηση υπολογισμού του μεγίστου των αριθμών a και b
	και gr(a, b, c) η συνάρτηση υπολογισμού του μεγίστου τριών αριθμών a, b, c. Το
	διάβασμα των τριών αριθμών, ο υπολογισμός και εμφάνιση της τιμής της παράστασης θα
	γίνουν στο κυρίως πρόγραμμα, χρησιμοποιώντας τις συναρτήσεις max και gr που θα
	υλοποιήσετε ως συναρτήσεις στην C. Το αποτέλεσμα (y) θα εμφανίζεται με ακρίβεια 2 δεκαδικών ψηφίων.
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int max(int a, int b);
int gr(int a, int b, int c);

int main()
{
   int a, b, c;
   double y;

   printf("Dose a: ");
   a=GetInteger();
   printf("Dose b: ");
   b=GetInteger();
   printf("Dose c: ");
   c=GetInteger();
   // Υπολογισμός
   y = (2* max(a,b) + 3*gr(a,b,c)) / 4.0;
    // Έξοδος
    printf("y = %.2f\n",y);

    return 0;

}


int max(int a, int b)
{
  return (a>b) ? a : b;
}

int gr(int a, int b, int c)
{
  int megisto;
  megisto = max(a,b);
  return max(megisto,c);
}
