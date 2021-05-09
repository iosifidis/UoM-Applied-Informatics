/*  Αρχείο: a1f1.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Ένα σημαντικό πρόβλημα της θεωρίας αριθμών (του πεδίου των μαθηματικών που έχει ως αντικείμενο τη
    μελέτη των ιδιοτήτων των μη αρνητικών ακεραίων) είναι το πρόβλημα του προσδιορισμού του κατά πόσο
    ένας ακέραιος είναι πρώτος. Ένας θετικός ακέραιος n είναι πρώτος (prime) αν έχει ακριβώς δύο θετικούς
    διαιρέτες, τον εαυτό του και το 1. Οι πρώτοι αριθμοί είναι ιδιαίτερα σημαντικοί σήμερα για την
    κρυπτογραφία, αφού πολλές από τις καλύτερες τεχνικές κρυπτογράφησης βασίζονται στους πρώτους
    αριθμούς. Να γραφεί πρόγραμμα που θα περιλαμβάνει τα παρακάτω υποπρογράμματα:
     συνάρτηση isPrime που θα δέχεται ένα θετικό ακέραιο n και θα επιστρέφει την τιμή TRUE ή FALSE
    ανάλογα με το αν ο n είναι ή όχι αντίστοιχα πρώτος αριθμός
     διαδικασία createPrimeSet που θα δέχεται δύο θετικούς ακεραίους, έστω first και last, και θα
    δημιουργεί και επιστρέφει το σύνολο των πρώτων αριθμών που ανήκουν στο διάστημα [first .. last]
     διαδικασία displaySet που δέχεται τον πρώτο αριθμό first ενός συνόλου θετικών ακεραίων S και
    εμφανίζει τα στοιχεία του συνόλου στην ίδια γραμμή με ένα κενό χαρακτήρα μεταξύ τους.
    Στη συνέχεια, γράψτε κυρίως πρόγραμμα όπου θα διαβάζονται δύο ακέραιοι αριθμοί, έστω first και last,
    που θα πρέπει να ανήκουν στο διάστημα [2..200] και επιπλέον να ισχύει first < last. Στη συνέχεια, θα
    καλούνται οι διαδικασίες createPrimeSet και displaySet για τη δημιουργία και εμφάνιση του συνόλου των
    πρώτων αριθμών που ανήκουν στο διάστημα [first .. last].
    Να χρησιμοποιηθεί ο ΑΤΔ σύνολο με πίνακα. Η διαδικασία displaySet θα δέχεται ένα σύνολο θετικών
    ακεραίων S, τον πρώτο (first) και τον τελευταίο (last) αριθμό αυτού του συνόλου.
*/

#include <stdio.h>
#include <stdlib.h>

#define megisto_plithos 201
#define low 2
#define up 200

typedef enum {
    FALSE, TRUE
} boolean;

typedef boolean typos_synolou[megisto_plithos];
typedef int stoixeio_synolou;

boolean isPrime(stoixeio_synolou n);
void createPrimeSet(stoixeio_synolou first, stoixeio_synolou last,typos_synolou S);
void displaySet(stoixeio_synolou first,stoixeio_synolou last,typos_synolou S);

void Dimiourgia(typos_synolou synolo);
boolean Melos(stoixeio_synolou stoixeio, typos_synolou synolo);
void Eisagogi(stoixeio_synolou stoixeio, typos_synolou synolo);

int main()
{
    stoixeio_synolou first,last; //Ορισμός πρώτου και τελευταίου θετικού ακεραίου αριθμού
    typos_synolou S; // Ορισμός συνόλου

/* Εισαγωγή πρώτου ακεραίου αριθμού. Εκτέλεση τουλάχιστον μια φορά με το do, και έλεγχος να είναι μεγαλύτερο ή ίσο 
από το ελάχιστο που ορίσαμε (2) και να είναι first < last.
*/
    do{
        printf("\n");
        printf("DOSTE ARXIKH TIMH (APO 2 EOS 199 KAI PREPEI NA EINAI MIKROTERH THS TELIKHS TIMHS POY THA EISAGEIS META): ");
    	scanf("%d",&first);
    }while(!(first >= low && first < up));

/* Εισαγωγή δεύτερου ακεραίου αριθμού. Εκτέλεση τουλάχιστον μια φορά με το do, και έλεγχος να είναι μεγαλύτερο ή ίσο 
από το ελάχιστο που ορίσαμε (2) και να είναι μικρότερο ή ίσο από το ανώτερο όριο που ορίσαμε (200).
*/
    do{
        printf("\n");
        printf("DOSTE TELIKH TIMH (APO 2 EOS 200 KAI NA EINAI MEGALYTERH TOY %d): ",first);
    	scanf("%d",&last);
    }while(!(last >= low && last <= up) || !(first<last));

    printf("\n");
    createPrimeSet(first,last,S); // Δημιουργείται το σύνολο πρώτων αριθμών με όρια από τον first μέχρι τον last
    displaySet(first,last,S); // Εμφάνιση του συνόλου

    return 0;
}


/* ΣΥΝΑΡΤΗΣΕΙΣ */

// Ελέγχει αν ένας αριθμός είναι πρώτος ή όχι. Ένας θετικός ακέραιος n είναι πρώτος (prime) αν έχει ακριβώς δύο θετικούς διαιρέτες, τον εαυτό του και το 1.

boolean isPrime(stoixeio_synolou n)  
{
    stoixeio_synolou i; 
    boolean prime; // Boolean παίρνει τιμές TRUE,FALSE
    for (i = 2; i <= n / 2; i++) {
        prime=TRUE; // Υποθέτω ότι είναι πρώτος
        if (n % i == 0) {  // Εάν η πράξη mod του αριθμού με το i που αυξάνει κατά 1, είναι αληθής, τότε είναι πρώτος.
            prime=FALSE;
            break;
        }
    }
    return prime; // Επέστρεψε το True ή False
}

// Δημιουργεί το σύνολο με τους πρώτους αριθμούς

void createPrimeSet(stoixeio_synolou first, stoixeio_synolou last,typos_synolou S)
{
    Dimiourgia(S); // Δημιουργία συνόλου
    stoixeio_synolou i;
    for (i=first;i<=last;i++)
    {
        if (isPrime(i)) // Κάνει τον έλεγχο αν ο αριθμός είναι πρώτος ή όχι
        {
            Eisagogi(i, S); // Τον τοποθετεί μέσα στο σύνολο
        }
    }

}

void displaySet(stoixeio_synolou first,stoixeio_synolou last,typos_synolou S)
{
	stoixeio_synolou i;

	for (i=first;i <= last;i++)
	{
		if(Melos(i,S))
			printf("%d ",i);
	}
	printf("\n");
}

void Dimiourgia(typos_synolou synolo)
{
    stoixeio_synolou i;

    for (i = 0; i < megisto_plithos; i++)
        synolo[i] = FALSE;
}



boolean Melos(stoixeio_synolou stoixeio, typos_synolou synolo)
{
    return synolo[stoixeio];
}

void Eisagogi(stoixeio_synolou stoixeio, typos_synolou synolo)
{
    synolo[stoixeio] = TRUE;
}
