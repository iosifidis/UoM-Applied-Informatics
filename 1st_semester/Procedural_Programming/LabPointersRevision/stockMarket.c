/* Stock Market Analysis
 */

#include <stdio.h>


int main(){
   float stock_prices[10] = {34.5, 22.4, 77.8, 22.1, 10.0, 11.25, 12, 13, 16, 20.5 };
   float deriv_prices[5] = {30.5, 21.4, 89.8, 20.1, 10.0};
   float cds_prices[11] = {38.5, 33.4, 67.8, 12.1, 16.0, 10.25, 11, 23, 36, 10.1 ,30.4};
   int risk[11] = {90,10,20,30,50,60,30,30,30,10,10};

   float deriv_day_data[5][10] = {
                {30.5,25,22,32.3,30.5,32.6,38.9,40,22,30.5},
                {22.5,21.4,14,40.3,22.5,12.6,38.9,40,39,21.4},
                {30.5,25,22,89.8,34.5,89.8,38.9,40,30,89.8},
                {20.2,35,20.1,12.3,20.1,32.6,38.9,40,22,20.1},
                {45.5,10.0,22,10.0,14.5,23.6,48.9,8,10.0,10.0}
   };


   float interesting_stock[10];
   int ni_stock;
   float interesting_cds[11];
   int ni_cds;

   int i;
   float max_stock, max_deriv, max_cds;


   /* Calculating Max Values */
   max_stock = stock_prices[0];
   for(i=1;i<10;i++)
     if (stock_prices[i] > max_stock) {max_stock = stock_prices[i];}

   max_deriv = deriv_prices[0];
   for(i=1;i<5;i++)
     if (deriv_prices[i] > max_deriv) {max_deriv = deriv_prices[i];}

   max_cds = cds_prices[0];
   for(i=1;i<11;i++)
     if (cds_prices[i] > max_cds) {max_cds = cds_prices[i];}

   /* Finding Interesting Values */
   ni_stock=0;
   for(i=0;i<10;i++)
      if (stock_prices[i] > max_stock / 2)
          {interesting_stock[ni_stock++] = stock_prices[i];}

   ni_cds=0;
   for(i=0;i<11;i++)
      if (cds_prices[i] > max_cds / 2)
          {interesting_cds[ni_cds++] = cds_prices[i];}


   /* Printing */

   printf("Stock Prices.\n");

   for(i=0;i<30;i++) printf("-");
   printf("\n");

   printf("Max Price:: %4.2f \n",max_stock);
    for(i=0;i<10;i++)
      printf("%s(%3.2f) ",(max_stock == stock_prices[i] ? "-Max-" : ""),stock_prices[i]);
   printf("\n");

   printf("Interesting Stock Prices:");
   for(i=0;i<ni_stock;i++) printf("[%4.2f] ",interesting_stock[i]);
   printf("\n");

   for(i=0;i<10;i++) printf("-");
   printf("\n");

   /* Derivatives */
   printf("Derivative Prices.\n");

   for(i=0;i<30;i++) printf("-");
   printf("\n");

   printf("Max Price:: %4.2f \n",max_deriv);
    for(i=0;i<5;i++)
      printf("%s(%3.2f) ",(max_deriv == deriv_prices[i] ? "-Max-" : ""),deriv_prices[i]);
   printf("\n");

   for(i=0;i<10;i++) printf("-");
   printf("\n");

   /* Cds Prices */

   printf("CDS Prices.\n");

   for(i=0;i<30;i++) printf("-");
   printf("\n");

   printf("Max Price:: %4.2f \n",max_cds);
    for(i=0;i<11;i++)
       printf("%s(%3.2f) ",(max_cds == cds_prices[i] ? "-Max-" : ""),cds_prices[i]);
   printf("\n");

   printf("Interesting CDS Prices:");
   for(i=0;i<ni_cds;i++) printf("[%4.2f] ",interesting_cds[i]);
   printf("\n");

   for(i=0;i<10;i++) printf("-");
   printf("\n");

   return 0;
}
