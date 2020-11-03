/*
 * File name: a1f0.c
 * ----------------------
 * This program adds two numbers, printing
 * their sum in the end.
 */

 #include <stdio.h>
 #include "genlib.h"
 #include "simpio.h"

 int main()
 {
 		int n1, n2, total;

 		printf("This program adds two numbers.\n");
 		total = 0;
 		printf("Please, give the 1st number: ");
 		n1 = GetInteger();
 		printf("Please, give the 2nd number: ");
 		n2 = GetInteger();
 		total = n1 + n2;
 		printf("The total is %d\n", total);
 		return 0;

 }
