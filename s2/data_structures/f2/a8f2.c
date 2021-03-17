/*  Αρχείο: a8f2.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Γράψτε ένα πρόγραμμα που θα δέχεται ένα αλφαριθμητικό, διαβάζοντας το χαρακτήρα προς χαρακτήρα (μέχρι ο
    χρήστης να δώσει ως χαρακτήρα #) και θα ελέγχει αν το αλφαριθμητικό που έχει σχηματιστεί, έχει τη μορφή
                                                    x C y
    όπου x είναι ένα αλφαριθμητικό και y είναι το αντίστροφο του x. Για παράδειγμα, αν x = ‘ΑΒΑΒΒΑ’ τότε 
    y = ‘ABBABA’. Ο έλεγχος θα γίνεται κατά το διάβασμα του κάθε χαρακτήρα. Το πρόγραμμα θα σταματάει να διαβάζει
    χαρακτήρες είτε όταν δοθεί ο χαρακτήρας ‘#’, είτε μόλις διαπιστώσει ότι το αλφαριθμητικό δεν ακολουθεί την
    επιθυμητή μορφή. Πριν τερματίσει θα εμφανίζει το μήνυμα TRUE ή FALSE αντίστοιχα αν το αλφαριθμητικό έχει ή
    όχι αυτή τη μορφή.
    Υπόδειξη: οι χαρακτήρες που θα διαβαστούν μέχρι να δοθεί ο χαρακτήρας ‘C’ εισάγονται σε μια στοίβα και κάθε
    χαρακτήρας που διαβάζεται μετά τον ‘C’ συγκρίνεται με το στοιχείο που βρίσκεται στην κορυφή της στοίβας. Για το
    διάβασμα κάθε χαρακτήρα χρησιμοποιείστε : scanf("%c", &ch); getchar();

*/
#include <stdio.h>
#include <stdlib.h>

#define StackLimit 50  // το όριο μεγέθους της στοίβας

typedef char StackElementType; // ο τύπος των στοιχείων  της στοίβας είναι τύπος char

typedef struct  {
    int Top;
    StackElementType Element[StackLimit];
} StackType;

typedef enum {
    FALSE, TRUE
} boolean;

// Δήλωση συναρτήσεων
void CreateStack(StackType *Stack);
void Push(StackType *Stack, StackElementType Item);
void Pop(StackType *Stack, StackElementType *Item);
boolean FullStack(StackType Stack);
boolean EmptyStack(StackType Stack);

int main()
{
    StackElementType item, ch; // Δήλωση μεταβλητών
    StackType MyStack; // Δήλωση στοίβας
    boolean flag, valid; // Δήλωση σημαιών

    flag=FALSE; // Αρχικοποίηση σημαίας
    valid=TRUE; // Αρχικοποίηση σημαίας
    CreateStack(&MyStack); // Δημιουργία στοίβας

    // Εισαγωγή γραμμάτων
    printf("Enter string:\n");
    scanf("%c", &ch); getchar();

    if(ch=='#') return 0; // Αν εισάγει τον χαρακτήρα # τότε τερματίζει το πρόγραμμα
    while(ch!='#' && valid) // Εάν δώσει έγκυρο χαρακτήρα να ξεκινήσει την εισαγωγή και τους ελέγχους
    {
        if(!flag){
            if(ch=='C') /* Εάν ο χαρακτήρας που εισήχθη είναι ο C να σταματήσει την εισαγωγή στην στοίβα και να ξεκινήσει τους ελέγχους */
            {
                flag=TRUE; // Αλλαγή της σημαίας flag σε TRUE για να δηλώσει ότι τελείωσε η εισαγωγή στην στοίβα
                scanf("%c", &ch); getchar(); // Εισαγωγή χαρακτήρων προς έλεγχο στην στοίβα
            }
            else // Αν ο χαρακτήρας δεν είναι C
            {
                Push(&MyStack, ch); // Ώθηση χαρακτήρα στην στοίβα
                scanf("%c", &ch); getchar(); /* Εισαγωγή επόμενου χαρακτήρα για ώθηση ή το C για τερματισμό ώθησης ή # για τερματισμό προγράμματος */
            }
        }
        else{
            if(!EmptyStack(MyStack)) // Εάν η στοίβα δεν είναι κενή
            {
                Pop(&MyStack, &item); // Απώθηση του χαρακτήρα
                if(item!=ch) {valid=FALSE;} /* Έλεγχος αν ο χαρακτήρας είναι διαφορετικός από αυτόν που εισήχθη, άλλαξε την σημαία valid σε FALSE */
                else {scanf("%c", &ch); getchar();} /* Εισαγωγή χαρακτήρων προς έλεγχο στην στοίβα αφού έχει εισαχθεί ο χαρακτήρας C πιο πάνω */
            }
            else {valid=FALSE;} /* Εαν η στοίβα είναι κενή, αλλαξε την σημαία valid σε FALSE */
        }
    }

    if(valid && EmptyStack(MyStack)) {printf("TRUE\n");} // Εκτύπωση αν η σημαία valid είναι TRUE και η στοίβα είναι άδεια
    else {printf("FALSE\n");} // Εκτύπωση σε κάθε άλλη περίπτωση

    return 0;

}


// ΣΥΝΑΡΤΗΣΕΙΣ

void CreateStack(StackType *Stack)
/* Λειτουργία: Δημιουργεί μια κενή στοίβα.
   Επιστρέφει: Κενή Στοίβα.*
*/
{
    Stack -> Top = -1;
   // (*Stack).Top = -1;
}

boolean EmptyStack(StackType Stack)
/* Δέχεται: Μια στοίβα Stack.
   Λειτουργία: Ελέγχει αν η στοίβα Stack είναι κενή.
   Επιστρέφει: True αν η Stack είναι κενή, False διαφορετικά
*/
{
    return (Stack.Top == -1);
}

boolean FullStack(StackType Stack)
/* Δέχεται: Μια στοίβα Stack.
   Λειτουργία: Ελέγχει αν η στοίβα Stack είναι γεμάτη.
   Επιστρέφει: True αν η Stack είναι γεμάτη, False διαφορετικά
*/
{
    return (Stack.Top == (StackLimit - 1));
}

void Push(StackType *Stack, StackElementType Item)
/* Δέχεται: Μια στοίβα Stack και ένα στοιχείο Item.
   Λειτουργία: Εισάγει το στοιχείο Item στην στοίβα Stack αν η Stack δεν είναι γεμάτη.
   Επιστρέφει: Την τροποποιημένη Stack.
   Έξοδος: Μήνυμα γεμάτης στοίβας, αν η στοίβα Stack είναι γεμάτη
*/
{
    if (!FullStack(*Stack)) {
        Stack -> Top++;
        Stack -> Element[Stack -> Top] = Item;
    } else
        printf("Full Stack...");
}

void Pop(StackType *Stack, StackElementType *Item)
/* Δέχεται: Μια στοίβα Stack.
   Λειτουργία: Διαγράφει το στοιχείο Item από την κορυφή της Στοίβας αν η Στοίβα δεν είναι κενή.
   Επιστρέφει: Το στοιχείο Item και την τροποποιημένη Stack.
   Έξοδος:  Μήνυμα κενής στοίβας αν η Stack είναι κενή
*/
{
    if (!EmptyStack(*Stack)) {
        *Item = Stack -> Element[Stack -> Top];
        Stack -> Top--;
    } else
        printf("Empty Stack...");
}
