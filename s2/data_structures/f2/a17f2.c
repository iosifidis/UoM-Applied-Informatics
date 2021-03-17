/*  Αρχείο: a17f2.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Να υλοποιηθεί η συνάρτηση CopyStack η οποία θα δημιουργεί και θα επιστρέφει ένα αντίγραφο της δοσμένης
    στοίβας s1 αφήνοντας την αρχική στοίβα s1 αναλλοίωτη. Το πρωτότυπο της συνάρτησης είναι
                    StackType CopyStack(StackType *s1)
    Στο κυρίως πρόγραμμα δημιουργήστε τη στοίβα s1 εισάγοντας σ’ αυτή 20 αριθμούς. Για λόγους απλότητας
    μπορεί να χρησιμοποιηθεί ένας βρόχος for, σε κάθε επανάληψη του οποίου θα εισάγετε στη στοίβα την τιμής της
    μεταβλητής ελέγχου της for. Στη συνέχεια εμφανίστε το περιεχόμενο της στοίβας s1 (καλέστε τη βοηθητική
    συνάρτηση TraverseStack, η εμφάνιση των στοιχείων από τη θέση 0 .. Stack.top). Καλέστε την CopyStack και στη
    συνέχεια εμφανίστε τα στοιχεία της στοίβας s1 και τα στοιχεία της στοίβας s2. Δίνεται ένα στιγμιότυπο εκτέλεσης.

*/

#include <stdio.h>
#include <stdlib.h>

#define StackLimit 20   // το όριο μεγέθους της στοίβας

typedef int StackElementType;   // ο τύπος των στοιχείων  της στοίβας ενδεικτικά τύπος int

typedef struct  {
    int Top;
    StackElementType Element[StackLimit];
} StackType;

typedef enum {
    FALSE, TRUE
} boolean;

// Δήλωση συναρτήσεων
void TraverseStack(StackType Stack);
void CreateStack(StackType *Stack);
boolean EmptyStack(StackType Stack);
boolean FullStack(StackType Stack);
void Push(StackType *Stack, StackElementType Item);
void Pop(StackType *Stack, StackElementType *Item);
StackType CopyStack(StackType *s1);

int main()
{
    StackElementType i; // Δήλωση μεταβλητών
    StackType s1,s2; // Δήλωση στοιβών

    CreateStack(&s1); // Δημιουργία στοίβας s1

    // Γέμισμα στοίβας
    for (i=0;i<StackLimit;i++)
    {
    	Push(&s1, i);
    } 
    
    // Εκτύπωση στοίβας s1

    printf("Stack s1");
    TraverseStack(s1);
    
    // Αντιγραφή στοίβας s1 στην s2
    s2=CopyStack(&s1);
    
    // Εκτύπωση στοιβών μετά την αντιγραφή
    printf("After copying s1 to s2\n");
    
    // Εκτύπωση στοίβας s1
    printf("Stack s1");
    TraverseStack(s1);
    
    // Εκτύπωση στοίβας s2
    printf("Stack s2");
    TraverseStack(s2);


    return 0;
}

// ΣΥΝΑΡΤΗΣΕΙΣ

StackType CopyStack(StackType *s1)
{
    StackElementType temp; // Δήλωση μεταβλητών
    StackType TempStack,s2; // Δήλωση στοίβών
    
    CreateStack(&s2); // Δημιουργία στοίβας s2
    CreateStack(&TempStack); // Δημιουργία στοίβας TempStack
    
    while(!EmptyStack(*s1)) // Όσο η στοίβα s1 δεν είναι κενή, κάνε τα παρακάτω
    {
        Pop(&(*s1),&temp); // Απώθηση στοιχείου και αποθήκευση στην μεταβλητή temp
        Push(&TempStack,temp); // Ώθηση στοιχείου στην στοίβα TempStack
    }
    
    while(!EmptyStack(TempStack)) // Όσο η στοίβα TempStack δεν είναι κενή, κάνε τα παρακάτω
    {
        Pop(&TempStack,&temp); // Απώθηση στοιχείου και αποθήκευση στην μεταβήτή temp
        Push(&(*s1),temp); // Ώθηση στοιχείου temp στην στοίβα s1 (pointer της στοίβας s1)
        Push(&s2,temp); // Ώθηση στοιχείου temp στην στοίβα s2
    }
    return s2;
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

/*
// ΑΥΤΗ Η ΕΚΔΟΣΗ ΕΜΦΑΝΙΖΕΙ ΤΑ ΣTOIXEIA ΤΗΣ ΣΤΟΙΒΑΣ ΑΠΟ ΤΗ ΘΕΣΗ TOP-0

void TraverseStack(StackType Stack)
{
    int i;
    printf("\nplithos sto stack %d\n",Stack.Top+1);
    for (i=Stack.Top;i>=0;i--) {
        printf("%d ",Stack.Element[i]);
    }
    printf("\n");
}
*/

 // ΑΥΤΗ Η ΕΚΔΟΣΗ ΕΙΝΑΙ ΣΤΙΣ ΣΗΜΕΙΩΣΕΙΣ ΚΑΙ ΕΜΦΑΝΙΖΕΙ ΤΑ STOIXEIA ΤΗΣ ΣΤΟΙΒΑΣ ΑΠΟ ΤΗ ΘΕΣΗ 0-TOP
 void TraverseStack(StackType Stack)
{
    int i;
    printf("\nplithos sto stack %d\n",Stack.Top+1);
    for (i=0;i<=Stack.Top;i++) {
        printf("%d ",Stack.Element[i]);
    }
    printf("\n");
}
