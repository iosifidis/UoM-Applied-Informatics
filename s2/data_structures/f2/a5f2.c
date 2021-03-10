/*  Αρχείο: a5f2.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Χρησιμοποιήστε τις λειτουργίες που έχουν οριστεί στον ΑΤΔ στοίβα υλοποίηση με πίνακα και γράψτε στο κυρίως
    πρόγραμμα κώδικα για κάθε μία από τις παρακάτω λειτουργίες:
    (a) Θέστε στη μεταβλητή x την τιμή του δεύτερου στοιχείου από την κορυφή της στοίβας, αφήνοντας τη
    στοίβα χωρίς τα δύο πρώτα στοιχεία της κορυφής.
    (b) Θέστε στη μεταβλητή x την τιμή του δεύτερου στοιχείου από την κορυφή της στοίβας, αφήνοντας τη
    στοίβα αμετάβλητη (δεν θα διαγραφεί κανένα στοιχείο).
    (c) Θέστε στη μεταβλητή x την τιμή του n-οστού στοιχείου από την κορυφή της στοίβας, αφήνοντας τη στοίβα
    χωρίς τα n πρώτα στοιχεία της κορυφής.
    (d) Θέστε στη μεταβλητή x την τιμή του n-οστού στοιχείου από την κορυφή της στοίβας, αφήνοντας τη στοίβα
    αμετάβλητη. (Υπόδειξη: Χρησιμοποιείστε μία άλλη, βοηθητική στοίβα.)
    (e) Θέστε στη μεταβλητή x την τιμή του τελευταίου στοιχείου της στοίβας, αφήνοντας τη στοίβα αμετάβλητη.
    (f) Θέστε στη μεταβλητή x την τιμή του τρίτου στοιχείου από τη βάση της στοίβας, αφήνοντας τη στοίβα
    αμετάβλητη.
    (g) Θέστε στη μεταβλητή x την τιμή του τελευταίου στοιχείου της στοίβας, αφήνοντας τη στοίβα κενή.
    Στο κυρίως πρόγραμμα θα δημιουργείται πρώτα η στοίβα και θα προστίθενται σ’ αυτή 15 αριθμοί. Για λόγους
    απλότητας μπορεί να χρησιμοποιηθεί ένας βρόχος for, σε κάθε επανάληψη του οποίου θα προστίθεται στη στοίβα
    το δεκαπλάσιο της τιμής της μεταβλητής ελέγχου της for. Στη συνέχεια εμφανίστε το περιεχόμενο της στοίβας
    (καλέστε τη βοηθητική συνάρτηση TraverseStack, η εμφάνιση των στοιχείων από τη θέση 0 .. Stack.top).
    Πριν την εκτέλεση των παραπάνω λειτουργιών θα διαβάζεται ο ακέραιος αριθμός n (n ≤ (Stack.Top-1)/2) που
    χρειάζεται στις λειτουργίες (c) και (d). Δε χρειάζεται να γίνεται έλεγχος ορθής καταχώρησης της τιμής του n εντός
    του παραπάνω ορίου θεωρούμε ότι θα δοθεί ορθά.
    Μετά από την εκτέλεση κάθε λειτουργίας (a) έως (g) θα εμφανίζεται η τιμή της μεταβλητής x στη συνέχεια το
    πλήθος των στοιχείων της στοίβας και το περιεχόμενο της στοίβας. Η είσοδος και η έξοδος του προγράμματος
    φαίνεται στο παρακάτω ενδεικτικό στιγμιότυπο.
*/

#include <stdio.h>
#include <stdlib.h>

#define StackLimit 15   // το όριο μεγέθους της στοίβας


typedef int StackElementType;   // ο τύπος των στοιχείων  της στοίβας
                                //ενδεικτικά τύπος int
typedef struct  {
    int Top;
    StackElementType Element[StackLimit];
} StackType;

typedef enum {
    FALSE, TRUE
} boolean;

void TraverseStack(StackType Stack);
void CreateStack(StackType *Stack);
boolean EmptyStack(StackType Stack);
boolean FullStack(StackType Stack);
void Push(StackType *Stack, StackElementType Item);
void Pop(StackType *Stack, StackElementType *Item);
void CopyStack(StackType *MyStack,StackType *MyOtherStack);

int main()
{
    StackElementType temp,i,n,x;
    StackType MyStack,TempStack;

    CreateStack(&MyStack);
    for(i=0;i<StackLimit;i++)
        {Push(&MyStack, 10*i);}

    TraverseStack(MyStack);
    printf("Give nth element (n<=6) ");
    scanf("%d",&n);
    printf("\n");

    // Question a

    Pop(&MyStack,&x);
    Pop(&MyStack,&x);
    printf("Question a: x=%d",x);
    TraverseStack(MyStack);
    printf("\n");

   // Question b
   
    Pop(&MyStack, &temp);
    Pop(&MyStack, &x);
    Push(&MyStack, x);
    Push(&MyStack, temp);

    printf("Question b: x=%d",x);
    TraverseStack(MyStack);
    printf("\n");

   // Question c

    for(i=0;i<n;i++){
        Pop(&MyStack,&x);}
    printf("Question c: x=%d",x);
    TraverseStack(MyStack);
    printf("\n");

   // Question d
    CreateStack(&TempStack);
    for(i=0;i<n;i++)
    {
        Pop(&MyStack,&temp);
        Push(&TempStack,temp);
        x=temp;
    }
    for(i=0;i<n;i++)
    {
        Pop(&TempStack,&temp);
        Push(&MyStack,temp);
    }
    printf("Question d: x=%d",x);
    TraverseStack(MyStack);
    printf("\n");

   // Question e

    while(!EmptyStack(MyStack))
    {
        Pop(&MyStack,&x);
        Push(&TempStack,x);
    }
    while(!EmptyStack(TempStack))
    {
        Pop(&TempStack,&temp);
        Push(&MyStack,temp);
    }

    printf("Question e: x=%d",x);
    TraverseStack(MyStack);
    printf("\n");

    // Question f

    for(i=MyStack.Top;i>=2;i--)
    {
        Pop(&MyStack,&x);
        Push(&TempStack,x);
    }
    while(!EmptyStack(TempStack))
    {
        Pop(&TempStack,&temp);
        Push(&MyStack,temp);
    }

    printf("Question f: x=%d",x);
    TraverseStack(MyStack);
    printf("\n");

    // Question g

    while(!EmptyStack(MyStack))
    {
        Pop(&MyStack,&x);
    }

    printf("Question g: x=%d",x);
    TraverseStack(MyStack);

    return 0;
}



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
