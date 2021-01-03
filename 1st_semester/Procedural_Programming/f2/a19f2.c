/*  Αρχείο: a19f2.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027
    
    Άδεια χρήσης: GNU General Public License v3.0

    Να γραφεί πρόγραμμα που να υπολογίζει τα τέλη κυκλοφορίας (float) με βάση τις εκπομπές CO2 (γραμμάρια, int) ως εξής:
	0-120 γρ./χλμ. -> 0,9 ευρώ/γρ.
	121-140 γρ./χλμ -> 1,1 ευρώ/γρ.
	> 140 γρ./χλμ. -> 1,7 ευρώ/γρ.
    Η χρέωση ΔΕΝ είναι κλιμακωτή.
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{

/* Δήλωση και αρχικοποίηση μεταβλητών */
    float teli;
    int dioksidio;

/* Εισαγωγή δεδομένων */
    printf("Dose gram CO2/khm: ");
    dioksidio = GetInteger();
    
/* Υπολογισμοί*/
    if (dioksidio <= 120)
    {
        teli = dioksidio * 0.9;
    }
    else
        if (dioksidio <= 140)
    {
        teli = dioksidio * 1.1;
    }
        else
        {
        teli = dioksidio * 1.7;
        }
        
/* Εκτύπωση αποτελεσμάτων */
    printf("To poso pliromis einai %.1f\n",teli);

    return 0;

}



