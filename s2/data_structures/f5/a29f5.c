/*  Αρχείο: a29f5.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Γράψτε πρόγραμμα που θα δέχεται για κάθε άτομο τον ΑΜΚΑ (ακέραιος), τον ΑΦΜ (ακέραιος), την ηλικία (ακέραιος). Θα
    καταχωρεί τα στοιχεία του κάθε ατόμου σε 2 καταλόγους ανάλογα με την ηλικία του, αυτούς με ηλικία μικρότερη ή ίση
    των 60 ετών και αυτούς με ηλικία μεγαλύτερη των 60.
    Κάθε κατάλογος θα πρέπει να οργανωθεί ως ΔΔΑ με κλειδί τον ΑΜΚΑ. Το πρόγραμμα θα περιλαμβάνει τις εξής
    λειτουργίες
    - Εισαγωγή των στοιχείων του κάθε ατόμου στο αντίστοιχο ΔΔΑ ανάλογα με την ηλικία του (ΔΔΑ για άτομα με ηλικίες
    <=60 και ΔΔΑ για άτομα με ηλικίες > 60). Και στα 2 ΔΔΑ το κλειδί θα είναι ο ΑΜΚΑ.
    - Εμφάνιση των 2 καταλόγων
    - Αναζήτηση ατόμου με βάση τον ΑΜΚΑ και την ηλικία.
    Δίνεται ένα στιγμιότυπο εκτέλεσης όπου φαίνεται πως θα γίνεται το διάβασμα των δεδομένων και η εμφάνιση του
    κάθε καταλόγου. Η αναζήτηση θα γίνει για 3 άτομα: α) ένα άτομο του οποίου τα στοιχεία έχουν καταχωρηθεί σε ένα εκ
    των 2 καταλόγων (ΑΜΚΑ, ηλικία), β) ένα άτομο του οποίου το ΑΜΚΑ του έχει καταχωρηθεί στον αντίστοιχο κατάλογο
    αλλά η ηλικία του δεν ταυτίζεται με τη δοθείσα και γ) ένα άτομο του οποίου το ΑΜΚΑ δεν έχει καταχωρηθεί σε κανένα
    κατάλογο. Τα μηνύματα της κάθε περίπτωσης φαίνονται στο στιγμιότυπο εκτέλεσης.
    (για την απλοποίηση της εισαγωγής δεδομένων δόθηκαν ίδιες τιμές για ΑΜΚΑ, ΑΦΜ, ηλικία)
    

*/


#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

// Δήλωση τύπων
typedef struct{
    int AMKA;
    int afm;
    int age;
} BinTreeElementType;

typedef struct BinTreeNode *BinTreePointer;
 struct BinTreeNode {
    BinTreeElementType Data;
    BinTreePointer LChild, RChild;
} ;

typedef enum {
    FALSE, TRUE
} boolean;

// Δήλωση συναρτήσεων
void CreateBST(BinTreePointer *Root);
boolean EmptyBST(BinTreePointer Root);
void BSTInsert(BinTreePointer *Root, BinTreeElementType Item);
void BSTSearch(BinTreePointer Root, BinTreeElementType KeyValue, boolean *Found, BinTreePointer *LocPtr);
void InorderTraversal(BinTreePointer Root);

int main()
{
    // Δήλωση μεταβλητών
    BinTreePointer Root1, Root2, LocPtr;
    BinTreeElementType person;
    boolean found;
    char ch;
    int i;

    CreateBST(&Root1); // Δημιουργία ΔΔΑ για τον κατάλογο <=60
    CreateBST(&Root2); // Δημιουργία ΔΔΑ για τον κατάλογο >60

    do // Επαναληπτικά
    {
     printf("Give AMKA? ");
     scanf("%d", &person.AMKA); // Διάβασε το ΑΜΚΑ του ατόμου
     printf("Give AFM? ");
     scanf("%d", &person.afm); // Διάβασε το ΑΦΜ του ατόμου
     printf("Give age? ");
     scanf("%d", &person.age); // Διάβασε την ηλικία του ατόμου
    
     if(person.AMKA<=60){ // Αν η ηλικία του ατόμου είναι μικρότερη ή ίση του 60
        BSTInsert(&Root1, person); // Εισαγωγή του ατόμου στο ΔΔΑ με τους <=60
     }
     else{ // Αλλιώς
        BSTInsert(&Root2, person); // Εισαγωγή του ατόμου στο ΔΔΑ με τους >60
     }
     printf("\nContinue Y/N: ");
     
     do // Επαναληπτικά
       {
       scanf("%c", &ch); // Διάβασε τον χαρακτήρα ch
       } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y'); // όσο ο χαρακτήρας δεν είναι N ή Υ
       
       } while (toupper(ch)!='N'); // όσο ο χαρακτήρας δεν είναι Ν

    printf("\nPeople with age less-equal 60\n");
    InorderTraversal(Root1); // Εμφάνισε το ΔΔΑ με τα άτομα <=60
    printf("\n");
    printf("\nPeople with age greater than 60\n");
    InorderTraversal(Root2); // Εμφάνισε το ΔΔΑ με τα άτομα > 60
    printf("\n");
    for(i=0;i<3;i++)
    {
     printf("Give AMKA: ");
     scanf("%d", &person.AMKA); // Διάβασε το ΑΜΚΑ του ατόμου
     printf("Give age: ");
     scanf("%d", &person.age); // Διάβασε την ηλικία του ατόμου

    if(person.age<=60) // Αν η ηλικία του ατόμου είναι μικρότερη ή ίση του 60
    {
        BSTSearch(Root1, person, &found, &LocPtr); // Αναζήτηση του ατόμου στο ΔΔΑ των <=60
    }
    else // Αλλιώς
    {
        BSTSearch(Root2, person, &found, &LocPtr); // Αναζήτηση του ατόμου στο ΔΔΑ των > 60
    }
    if(found) // Αν το άτομο βρέθηκε
    {
        if(person.age==LocPtr->Data.age) // Αν η ηλικία του ατόμου είναι ίση με τη δοσμένη από το χρήστη ηλικία
        {   // Εμφάνισε ότι το άτομο βρέθηκε
            printf("The person with AMKA %d, AFM %d and age %d is in the catalogue\n",LocPtr->Data.AMKA,LocPtr->Data.afm,LocPtr->Data.age);
        }
        else{ // Αλλιώς Εμφάνισε ότι το άτομο βρέθηκε αλλά με άλλη ηλικία
            printf("The person with AMKA %d has age %d different from the person you are looking for\n",LocPtr->Data.AMKA,LocPtr->Data.age);
        }
    }

    else{ // Αλλιώς Εμφάνισε ότι το άτομο δεν βρέθηκε
        printf("The person with AMKA %d and age %d is Unknown\n",person.AMKA,person.age);
    }
    }

    
    return 0;
}

// Υλοποίηση συναρτήσεων
void CreateBST(BinTreePointer *Root)
/* Λειτουργία: Δημιουργεί ένα κενό ΔΔΑ.
   Επιστρέφει:  Τον μηδενικό δείκτη(NULL) Root
*/
{
    *Root = NULL;
}

boolean EmptyBST(BinTreePointer Root)
/* Δέχεται:   Ενα ΔΔα με το Root να δείχνει στη ρίζα του.
  Λειτουργία: Ελέγχει αν το ΔΔΑ είναι κενό.
  Επιστρέφει: TRUE αν το ΔΔΑ είναι κενό και FALSE διαφορετικά
*/
{   return (Root==NULL);
}

void BSTInsert(BinTreePointer *Root, BinTreeElementType Item)
/* Δέχεται:     Ένα ΔΔΑ με το δείκτη Root να δείχνει στη ρίζα του και ένα στοιχείο Item.
   Λειτουργία:  Εισάγει το στοιχείο Item στο ΔΔΑ.
   Επιστρέφει: Το τροποποιημένο ΔΔΑ με τον δείκτη Root να δείχνει στη ρίζα του
*/
{
    BinTreePointer LocPtr, Parent;
    boolean Found;

    LocPtr = *Root;
    Parent = NULL;
    Found = FALSE;
    while (!Found && LocPtr != NULL) {
        Parent = LocPtr;
        if (Item.AMKA < LocPtr->Data.AMKA)
            LocPtr = LocPtr ->LChild;
        else if (Item.AMKA > LocPtr ->Data.AMKA)
            LocPtr = LocPtr ->RChild;
        else
            Found = TRUE;
    }
    if (Found)
        printf("To %d EINAI HDH STO DDA\n", Item.AMKA);
    else {
        LocPtr = (BinTreePointer)malloc(sizeof (struct BinTreeNode));
        LocPtr ->Data = Item;
        LocPtr ->LChild = NULL;
        LocPtr ->RChild = NULL;
        if (Parent == NULL)
            *Root = LocPtr;
        else if (Item.AMKA < Parent ->Data.AMKA)
            Parent ->LChild = LocPtr;
        else
            Parent ->RChild = LocPtr;
    }
}


void BSTSearch(BinTreePointer Root, BinTreeElementType KeyValue, boolean *Found, BinTreePointer *LocPtr)
/* Δέχεται:    Ένα ΔΔΑ με το δείκτη Root να δείχνει στη ρίζα του και μια τιμή KeyValue.
   Λειτουργία: Αναζητά στο ΔΔΑ έναν κόμβο με τιμή KeyValue στο πεδίο κλειδί του.
   Επιστρέφει: Η Found έχει τιμή TRUE και ο δείκτης LocPtr δείχνει στον κόμβο που
                περιέχει την τιμή KeyValue, αν η αναζήτηση είναι επιτυχής.
                Διαφορετικά η Found έχει τιμή FALSE
*/
{
    boolean stop;

    *LocPtr = Root;
    stop = FALSE;
    while (!stop && *LocPtr != NULL)
    {
        if (KeyValue.AMKA < (*LocPtr)->Data.AMKA)
            *LocPtr = (*LocPtr)->LChild;
        else
            if (KeyValue.AMKA > (*LocPtr)->Data.AMKA)
                *LocPtr = (*LocPtr)->RChild;
            else stop = TRUE;
    }
   *Found=stop;
}

void InorderTraversal(BinTreePointer Root)
/* Δέχεται:    Ένα δυαδικό δέντρο με το δείκτη Root να δείχνει στην ρίζα του.
   Λειτουργία: Εκτελεί ενδοδιατεταγμένη διάσχιση του δυαδικού δέντρου και
                επεξεργάζεται κάθε κόμβο ακριβώς μια φορά.
   Εμφανίζει: Το περιεχόμενο του κόμβου, και εξαρτάται από το είδος της επεξεργασίας
*/
{
    if (Root!=NULL) {
        InorderTraversal(Root->LChild);
        printf("(%d, %d, %d)",Root->Data.AMKA,Root->Data.afm,Root->Data.age);
        InorderTraversal(Root->RChild);
    }
}

