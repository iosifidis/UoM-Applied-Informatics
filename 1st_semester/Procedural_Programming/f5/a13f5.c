/*  Αρχείο: a13f5.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Να γραφεί πρόγραμμα το οποίο:
    (α) Θα ζητά από τον χρήστη δύο θετικούς ακέραιους αριθμούς R (γραμμές) και C (στήλες) από το 1 μέχρι
    και το 10. Μπορείτε να υποθέσετε με ασφάλεια ότι ο χρήστης θα εισάγει σωστούς αριθμού σύμφωνα με τα
    προηγούμενα όρια. Δεν απαιτείται έλεγχος. Η εισαγωγή θα γίνεται από την συνάρτηση main.
    (β) Θα "γεμίζει" τα στοιχεία R x C ενός διδιάστατου πίνακα Α ακεραίων (διάστασης 10x10) με τυχαίους
    ακέραιους από 0 έως και 99 (rand() % 100), μέσω κλήσης μιας συνάρτησης populate_data.
    Δηλαδή το πρόγραμμα θα χρησιμοποιεί μέρος του πίνακα Α, βάσει των αριθμών R και C, που εισήγαγε ο χρήστης.
    (γ) Θα καλεί μια συνάρτηση print_array που θα τυπώνει τα R x C στοιχεία του πίνακα Α.
    (δ) Θα καλεί μια διαδικασία change_array, η οποία για κάθε γραμμή του πίνακα Α θα θέτει όσα
    στοιχεία είναι αριστερά του μέγιστου της γραμμής ίσα με αυτό (δηλαδή όσα είναι στην ίδια γραμμή με αυτό,
    αλλά έχουν μικρότερο δείκτη στήλης θα γίνουν ίσα με το μέγιστο).
    (ε) Τέλος, θα εμφανίζονται και πάλι τα στοιχεία του "αλλαγμένου" πίνακα κατά γραμμές.
    Όλες οι συναρτήσεις σας θα ακολουθούν το πρότυπο C99 για πίνακες 2 διαστάσεων. ΠΡΟΣΟΧΗ στις δηλώσεις των παραμέτρων των συναρτήσεων.
    Είναι άλλο η διάσταση του πίνακα, και άλλο ποιο μέρος του πίνακα έχει χρησιμοποιηθεί. θα πρέπει να περάσετε περισσότερες παραμέτρους.

    Άδεια χρήσης: GNU General Public License v3.0

*/

#include <stdio.h>
#include <stdlib.h>
#include "genlib.h"
#include "simpio.h"

#define r 10
#define c 10

void populate_data(int row, int col, int A[row][col]);
void print_array(int row, int col, int A[row][col]);
void change_array(int row, int col, int A[row][col]);

int main()
{
    int A[r][c];
    int i, j, R, C;

	/*Read Data*/
	printf("Dwse ton arithmo twn grammwn: ");
	R=GetInteger();
	printf("Dwse ton arithmo twn sthlwn: ");
	C=GetInteger();

	/* Create the table A */
	populate_data(R, C, A);

    /*Printing initial table*/
   	printf("ARXIKOS PINAKAS\n");
    print_array(R,C,A);

   	change_array(R, C, A);

    /*Printing changed table*/
   	printf("TELIKOS PINAKAS\n");
   	print_array(R,C,A);

    return 0;
}

void populate_data(int row, int col, int A[row][col])
{
    int i, j;
    for (i=0; i<row; i++)
    {
        for (j=0; j<col; j++)
        {
            A[i][j] = rand()%100;
        }
    }
}

void print_array(int row, int col, int A[row][col])
{
    int i, j;
    for (i=0; i<row; i++)
    {
        for(j=0; j<col; j++)
        {
            printf("%d ",A[i][j]);
        }
        printf("\n");
    }
}

void change_array(int row, int col, int A[row][col])
{
    int i, j, max, k;
    for (i=0; i<row; i++)
    {
        max = A[i][0];
        k=0;
        for (j=1; j<col; j++)
        {
            if (A[i][j]>max)
            {
                max = A[i][j];
                k=j;
            }
        }
        for (j=0; j<k; j++)
        {
            A[i][j] = max;
        }
    }
}
