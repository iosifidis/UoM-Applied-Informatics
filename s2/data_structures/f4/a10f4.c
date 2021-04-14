/*  Αρχείο: a10f4.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Να γίνει πρόγραμμα που θα προσομοιώνει μια ουρά με τη βοήθεια δύο στοιβών, δηλαδή οι λειτουργίες της ουράς θα
    προσομοιώνονται με τις λειτουργίες της στοίβας. Αντί να χρησιμοποιήσετε μια ουρά αρκεί να χρησιμοποιήσετε 2 στοίβες.
    Κάθε κόμβος περιέχει έναν ακέραιο αριθμό και η εισαγωγή δεδομένων θα γίνεται ως εξής: πλήθος στοιχείων, στοιχεία. Το 
    πρόγραμμα θα εμφανίζει τα περιεχόμενα και των 2 στοιβών. Η 2η στοίβα έχει καταχωρημένα τα στοιχεία όπως θα ήταν αν
    είχαμε χρησιμοποιήσει μια ουρά.


*/

#include <stdio.h>
#include <stdlib.h>

// Δήλωση τύπων
typedef int StackElementType;
typedef struct StackNode *StackPointer;
typedef struct StackNode
{
	StackElementType Data;
    StackPointer Next;
} StackNode;

typedef enum {
    FALSE, TRUE
} boolean;

// Δήλωση συναρτήσεων
void CreateStack(StackPointer *Stack);
boolean EmptyStack(StackPointer Stack);
void Push(StackPointer *Stack, StackElementType Item);
void Pop(StackPointer *Stack, StackElementType *Item);
void TraverseStack(StackPointer Stack);

int main()
{

    StackPointer AStack1, AStack2;
    StackElementType Item;
    int plithos,i;

    CreateStack(&AStack1);  //Δημιουργώ τη στοίβα AStack1
    CreateStack(&AStack2);  //Δημιουργώ τη στοίβα AStack2

    printf("PLITHOS STOIXEIWN: ");
    scanf("%d", &plithos);  //Διαβάζω το πλήθος των στοιχείων που θα εισαχθούν στη στοίβα
    for(i=0;i<plithos;i++)
    {
        printf("DWSE TO 1o STOIXEIO: ");
        scanf("%d", &Item); // Διαβάζω 1-1 στοιχείο και το εισάγω στην στοίβα AStack1
        Push(&AStack1, Item);
    }

    printf("*********1i stoiva***********\n");
    TraverseStack(AStack1);  //Εμφανίζω τα στοιχεία της στοίβας AStack1

    while(!EmptyStack(AStack1))
    {
        Pop(&AStack1, &Item);  //Απωθώ το κορυφαίο στοιχείο Item από τη στοίβα AStack1
        Push(&AStack2, Item);  //Εισάγω στο στοιχείο Item στη στοίβα AStack2
    }

    printf("*********2i stoiva***********\n");
    TraverseStack(AStack2);  //Εμφανίζω τα στοιχεία της στοίβας AStack2

    return 0;
}

// Υλοποίηση συναρτήσεων

void CreateStack(StackPointer *Stack)
/* Λειτουργία: Δημιουργεί μια κενή συνδεδεμένη στοίβα. 
   Επιστρέφει: Μια κενή συνδεδεμένη στοίβα, Stack  
*/
{
	*Stack = NULL;
}

boolean EmptyStack(StackPointer Stack)
/* Δέχεται:     Μια συνδεδεμένη στοίβα, Stack.
   Λειτουργία:  Ελέγχει αν η Stack είναι κενή.
   Επιστρέφει:  TRUE αν η στοίβα είναι κενή, FALSE διαφορετικά
*/
{
	return (Stack==NULL);
}

void Push(StackPointer *Stack, StackElementType Item)
/* Δέχεται:    Μια συνδεδεμένη στοίβα που η κορυφή της δεικτοδοτείται από τον 
                δείκτη Stack και ένα στοιχείο Item. 
   Λειτουργία: Εισάγει στην κορυφή της συνδεδεμένης στοίβας, το στοιχείο Item. 
   Επιστρέφει: Την τροποποιημένη συνδεδεμένη στοίβα 
*/
{
	StackPointer TempPtr;

    TempPtr= (StackPointer)malloc(sizeof(struct StackNode));
    TempPtr->Data = Item; 
    TempPtr->Next = *Stack;
    *Stack = TempPtr;
}

void Pop(StackPointer *Stack, StackElementType *Item)
/* Δέχεται:    Μια συνδεδεμένη στοίβα που η κορυφή της δεικτοδοτείται από τον δείκτη Stack. 
   Λειτουργία: Αφαιρεί από την κορυφή της συνδεδεμένης στοίβας, 
                αν η στοίβα δεν είναι κενή, το στοιχείο Item. 
   Επιστρέφει: Την τροποποιημένη συνδεδεμένη στοίβα και το στοιχείο Item. 
   Έξοδος:     Μήνυμα κενής στοίβας, αν η συνδεδεμένη στοίβα είναι κενή 
*/
{
    StackPointer TempPtr;
    
    if (EmptyStack(*Stack)) {
   	    printf("EMPTY Stack\n");
    }
   else
   {
        TempPtr = *Stack;
        *Item=TempPtr->Data;
        *Stack = TempPtr->Next;     
        free(TempPtr);
    }
}

void TraverseStack(StackPointer Stack)
{
    StackPointer CurrPtr;

   if (EmptyStack(Stack))
   {
           printf("EMPTY Stack\n");
    }
   else
   {
           CurrPtr = Stack;
         while ( CurrPtr!=NULL )
        {
               printf("%d ", CurrPtr->Data);
             CurrPtr = CurrPtr->Next;
        }
   }
    printf("\n");
}

