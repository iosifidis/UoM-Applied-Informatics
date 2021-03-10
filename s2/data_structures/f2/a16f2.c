/*  Αρχείο: a16f2.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Ένα κατάστημα διατηρεί κάθε διαφορετικού τύπου προϊόν του μέσα σε κουτί όπου τα τοποθετεί οργανωμένα σε
    μορφή στοίβας. Για το προϊόν «παιδικό φανελάκι» αποθηκεύει την τιμή και το μέγεθος. Να γίνει πρόγραμμα
    όπου:
    1. Θα δίνεται το πλήθος από τα παιδικά φανελάκια που θα καταχωρήσει στο κουτί.
    2. Για κάθε φανελάκι θα δίνει την τιμή και το μέγεθος και θα εισάγει (καταχωρεί) το φανελάκι στο κουτί (ως
    στοίβα). Δεν απαιτείται τα φανελάκια (στοιχεία) να είναι ταξινομημένα ως προς το μέγεθος ή την τιμή για
    να εισαχθούν στη στοίβα-κουτί, απλά καταχωρούνται στη στοίβα-κουτί (LIFO).
    3. Όταν εισαχθούν όλα τα φανελάκια στη στοίβα-κουτί θα εμφανίζει το μήνυμα “items in the box” και στη
    συνέχεια τα φανελάκια που καταχωρήθηκαν στη στοίβα-κουτί.
    4. Θα αναζητά ένα φανελάκι με βάση το μέγεθος. Αν βρεθεί θα εμφανίζει μήνυμα “Found the size”
    διαφορετικά “Not Found the size”. Θα σταματά την αναζήτηση μόλις βρει το πρώτο φανελάκι με το
    συγκεκριμένο μέγεθος. Αν βρεθεί το φανελάκι θεωρούμε ότι αμέσως πωλείται.
    5. Στη συνέχεια θα εμφανίζει το μήνυμα “Items in the box” και θα εμφανίζει αυτά που έμειναν στη στοίβα-
    κουτί. Στη συνέχεια θα εμφανίζει το μήνυμα “Items out of the box” και θα εμφανίζει αυτά που έχουν
    βγει από τη στοίβα-κουτί.
    6. Αν το φανελάκι δε βρεθεί τότε η στοίβα-κουτί με τα φανελάκια θα πρέπει να αποκατασταθεί και να
    περιέχει όλα τα φανελάκια με την αρχική διάταξη. Αν το φανελάκι βρεθεί τότε η στοίβα-κουτί με τα
    φανελάκια θα πρέπει να τα έχει διατεταγμένα με την αρχική διάταξη αλλά το φανελάκι που αναζητήθηκε
    και βρέθηκε δε θα πρέπει να περιλαμβάνεται στη στοίβα-κουτί με τα φανελάκια, καθώς θεωρούμε ότι
    μόλις βρεθεί πωλείται.
    7. Στη συνέχεια θα εμφανίζει το μήνυμα “Items in the box” και θα εμφανίζει αυτά που βρίσκονται στη
    στοίβα-κουτί και το μήνυμα “Items out of the box” και θα εμφανίζει αυτά που έχουν βγει από τη στοίβα-
    κουτί.
    
    Στη συνέχεια δίνονται 2 ενδεικτικά στιγμιότυπα εκτέλεσης. Οι αριθμοί στην 1 στήλη αντιστοιχούν στην
    είσοδο και έξοδο όπως περιγράφονται παραπάνω στα σημεία 1 έως 5 και 7, ενώ το σημείο 6 δεν έχει
    είσοδο ή έξοδο.
*/

#include <stdio.h>
#include <stdlib.h>

#define StackLimit 50   // το όριο μεγέθους της στοίβας

typedef struct  {
    int price;
    char size;
} StackElementType;

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

int main()
{
    StackType ShirtStack,OutStack;
    StackElementType AnItem;
    int n,i;
    char sell;
    boolean found;

    CreateStack(&ShirtStack);
    CreateStack(&OutStack);


    // Ερώτημα 1
    printf("Give number of items ");
    scanf("%d",&n);

    //Ερώτημα 2
    printf("Give the items to store\n");
    for(i=0;i<n;i++)
    {
        printf("Give price ");
        scanf("%d",&AnItem.price);getchar();
        printf("Give size ");
        scanf("%c",&AnItem.size);getchar();
        Push(&ShirtStack,AnItem);
    }

    // Ερώτημα 3
    printf("Items in the box\n");
    TraverseStack(ShirtStack);

    // Ερώτημα 4
    printf("What size do you want? ");
    scanf("%c",&sell);getchar();

    found=FALSE;
    while(!EmptyStack(ShirtStack) && found==FALSE)
    {
        Pop(&ShirtStack,&AnItem);
        if(AnItem.size==sell){
            found=TRUE;
            
        }
        else{
            Push(&OutStack,AnItem);
        }
    }
    if(found==TRUE){
        printf("Found the size %c\n",sell);
        printf("\n");}
    else{
        printf("Not Found the size %c\n",sell);
        printf("\n");}

    // Ερώτημα 5

    printf("Items in the box");
    TraverseStack(ShirtStack);
 
    printf("Items out the box");
    TraverseStack(OutStack);

    // Ερώτημα 6

    while(!EmptyStack(OutStack))
    {
        Pop(&OutStack,&AnItem);
        Push(&ShirtStack,AnItem);
    }

   // Ερώτημα 7

    printf("Items in the box");
    TraverseStack(ShirtStack);

    printf("Items out the box");
    TraverseStack(OutStack);

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
        printf("%c, %d\n",Stack.Element[i].size,Stack.Element[i].price);
    }
    printf("\n");
}
