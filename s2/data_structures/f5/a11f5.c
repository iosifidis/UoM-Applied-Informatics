/*  Αρχείο: a11f5.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Γράψτε ένα πρόγραμμα που θα πραγματοποιεί ορθογραφικό έλεγχο ενός κειμένου. Οι λέξεις που απαρτίζουν το λεξικό
    είναι αποθηκευμένες στο αρχείο κειμένου ‘I112f5.TXT’ (σε κάθε γραμμή του υπάρχει μία λέξη). Διαβάζονται και
    αποθηκεύονται μία-μία σε ένα ΔΔΑ με τη συνάρτηση CreateDictionary και έτσι δημιουργείται το λεξικό-ΔΔΑ. Μετά τη
    δημιουργία του λεξικού-ΔΔΑ θα εμφανίζετε τις λέξεις του λεξικού. Στη συνέχεια το πρόγραμμα μέσω της συνάρτησης
    SpellingCheck θα διαβάζει ένα κείμενο που είναι αποθηκευμένο στο αρχείο κειμένου ‘I111F5.TXT’, σε κάθε γραμμή του
    οποίου υπάρχει μία λέξη και θα διενεργεί ορθογραφικό έλεγχο, δηλαδή θα αναζητά τη λέξη του αρχείου ‘I111F5.TXT’ στο
    λεξικό-ΔΔΑ. Κατά τον ορθογραφικό έλεγχο θα πρέπει να εκτυπώνετε τις λέξεις που δεν βρέθηκαν στο λεξικό και να
    υπολογίζετε το πλήθος τους. Το πλήθος των λέξεων που δεν βρέθηκαν στο λεξικό θα εμφανίζεται στη main.
    Δίνονται τα πρωτότυπα των συναρτήσεων
    void CreateDictionary(BinTreePointer *Root, FILE *fp);
    int SpellingCheck(BinTreePointer Root, FILE *fp);
    
    Η 1 παράμετρος της fopen θα πρέπει να περιλαμβάνει το όνομα του αρχείου χωρίς διαδρομή δηλαδή:
    fp1 = fopen("i112f5.txt", "r");
    fp2 = fopen("i111f5.txt", "r");
    

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define size 20

// Δήλωση τύπων
typedef char BinTreeElementType[size];

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

void CreateDictionary(BinTreePointer *Root, FILE *fp);
int SpellingCheck(BinTreePointer Root, FILE *fp);

int main () 
{
    // Δήλωση μεταβλητών
    BinTreePointer ARoot;

    FILE *fp1;
    FILE *fp2;

    // Άνοιγμα αρχείων
    fp1 = fopen("i112f5.txt","r");
    fp2 = fopen("i111f5.txt","r");

    CreateBST(&ARoot); // Δημιουργία κενού ΔΔΑ
    CreateDictionary(&ARoot,fp1); // Κατασκευή λεξικού

    // Εμφάνιση του λεξικού
    printf("**********Dictionary**********\n");
    InorderTraversal(ARoot);
    printf("\n");

    // Εμφάνιση των λέξεων που δεν είναι στο λεξικό (δηλαδή στο ΔΔΑ)
    printf("**********Not in Dictionary**********\n");
    printf("Number of words not in Dictionary: %d\n",SpellingCheck(ARoot, fp2));

    // Κλείσιμο αρχείων
    fclose(fp1);
    fclose(fp2);

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
{   
    return (Root==NULL);
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
        if (strcmp(Item, LocPtr->Data) < 0)
            LocPtr = LocPtr ->LChild;
        else if (strcmp(Item, LocPtr->Data) > 0)
            LocPtr = LocPtr ->RChild;
        else
            Found = TRUE;
    }
    if (Found)
        printf("To %s EINAI HDH STO DDA\n", Item);
    else {
        LocPtr = (BinTreePointer)malloc(sizeof (struct BinTreeNode));
        //LocPtr ->Data = Item;//kati edo
        strcpy(LocPtr ->Data,Item);
        LocPtr ->LChild = NULL;
        LocPtr ->RChild = NULL;
        if (Parent == NULL)
            *Root = LocPtr;
        else if (strcmp(Item,Parent ->Data) < 0)
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
    (*LocPtr) = Root;
    (*Found) = FALSE;
    while (!(*Found) && (*LocPtr) != NULL)
    {
        if (strcmp(KeyValue,(*LocPtr)->Data) < 0)
            (*LocPtr) = (*LocPtr)->LChild;
        else
            if (strcmp(KeyValue,(*LocPtr)->Data) > 0)
                (*LocPtr) = (*LocPtr)->RChild;
            else (*Found) = TRUE;
    }
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
        printf("%s\n",Root->Data);
        InorderTraversal(Root->RChild);
    }
}

void CreateDictionary(BinTreePointer *Root, FILE *fp)
{
    BinTreeElementType Item; // Δήλωση μεταβλητών

    while(!feof(fp)){ // Όσο το αρχείο δεν τελείωσε

        fscanf(fp,"%s", Item); // Διάβασε την λέξη από το αρχείο
        BSTInsert(&(*Root), Item); // Εισήγαγε την λέξη στο ΔΔΑ-λεξικό
    }
}

int SpellingCheck(BinTreePointer Root, FILE *fp)
{
    // Δήλωση μεταβλητών
    boolean Found;
    BinTreePointer LocPtr;
    BinTreeElementType Item;
    int count = 0; // Αρχικοποίηση μετρητή λέξεων

    // διαβάζω 1-1 λέξη του αρχείου και αναζητώ στο ΔΔΑ-λεξικό
    // αν δεν υπάρχει στο ΔΔΑ-λεξικό τότε την εμφανίζω

    while(!feof(fp)){ // Όσο το αρχείο δεν τελείωσε

        fscanf(fp,"%s", Item); // Διάβασε την λέξη από το αρχείο
        BSTSearch(Root, Item, &Found, &LocPtr); // Αναζήτησε τη λέξη στο ΔΔΑ-λεξικό

        if(!Found){ // Αν η λέξη δεν βρέθηκε στο ΔΔΑ-λεξικό
            printf("%s \n",Item); // Εμφάνισε την λέξη
            count++; // Αύξησε τον μετρητή
        }
    }

    return count; // Επέστρεψε τον μετρητή
}
