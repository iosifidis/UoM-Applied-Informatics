/*  Αρχείο: a28f4.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να γράψετε πρόγραμμα που θα διαβάζει τον κωδικό και την τιμή ενός αγνώστου πλήθους προϊόντων που
    αγόρασε κάποιος σε ένα πολυκατάστημα. Ο κωδικός θα πρέπει να είναι στο διάστημα [0..2000] και να γίνεται ο
    αντίστοιχος έλεγχος από το πρόγραμμα. Η είσοδος των δεδομένων (κωδικός και τιμή) θα συνεχίζεται μέχρι να
    δοθεί ως κωδικός το μηδέν.
    */

#include <stdio.h>
#include <math.h>
#include "simpio.h"
#include "genlib.h"

int get_code();
float discount_percentage(int code);
int product_points(int code, double fprice);

int main()
{
   int code, points;
   double price, discount, total, discountSum, finalPrice;

   points=0;
   total=0;
   discountSum=0;

   code=get_code();
   while (code!=0)
   {
      printf("Dose tin timi: ");
      price=GetReal();
      discount=discount_percentage(code)*price;
      discountSum+=discount;
      finalPrice=price-discount;
      total+=finalPrice;
      points+=product_points(code,finalPrice);   
      code=get_code(code);
    }

    printf("-------------------\n");
    printf("Teliko synolo: %.2f Euro\n",total);
    printf("Ekptwsi: %.2f Euro\n",discountSum);
    printf("Pontoi: %d\n",points);

    return 0;

}


int get_code()
{
    int code;
    printf("Dose ton kodiko: ");
    code=GetInteger();
    while (code<0 || code>2000)
      {
          printf("Lathos kodikos (0-2000): \n");
          printf("Dose ton kodiko: ");
          code=GetInteger();
       }
    return code;
}

float discount_percentage(int code)
{
	if (code<=300) return 0.05;
	if (code<=500) return 0.10;
	if (code<=1000) return 0.15;
	return 0.20;
}

int product_points(int code, double fprice)
{
    int points=1;
    if (code>=1000 && code<=1500)
    	points+=ceil(fprice/5);
    return points;

}
