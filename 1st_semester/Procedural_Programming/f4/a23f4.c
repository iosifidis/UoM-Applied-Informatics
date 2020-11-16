/*  Αρχείο: a23f4.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Γράψτε πρόγραμμα που περιλαμβάνει μια συνάρτηση με το όνομα Valid_Time η οποία θα δέχεται ως τυπικές παραμέτρους
    3 ακέραιους αριθμούς (int) που αντιστοιχούν σε ώρες, λεπτά και δευτερόλεπτα μιας χρονικής στιγμής της ημέρας (ώρα)
    και θα επιστρέφει την τιμή ΤRUΕ ή FΑLSΕ ανάλογα με το αν η δοθείσα χρονική στιγμή (ώρα) είναι έγκυρη ή όχι
    (αν δηλαδή οι ώρες θα πρέπει να είναι από 0 έως και 23 και τα λεπτά και δευτερόλεπτα να είναι από 0 έως και 59).
    Τα δεδομένα (ώρες, λεπτά και δευτερόλεπτα) θα ζητούνται από τον χρήστη στο κυρίως πρόγραμμα, όπως φαίνεται στα ακόλουθα παραδείγματα.
    Στο τέλος το πρόγραμμα θα εμφανίζει το μήνυμα “WRA EGKYRH” ή “WRA MH EGKYRH” από το κυρίως πρόγραμμα (συνάρτηση main(), δηλαδή η εντολή
    εμφάνισης του μηνύματος (printf) θα είναι στην main).
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

bool Valid_Time(int hour, int min, int sec);

int main()
{
    int ora,lept,deft;
    printf("Dose tis ores: ");
    ora=GetInteger();
    printf("Dose ta lepta: ");
    lept=GetInteger();
    printf("Dose ta defterolepta: ");
    deft=GetInteger();


    if (Valid_Time(ora,lept,deft))
    {
    printf("WRA EGKYRH");
    }
    else
    {
    printf("WRA MH EGKYRH");
    }
    return 0;

}

bool Valid_Time(int hour, int min, int sec)
{
    return ((hour>=0 && hour<23) && (min>=0 && min<59) && (sec>=0 && sec<59)) ? TRUE : FALSE;
//    if ((hour>=0 && hour<23) && (min>=0 && min<59) && (sec>=0 && sec<59))
//    { return TRUE;
//    }
//    else
//    { return FALSE;
//    }
}
