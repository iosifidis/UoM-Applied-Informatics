/*  Αρχείο: a1f4.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Να υλοποιηθεί η συνάρτηση Search με το παρακάτω πρωτότυπο:
    boolean Search(ListPointer FreePtr, ListPointer List, NodeType Node[NumberOfNodes], ListElementType Item, ListPointer *PredPtr);
    
    η οποία θα δέχεται μια Συνδεδεμένη Λίστα (ΣΛ) υλοποιημένη με πίνακα (παράμετροι FreePtr, List, Node) και ένα στοιχείο
    Item και θα επιστρέφει boolean τιμή η οποία δείχνει αν βρέθηκε ή όχι το αναζητούμενο στοιχείο Item στη ΣΛ και τη θέση
    (PredPtr) του στοιχείου που είναι προηγούμενο του Item, ώστε η ΣΛ που θα προκύψει μετά την εισαγωγή ή τη διαγραφή
    του στοιχείου Item να είναι ταξινομημένη (χρήση της Search πριν την εισαγωγή ή τη διαγραφή στοιχείου στη ΣΛ). Η
    εισαγωγή στοιχείων στην Σ.Λ. γίνεται επαναληπτικά και ελέγχεται από το μήνυμα ‘Continue Y/N:’ (δες στιγμιότυπο
    εκτέλεσης). Στη ΣΛ καταχωρούνται ακέραιοι. H συνάρτηση Search θα κληθεί 2 φορές μια για στοιχείο που υπάρχει στη ΣΛ
    και μια για στοιχείο που δεν υπάρχει στη ΣΛ. Αν το στοιχείο βρεθεί θα εμφανίζει το μήνυμα 
    «The number is in the list and its predecessor is in position» και την τιμή της PredPtr, διαφορετικά θα εμφανίζει το μήνυμα 
    «The number is not in the list». Το πρόγραμμα θα πρέπει να εκτελεί κατά σειρά τις παρακάτω λειτουργίες και οι κλήσεις 
    των συναρτήσεων θα γίνονται από τη main().
    A. Αρχικοποίηση storage pool
    B. Δημιουργία ΑΣΛ (μέγιστο μέγεθος 10)
    C. Εμφάνιση της storage pool
    D. Εμφάνιση των στοιχείων της ΣΛ
    E. Εισαγωγή στοιχείων στην ΣΛ. Μετά από κάθε εισαγωγή στοιχείου στη ΣΛ αυτή θα πρέπει να παραμένει 
    ταξινομημένη σε αύξουσα διάταξη (χρήση της Search πριν την εισαγωγή στοιχείου στη ΣΛ)
    F. Εμφάνιση της storage pool
    G. Εμφάνιση των στοιχείων της ΣΛ
    H. Έλεγχος εάν η ΣΛ είναι άδεια. Αν η ΣΛ είναι άδεια εμφανίζει μήνυμα «Empty List» διαφορετικά «Not an Empty List»
    I. Έλεγχος εάν η ΣΛ είναι γεμάτη. Αν η ΣΛ είναι γεμάτη εμφανίζει μήνυμα «Full List» διαφορετικά «Not a Full List»
    J. Αναζήτηση ενός στοιχείου στη ΣΛ (για στοιχείο που υπάρχει στη ΣΛ και για στοιχείο που δεν υπάρχει).


*/

#include <stdio.h>
#include <ctype.h>

#define NumberOfNodes 10    /*όριο μεγέθους της συνδεδεμένης λίστας */
#define NilValue -1          // ειδική μεδενικη τιμη δείχνει το τέλος της Συνδ.λίστας

typedef int ListElementType; /*τύπος δεδομένων για τα στοιχεία της συνδεδεμένης λίστας, 
                                ενδεικτικά επιλέχθηκε ο τύπος int */
typedef int ListPointer;

typedef struct {
    ListElementType Data;
    ListPointer  Next;
} NodeType;

typedef enum {
    FALSE, TRUE
} boolean;

// ΔΗΛΩΣΕΙΣ ΣΥΝΑΡΤΗΣΕΩΝ
boolean Search(ListPointer FreePtr, ListPointer List, NodeType Nodes[NumberOfNodes], ListElementType Item, ListPointer *PredPtr);
void CreateList(ListPointer *List);
void InitializeStoragePool(NodeType Node[], ListPointer *FreePtr);
void Insert(ListPointer *List, NodeType Node[],ListPointer *FreePtr, ListPointer PredPtr, ListElementType Item);
void GetNode(ListPointer *P, ListPointer *FreePtr, NodeType Node[]);
boolean FullList(ListPointer FreePtr);
boolean EmptyList(ListPointer List);
void printAll(ListPointer List, ListPointer FreePtr, NodeType Node[]);
void TraverseLinked(ListPointer List, NodeType Node[]);

int main()
{
  ListPointer AList;
  NodeType Node[NumberOfNodes];
  ListPointer FreePtr,PredPtr;
  boolean found;
  int i;

  ListElementType AnItem;

  char ch;

  // Ερώτημα A
  InitializeStoragePool(Node, &FreePtr);
  
  // Ερώτημα B
  CreateList(&AList);

  // Ερώτημα C
  printf("---------------Question C--------------------\n");
  printf("--------------Storage pool------------------\n");
  printAll(AList, FreePtr, Node);
  
  // Ερώτημα D
  printf("---------------Question D--------------------\n");
  printf("--------------Linked list------------------\n");
  TraverseLinked(AList, Node);

  // Ερώτημα E
  printf("---------------Question E--------------------\n");
  do
    {
     printf("Give a number: ");
     scanf("%d", &AnItem);
    
     found=Search(FreePtr, AList, Node, AnItem, &PredPtr);
     
     Insert(&AList, Node, &FreePtr, PredPtr, AnItem); 
    
     printf("\nContinue Y/N: ");
     
     do
       {
       scanf("%c", &ch);
       } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y');
       
       } while (toupper(ch)!='N');


  // Ερώτημα F
  printf("---------------Question F--------------------\n");
  printf("--------------Storage pool------------------\n");
  printAll(AList, FreePtr, Node);
  
  // Ερώτημα G
  printf("---------------Question G--------------------\n");
  printf("--------------Linked list------------------\n");
  TraverseLinked(AList, Node);
      
  // Ερώτημα H
  printf("---------------Question H--------------------\n");
  if(EmptyList(AList))
  {printf("Empty List\n");}
  else
  {printf("Not an Empty List\n");}

  // Ερώτημα I
  printf("---------------Question I--------------------\n");
  if(FullList(FreePtr))
  {printf("Full List\n");}
  else
  {printf("Not a Full List\n");}
  
  // Ερώτημα J
  printf("---------------Question J--------------------\n");
  printf("-----------------Search for a number-----------------\n");
  for(i=0;i<2;i++){
     printf("Give a number ");
     scanf("%d", &AnItem);
    
     found=Search(FreePtr, AList, Node, AnItem, &PredPtr);
     if(found)
     {printf("The number is in the list and its predecessor is in position %d\n",PredPtr);}
     else
     {printf("The number is not in the list\n");}
}

	return 0;
}

// ΣΥΝΑΡΤΗΣΕΙΣ

boolean Search(ListPointer FreePtr, ListPointer List, NodeType Nodes[NumberOfNodes], ListElementType Item, ListPointer *PredPtr)
{
  boolean stop;
  boolean found;
  ListPointer current;

  stop=FALSE;
  found=FALSE;
  *PredPtr = NilValue;
  
  if(!EmptyList(List))
  {
    current=List;
    while (current != NilValue && !stop) {
      if(Nodes[current].Data >= Item){
      stop=TRUE;
      found=(Nodes[current].Data==Item);
      }
      else {
      *PredPtr=current;
      current=Nodes[current].Next;
     }
    }
  }

  else
    {found=FALSE;}

  return found;
}



void CreateList(ListPointer *List)
/* Λειτουργία: Δημιουργεί μια κενή συνδεδεμένη λίστα.
   Επιστρέφει: Έναν (μηδενικό) δείκτη που δείχνει σε κενή λίστα
*/
{
  *List=NilValue;
}

void InitializeStoragePool(NodeType Node[], ListPointer *FreePtr)
/* Δέχεται:   Τον πίνακα Node και τον δείκτη FreePtr που δείχνει στον
                πρώτο διαθέσιμο κόμβο.
  Λειτουργία: Αρχικοποιεί τον πίνακα Node ως συνδεδεμένη λίστα συνδέοντας μεταξύ
                τους διαδοχικές εγγραφές του πίνακα,
                και αρχικοποιεί τον δείκτη FreePtr .
  Επιστρέφει: Τον τροποποιημένο πίνακα Node και τον
                δείκτη FreePtr του πρώτου διαθέσιμου κόμβου
*/
{
   int i;

    for (i=0; i<NumberOfNodes-1;i++)
    {
        Node[i].Next=i+1;
        Node[i].Data=-1;
    }
    Node[NumberOfNodes-1].Next=NilValue;
    Node[NumberOfNodes-1].Data=NilValue;
    *FreePtr=0;
}

void Insert(ListPointer *List, NodeType Node[],ListPointer *FreePtr, ListPointer PredPtr, ListElementType Item)
/* Δέχεται:    Μια συνδεδεμένη λίστα, τον πίνακα Node, τον δείκτη PredPtr και
                ένα στοιχείο Item.
  Λειτουργία: Εισάγει στη συνδεδεμένη λίστα, αν δεν είναι γεμάτη, το στοιχείο
                Item μετά από τον κόμβο στον οποίο δείχνει ο δείκτης PredPtr.
  Επιστρέφει: Την τροποποιημένη συνδεδεμένη λίστα, τον τροποποιημένο πίνακα Node
                και τον δείκτη FreePtr.
  Εξοδος:     Μήνυμα γεμάτης λίστας, αν η συνδεδεμένη λίστα είναι γεμάτη
*/
{
  ListPointer TempPtr;
  GetNode(&TempPtr,FreePtr,Node);
  if (!FullList(TempPtr)) {
    if (PredPtr==NilValue)
    {
        Node[TempPtr].Data =Item;
        Node[TempPtr].Next =*List;
        *List =TempPtr;
    }
    else
      {
        Node[TempPtr].Data =Item;
        Node[TempPtr].Next =Node[PredPtr].Next;
        Node[PredPtr].Next =TempPtr;
      }
}
  else
    printf("Full List ...\n");
}

void GetNode(ListPointer *P, ListPointer *FreePtr, NodeType Node[])
/* Δέχεται:   Τον πίνακα Node και τον δείκτη FreePtr.
  Λειτουργία: Αποκτά έναν "ελεύθερο" κόμβο που τον δείχνει ο δείκτης P.
  Επιστρέφει: Τον δείκτη P και τον τροποποιημένο  δείκτη FreePtr
                που δεικτοδοτεί στο πρώτο διαθέσιμο κόμβο
*/
{
  *P = *FreePtr;
  if (!FullList(*FreePtr))
    *FreePtr =Node[*FreePtr].Next;
}


boolean EmptyList(ListPointer List)
/* Δέχεται:    Έναν δείκτη List που δείχνει σε μια συνδεδεμένη λίστα.
   Λειτουργία: Ελέγχει αν η συνδεδεμένη λίστα είναι κενή.
   Επιστρέφει: True αν η συνδεδεμένη λίστα είναι κενή και false διαφορετικά
*/
{
  return (List==NilValue);
}

boolean FullList(ListPointer FreePtr)
/* Δέχεται:    Μια συνδεδεμένη λίστα.
   Λειτουργία: Ελέγχει αν η συνδεδεμένη λίστα είναι γεμάτη.
   Επιστρέφει: True αν η συνδεδεμένηλίστα είναι γεμάτη, false διαφορετικά
*/
{
  return (FreePtr == NilValue);
}

void printAll(ListPointer List, ListPointer FreePtr, NodeType Node[])
{
    int i;
    printf("1o STOIXEIO LISTAS=%d, 1H FREE POSITION=%d\n", List, FreePtr);
    printf("H STORAGE POOL EXEI TA EJHS STOIXEIA\n");
    for (i=0;i<NumberOfNodes;i++)
        printf("(%d: %d->%d) ",i,Node[i].Data, Node[i].Next);
    printf("\n");
}

void TraverseLinked(ListPointer List, NodeType Node[])
/* Δέχεται:    Μια συνδεδεμένη λίστα.
   Λειτουργία: Κάνει διάσχιση της συνδεδεμένης λίστας, αν δεν είναι κενή.
   Έξοδος:     Εξαρτάται από την επεξεργασία
*/
{
  ListPointer CurrPtr;

  if (!EmptyList(List))
  {
      CurrPtr =List;
      while (CurrPtr != NilValue)
      {
          printf("(%d: %d->%d) ",CurrPtr,Node[CurrPtr].Data, Node[CurrPtr].Next);
          CurrPtr=Node[CurrPtr].Next;
       }
       printf("\n");
   }
  else printf("Empty List ...\n");
}
