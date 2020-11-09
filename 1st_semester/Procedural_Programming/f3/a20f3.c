/*  Αρχείο: a20f3.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Γράψτε ένα πρόγραμμα που να διαβάζει μια σειρά από ηλικίες ανθρώπων (ακολουθία αριθμών int που εισάγεται από το χρήστη)
    και να βρίσκει την μικρότερη και τη μεγαλύτερη ηλικία. Το πρόγραμμα θα συνεχίζει να διαβάζει ηλικίες μέχρι να δοθεί ως ηλικία
     ο αριθμός -1
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    int ilikia, min, max;

    printf("Dose ilikia: ");
    ilikia=GetInteger();
    min = ilikia;
    max = ilikia;

    while (ilikia != -1 )
    {

    	if (ilikia >= max)
    	{
    		max = ilikia;
    	}
    	if (ilikia <=min)
    	{
    		min = ilikia;
    	}

    	printf("Dose ilikia. Me -1 stamatas eisagwgi: ");
    	ilikia=GetInteger();
    }
    printf("H megaliteri ilikia einai: %d\n",max);
    printf("H mikroteri ilikia einai: %d\n",min);
    return 0;

}



