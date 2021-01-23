/*  Αρχείο: a8f8.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Να γραφεί ένα πρόγραμμα που να περιλαμβάνει μια δομή box, η οποία αναπαριστά ορθογώνια παραλληλεπίπεδα,
    και περιλαμβάνει πέντε ακέραια πεδία: width (πλάτος), height (ύψος), depth (βάθος), area (επιφάνεια)
    και volume (όγκος). Το πρόγραμμα θα περιλαμβάνει τις παρακάτω συναρτήσεις:
    - Μια συνάρτηση που να ζητά από το χρήστη τις διαστάσεις του κουτιού σε cm (μη-αρνητικοί ακέραιοι –
    δεν απαιτείται έλεγχος), δηλαδή το πλάτος, ύψος και βάθος (width, height, depth) και θα επιστρέφει
    δομή box με τα αντίστοιχα τρία πεδία συμπληρωμένα.
    - Μια void συνάρτηση που να υπολογίζει το συνολικό εμβαδόν όλων των πλευρών του κουτιού (πεδίο area).
    H συνάρτηση θα ενημερώνει το αντίστοιχο πεδίο της δομής.
    - Μια void συνάρτηση που να υπολογίζει τον όγκο (πεδίο volume) του κουτιού. H συνάρτηση θα ενημερώνει
    το αντίστοιχο πεδίο της δομής.
    - Οι δύο παραπάνω τιμές (area και volume) θα τυπώνονται από τη συνάρτηση main.
    Και οι τρεις συναρτήσεις να δέχονται ως παράμετρο έναν δείκτη στη δομή box.

*/

#include <stdio.h>
#include "simpio.h"

/* Δημιουργία δομών */
typedef struct
{
    int width;
    int height;
    int depth;
    int area;
    int volume;
} boxT;

/* Πρωτότυπα συναρτήσεων */
boxT readBox(boxT box);
void calculateArea(boxT *box);
void calculateVolume(boxT *box);

int main()
{
    boxT box = {0,0,0,0,0};

    box=readBox(box);

    calculateArea(&box);
    calculateVolume(&box);

    printf("To emvadon tou koutiou einai %d cm2\n", box.area);
    printf("O ogos tou koutiou einai %d cm3\n", box.volume);

    return 0;
}


/* Συναρτήσεις */

/* Ανάγνωση διαστάσεων δοχείου*/
boxT readBox(boxT box)
{
	printf("Dose to mikos tou koutiou se cm: ");
	box.width=GetInteger();
	printf("Dose to ypsos tou koutiou se cm: ");
	box.height=GetInteger();
	printf("Dose to vathos tou koutiou se cm: ");
	box.depth=GetInteger();
	box.area=0;
	box.volume=0;
	return box;
}

/* Υπολογισμός συνολικού εμβαδού */
void calculateArea(boxT *box)
{
    box->area = 2*(box->width * box->height + box->height * box->depth + box->depth * box->width);
}

/* Υπολογισμος όγκου */
void calculateVolume(boxT *box)
{
    box->volume = box->width * box->height * box->depth;
}
