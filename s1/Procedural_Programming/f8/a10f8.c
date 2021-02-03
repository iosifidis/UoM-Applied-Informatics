/*  Αρχείο: a10f8.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Σε ένα ημερολόγιο ενός έργου καταγράφονται διάφορα πακέτα εργασίας. Κάθε εργασία έχει όνομα name
    (char name [60]), μήνα έναρξης (int) όπως μετράται από την αρχή του έργου και διάρκεια σε μήνες
    (int). Για παράδειγμα:
    • η εργασία “project specifications” έχει χρόνο έναρξης 0 (ξεκινά τον πρώτο μήνα του έργου) και
    διάρκεια 4 μήνες, οπότε θεωρείται ότι ολοκληρώνεται τον 4 μήνα.
    • η εργασία “implementation” έχει χρόνο έναρξης 2 και διάρκεια 8 μήνες, οπότε θεωρείται ότι
    ολοκληρώνεται τον 10 μήνα (10 = 8 + 2)
    (α) Να ορίσετε κατάλληλη δομή (νέο τύπο) η οποία να αποθηκεύει τα στοιχεία των εργασιών.
    (β) Να ορίσετε ένα πρόγραμμα το οποίο:
    • Zητά από τον χρήστη τον συνολικό αριθμό εργασιών του έργου WP
    • Mέσω μιας συνάρτησης ReadWorkpackages ζητά από τον χρήστη τα στοιχεία των WP εργασιών
    (όνομα, χρόνο έναρξης και διάρκεια)
    • Βρίσκει ποια εργασία ξεκινά πρώτη μέσω της συνάρτησης FindFirstWp, η οποία επιστρέφει την
    δομή της πρώτης χρονικά εργασίας.
    • Τυπώνει τα στοιχεία της πρώτης χρονικά εργασίας στην οθόνη μέσω της συνάρτησης main().
    • Βρίσκει την συνολική διάρκεια του έργου (makespan) μέσω της συνάρτησης FindMakespan. Η
    συνολική διάρκεια του έργου ορίζεται ως ο μήνας στον οποίο ολοκληρώνεται η τελευταία εργασία
    (έχουν τελειώσει όλες οι εργασίες).
    • Εμφανίζει την συνολική διάρκεια του έργου στην οθόνη.
    Για να γίνουν τα παραπάνω θα πρέπει να ορίσετε κατάλληλο πίνακα δομών με μέγεθος τουλάχιστον 100.
    Θεωρείστε ότι ο χρήστης (α) δεν θα εισάγει περισσότερες από 100 εργασίες (δεν απαιτείται έλεγχος),
    (β) θα εισάγει πάντα ως χρόνο έναρξης ένα μη-αρνητικό ακέραιο (δεν απαιτείται έλεγχος)
    (γ) ότι θα εισάγει πάντα ως διάρκεια ένα θετικό ακέραιο (δεν απαιτείται έλεγχος) και
    (δ) τα ονόματα των εργασιών είναι αυστηρά μικρότερα των 60 χαρακτήρων (δεν απαιτείται έλεγχος).

*/

#include <stdio.h>
#include <string.h>
#include "simpio.h"

#define N 100

/* Δημιουργία δομών */
typedef struct
{
    char name [60];
    int month;
    int duration;
} TaskT;

/* Πρωτότυπα συναρτήσεων */
void ReadWorkpackages(int ergasies, TaskT tasks[]);
TaskT FindFirstWp(int ergasies, TaskT tasks[]);
int FindMakespan(int ergasies, TaskT tasks[]);

int main()
{
    TaskT tasks[N];
	TaskT first;

	int ergasies;
	printf("Total work packages: ");
	ergasies=GetInteger();

	ReadWorkpackages(ergasies, tasks);
	first=FindFirstWp(ergasies, tasks);
//	duration=FindMakespan(ergasies, tasks);
	printf("FIRST WP: %s start: %d duration: %d\n",first.name, first.month, first.duration);
	printf("Total duration = %d", FindMakespan(ergasies, tasks));

    return 0;
}


/* Συναρτήσεις */

/* Ανάγνωση στοιχείων εργασίας */
void ReadWorkpackages(int ergasies, TaskT tasks[])
{
	int i;
	for(i=0;i<ergasies;i++){
            printf("WP Name: ");
        	gets(tasks[i].name);
        	printf("WP Start Month: ");
        	tasks[i].month=GetInteger();
	        printf("WP Duration: ");
	        tasks[i].duration=GetInteger();
	}
}

/* Εύρεση εργασίας που εκκινεί πρώτη */
TaskT FindFirstWp(int ergasies, TaskT tasks[])
{
	int i;
	TaskT first;

	first=tasks[0];

	for(i=0;i<ergasies;i++)
	{
		if(first.month > tasks[i].month)
		{
			first=tasks[i];

	}
	return first;

}}

/* Εύρεση συνολικής διάρκειας έργου */
int FindMakespan(int ergasies, TaskT tasks[])
{
	int i, max;
	max=tasks[0].month+tasks[0].duration;
	for(i=0;i<ergasies;i++)
	{
		if(tasks[i].month+tasks[i].duration>max)
		{
			max=tasks[i].month+tasks[i].duration;
		}
	}
	return max;
}

