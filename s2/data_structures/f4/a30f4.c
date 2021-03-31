/*  Αρχείο: a30f4.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Σε μια ΣΛ θέλουμε να καταχωρούμε τον Αριθμό Μητρώο (int) και τον βαθμό (float) ενός μαθητή. Τροποποιήστε τον
    τύπο ListElementType ώστε να αποθηκεύει τον ΑΜ και το βαθμό του μαθητή. Κάντε τις κατάλληλες τροποποιήσεις όπου
    είναι απαραίτητο, στις συναρτήσεις που θα αντιγράψετε από τα αρχεία L_ListADT.c & L_ListADT.h. Θέλουμε να εντοπίζουμε
    και να εμφανίσουμε τα στοιχεία των μαθητών που έχουν τον ελάχιστο βαθμό. Να υλοποιήσετε τη συνάρτηση FindMins που
    θα δέχεται 2 παραμέτρους: τη ΣΛ με τα στοιχεία των μαθητών και μια στοίβα όπου θα καταχωρεί τους ΑΜ όλων των
    μαθητών με τον ίδιο ελάχιστο βαθμό, και θα επιστρέφει την τιμή του ελάχιστου βαθμού. To πρωτότυπο της συνάρτησης:

    float FindMins(ListPointer List, NodeType Node[NumberOfNodes], StackType *Stack)

    Αφού εντοπιστούν οι μαθητές με τους ελάχιστους βαθμούς, στη συνέχεια θα εμφανιστούν στην οθόνη.
    Η εμφάνιση των AM των μαθητών με τον ίδιο ελάχιστο βαθμό θα γίνεται στη main() με χρήση των επιτρεπόμενων
    λειτουργιών της στοίβας (άδειασμα στοίβας). Στη συνέχεια θα καλείται η βοηθητική συνάρτηση TraverseStack για την
    επαλήθευση της ορθής υλοποίησης αυτού του ερωτήματος (η στοίβα θα πρέπει να είναι κενή μετά την «εμφάνιση»-
    διαγραφή από τη στοίβα των ΑΜ). Το περιεχόμενο κάθε κόμβου της ΣΛ θα εμφανίζεται ως εξής: <ΑΜ, Βαθμός> πχ αν ο
    κόμβος της ΣΛ είναι στη θέση 0 του πίνακα με ΑΜ 5 και βαθμό 10 και ο επόμενος κόμβος της ΣΛ είναι αποθηκευμένος στη
    θέση 2 του πίνακα, τότε η εμφάνιση του κόμβου θα είναι: (0|<5,10.0> -> 2) που σημαίνει ότι ο κόμβος με περιεχόμενο 5, 10
    είναι αποθηκευμένος στη θέση 0 του πίνακα και έχει επόμενο κόμβο αποθηκευμένο στη θέση 2 του πίνακα.
    Το πρόγραμμα θα πρέπει να εκτελεί κατά σειρά τις παρακάτω λειτουργίες και οι κλήσεις των συναρτήσεων θα γίνονται από τη main().
    A. Αρχικοποίηση storage pool
    B. Δημιουργία ΣΛ (μέγιστο μέγεθος 10)
    C. Εμφάνιση της storage pool
    D. Εμφάνιση των στοιχείων της ΣΛ
    E. Εισαγωγή 5 στοιχείων στην ΣΛ. (Η εισαγωγή στοιχείου θα γίνεται πάντα στην αρχή της ΣΛ)
    F. Εμφάνιση της storage pool
    G. Εμφάνιση των στοιχείων της ΣΛ
    H. Έλεγχος εάν η ΣΛ είναι άδεια. Αν η ΣΛ είναι άδεια εμφανίζει μήνυμα «Empty List» διαφορετικά «Not an Empty List»
    I. Έλεγχος εάν η ΣΛ είναι γεμάτη. Αν η ΣΛ είναι γεμάτη εμφανίζει μήνυμα «Full List» διαφορετικά «Not a Full List»
    J. Εμφάνιση του ελάχιστου βαθμού και των ΑΜ των μαθητών με το ελάχιστο βαθμό
    K. Κλήση της TraverseStack για την επαλήθευση της ορθής υλοποίησης του ερωτήματος J
    L. Εμφάνιση της storage pool
    M. Εμφάνιση των στοιχείων της ΣΛ

*/

#include <stdio.h>

#define NumberOfNodes 10    /*όριο μεγέθους της συνδεδεμένης λίστας 10*/
#define NilValue -1          // ειδική μεδενικη τιμη δείχνει το τέλος της Συνδ.λίστας
#define StackLimit 20

// Τύποι δεδομένων λίστας
typedef struct
{
  int am;
  float grade;
} ListElementType; /*τύπος δεδομένων για τα στοιχεία της συνδεδεμένης λίστας*/

typedef int ListPointer;

typedef struct {
    ListElementType Data;
    ListPointer  Next;
} NodeType;

typedef enum {
    FALSE, TRUE
} boolean;

// Τύποι δεδομένων στοίβας
typedef int StackElementType;

typedef struct  {
    int Top;
    StackElementType Element[StackLimit];
} StackType;

// Δήλωση συναρτήσεων λίστας
float FindMins(ListPointer List, NodeType Node[NumberOfNodes], StackType *Stack);
void CreateList(ListPointer *List);
void InitializeStoragePool(NodeType Node[], ListPointer *FreePtr);
void Insert(ListPointer *List, NodeType Node[],ListPointer *FreePtr, ListPointer PredPtr, ListElementType Item);
void GetNode(ListPointer *P, ListPointer *FreePtr, NodeType Node[]);
boolean FullList(ListPointer FreePtr);
boolean EmptyList(ListPointer List);
void printAll(ListPointer List, ListPointer FreePtr, NodeType Node[]);
void TraverseLinked(ListPointer List, NodeType Node[]);


// Δήλωση συναρτήσεων στοίβας
void CreateStack(StackType *Stack);
void Push(StackType *Stack, StackElementType Item);
void Pop(StackType *Stack, StackElementType *Item);
boolean FullStack(StackType Stack);
boolean EmptyStack(StackType Stack);
void TraverseStack(StackType Stack);


int main()
{
  int will_i=0;
  float min;
  NodeType Node[NumberOfNodes];
  ListPointer AList, FreePtr, PredPtr;
  ListElementType AnItem;
  StackElementType AM;
  StackType Stack;

  PredPtr=NilValue;

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

  for(will_i=0;will_i<5 ;will_i++)
  {
    printf("DWSE AM GIA EISAGWGH STH LISTA: ");
    scanf("%d", &AnItem.am);
    printf("DWSE VATHMO GIA EISAGWGH STH LISTA: ");
    scanf("%f", &AnItem.grade);
    Insert(&AList, Node, &FreePtr, PredPtr, AnItem);
  }

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
  min=FindMins(AList, Node, &Stack);
  printf("Min value=%.1f\n",min);
  printf("AM with min grade are: ");
  while(!EmptyStack(Stack))
    {Pop(&Stack, &AM);
    printf("%d ",AM);}

  // Ερώτημα K
  printf("\n---------------Question K--------------------\n");
  
  TraverseStack(Stack);

  // Ερώτημα L
  printf("---------------Question L--------------------\n");
  printf("--------------Storage pool------------------\n");
  printAll(AList, FreePtr, Node);

  // Ερώτημα M
  printf("---------------Question M--------------------\n");
  printf("--------------Linked list------------------\n");
  TraverseLinked(AList, Node);

    return 0;
}

// ΣΥΝΑΡΤΗΣΕΙΣ ΛΙΣΤΑΣ

float FindMins(ListPointer List, NodeType Node[NumberOfNodes], StackType *Stack)
{
  ListPointer CurrPtr;
  float min;
  StackElementType Item, studentAM;

  CreateStack(Stack);

  if(!EmptyList(List))
  {
    CurrPtr=List;
    min=Node[CurrPtr].Data.grade;

    while(CurrPtr!=NilValue)
    {
      if(Node[CurrPtr].Data.grade<=min)
      {
        if(Node[CurrPtr].Data.grade<min){
          while(!EmptyStack(*Stack)){
            Pop(&(*Stack), &Item);
          }
          min=Node[CurrPtr].Data.grade;
        }

        studentAM = Node[CurrPtr].Data.am;
        Push(&(*Stack), studentAM);
      }
       CurrPtr = Node[CurrPtr].Next;
    }
  }
  else
  {printf("Empty List...");}

  return min;
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
        Node[i].Data.am=-1;
        Node[i].Data.grade=-1.0;
    }
    Node[NumberOfNodes-1].Next=NilValue;
    Node[NumberOfNodes-1].Data.am=NilValue;
    Node[NumberOfNodes-1].Data.grade=-1.0;
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
        printf("(%d:<%d,%.1f> ->%d) ",i,Node[i].Data.am, Node[i].Data.grade, Node[i].Next);
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
          printf("(%d:<%d,%.1f> ->%d) ",CurrPtr,Node[CurrPtr].Data.am, Node[CurrPtr].Data.grade, Node[CurrPtr].Next);
          CurrPtr=Node[CurrPtr].Next;
       }
       printf("\n");
   }
  else {
    printf("Empty List ...\n");
    }
}

// ΣΥΝΑΡΤΗΣΕΙΣ ΣΤΟΙΒΑΣ

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
