/*  Αρχείο: a4f1.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027
    
    Άδεια χρήσης: GNU General Public License v3.0

    Ένας έμπορος αγόρασε σε τιμή χονδρικής εμπορεύματα αξίας purchaseAmount € και τα πούλησε saleAmount €.
    Αν το ποσό saleAmount προκύπτει από την καθαρή αξία purchaseAmount και το ποσοστό κέρδους rate
    του εμπόρου επί της καθαρής αξίας purchaseAmount, να γίνει πρόγραμμα που να υπολογίζει και να εμφανίζει:
    α) το κέρδος του εμπόρου profit (double),
    β) το εισπραχθέν ποσό saleAmount (double).
    Τα δεδομένα εισόδου να έχουν τη μορφή:
    purchaseAmount (μεταβλητή τύπου long)
    rate (μεταβλητή τύπου int, εάν το ποσοστό κέρδους είναι 10% τότε πληκτρολογούμε 10)
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{

/* Δήλωση-Αρχικοποίηση μεταβλητών */
    int rate;
    double profit, saleAmount;
    long purchaseAmount;

/* Εισαγωγή δεδομένων */
    printf("Dose kathari aksia: ");
    purchaseAmount = GetLong();
    printf("Dose to pososto kerdous: ");
    rate = GetInteger();

/* Υπολογισμός και εκτύπωση αποτελέσματος */
    profit = (double) rate / 100 * purchaseAmount;
    printf("To kerdos einai %g\n", profit);
    saleAmount = purchaseAmount + profit;
    printf("To sinoliko poso einai %g\n", saleAmount);
    return 0;

}



