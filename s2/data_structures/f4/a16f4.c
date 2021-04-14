/*  Αρχείο: a16f4.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Σε μία ουρά κάθε στοιχείο εισέρχεται σε κάποια συγκεκριμένη θέση σύμφωνα με το βαθμό προτεραιότητας (σε
    αύξουσα σειρά). Να γραφεί πρόγραμμα που θα περιλαμβάνει τα παρακάτω:
    - Εισαγωγή του πλήθους των κόμβων της ουράς.
    - Τη συνάρτηση void insert_prot(QueueType *Queue, QueueElementType Item) την εισαγωγή στοιχείων
    στην ουρά, κάθε κόμβος της οποίας θα περιέχει έναν τριψήφιο κωδικό αριθμό και τον βαθμό προτεραιότητας (1-20). 
    Σε περίπτωση ίδιου βαθμού προτεραιότητας το στοιχείο εισέρχεται τελευταίο στην αντίστοιχη προτεραιότητα.
    - Τη συνάρτηση void TraverseQ(QueueType Queue) που θα εμφανίζει τα περιεχόμενα της ουράς κατά αύξοντα
    βαθμό προτεραιότητας. Τα στοιχεία κάθε κόμβου εμφανίζονται σε ξεχωριστή σειρά με ένα κενό μεταξύ τους και
    πρώτο το βαθμό προτεραιότητας.

*/

#include <stdio.h>
#include <stdlib.h>

// Δήλωση τύπων
typedef struct QueueNode *QueuePointer;

typedef struct
{
    int code;
    int prot;
} QueueElementType;

typedef struct QueueNode
{
	QueueElementType Data;
    QueuePointer Next;
} QueueNode;

typedef struct
{
    QueuePointer Front;
    QueuePointer Rear;
} QueueType;

typedef enum {
    FALSE, TRUE
} boolean;


// Δήλωση συναρτήσεων
void CreateQ(QueueType *Queue);
boolean EmptyQ(QueueType Queue);
void AddQ(QueueType *Queue, QueueElementType Item);
void RemoveQ(QueueType *Queue, QueueElementType *Item);
void TraverseQ(QueueType Queue);

void insert_prot(QueueType *Queue, QueueElementType Item);

int main()
{
    QueueType AQueue;
    QueueElementType AnItem;
    int plithos,i;

    CreateQ(&AQueue); // Δημιουργώ την ουρά AQueue

    printf("DWSE TO PLITHOS: ");
    scanf("%d", &plithos); // Διαβάζω το πλήθος των στοιχείων που θα εισαχθούν στην ουρά
    for(i=0;i<plithos;i++)
    {
        printf("DWSE TON KODIKO TOY %dou KOMVOU: ", i+1);
        scanf("%d", &AnItem.code); // Διαβάζω τον κωδικό του κόμβου
        printf("DWSE TO VATHMO PROTERAIOTITAS TOU %dou KOMVOU: ", i+1);
        scanf("%d", &AnItem.prot); // Διαβάζω τον βαθμό προτεραιότητας του κόμβου
        insert_prot(&AQueue, AnItem); // Εισάγω τον κόμβο στην ουρά
    }

    printf("----------Priority Queue-------------\n");
    TraverseQ(AQueue); // Εμφάνιση της ουράς

    return 0;
}

// Υλοποίηση συναρτήσεων

void insert_prot(QueueType *Queue, QueueElementType Item)
{
    QueuePointer TempPtr;
    QueuePointer CurrPtr;
    QueuePointer PredPtr;
    boolean flag;

    TempPtr=(QueuePointer)malloc(sizeof(struct QueueNode)); // Δέσμευση μνήμης για τον νέο κόμβο
    TempPtr->Data=Item; // Ανάθεση τιμής στα δεδομένα (Data) του νέου κόμβου
    TempPtr->Next=NULL; // Αρχικοποίηση του δείκτη (Next) του νέου κόμβου

    if(EmptyQ(*Queue)) // Αν η ουρά είναι κενή
    {
        Queue->Front=TempPtr; // Ενημέρωση του δείκτη Front της ουράς στον νέο (και μοναδικό) κόμβο
        Queue->Rear=TempPtr; // Ενημέρωση του δείκτη Rear της ουράς στον νέο (και μοναδικό) κόμβο
    }
    else
    {
        PredPtr=Queue->Front; // Αρχικοποίηση του PredPtr στην αρχή της ουράς
        CurrPtr=Queue->Front; // Αρχικοποίηση του CurrPtr στην αρχή της ουράς
        flag=FALSE; // Αρχικοποίηση flag

        if(CurrPtr->Data.prot>Item.prot) /* Αν ο βαθμός προτεραιότητας του τρέχοντος κόμβου (1ου κόμβου) είναι
                                        μεγαλύτερος από τον βαθμό του νέου αντικειμένου */
        //Ο κόμβος εισάγεται στην αρχή της ουράς
        {
            Queue->Front=TempPtr; // Ενημέρωση του δείκτη Front της ουράς στον νέο κόμβο
            TempPtr->Next=CurrPtr; // Ενημέρωση του δείκτη Next του νέου κόμβου στον τρέχοντα κόμβο
        }
        else
        {
            while(CurrPtr!=NULL && flag==FALSE) // Όσο δεν έχουμε φτάσει στο τέλος της ουράς και δεν έγινε η εισαγωγή
            {
                if(CurrPtr->Data.prot>Item.prot) /* Αν ο βαθμός προτεραιότητας του τρέχοντος κόμβου είναι
                                                    μεγαλύτερος από τον βαθμό του νέου αντικειμένου */
                {
                    PredPtr->Next=TempPtr; // Ενημέρωση του δείκτη Next του προηγούμενου κόμβου στον νέο κόμβο
                    TempPtr->Next=CurrPtr; // Ενημέρωση του δείκτη Next του νέου κόμβου στον τρέχοντα κόμβο
                    flag=TRUE; // Ενημέρωση του flag
                }
                PredPtr=CurrPtr; // Ενημέρωση του PredPtr στον τρέχοντα κόμβο της ουράς
                CurrPtr=CurrPtr->Next; // Ενημέρωση του CurrPtr στον επόμενο κόμβο της ουράς
            }
            if(flag==FALSE) // Αν δεν έχει γίνει η εισαγωγή
            {
               PredPtr->Next=TempPtr; // Ενημέρωση του δείκτη Next του προηγούμενου κόμβου στον νέο κόμβο
               Queue->Rear=TempPtr; // Ενημέρωση του δείκτη Rear στον νέο κόμβο
            }
        }
    }
}

void CreateQ(QueueType *Queue)
/* Λειτουργία: Δημιουργεί μια κενή συνδεδεμένη ουρά. 
   Επιστρέφει: Μια κενή συνδεδεμένη ουρά 
*/
{
	Queue->Front = NULL;
	Queue->Rear = NULL;
}

boolean EmptyQ(QueueType Queue)
/* Δέχεται:    Μια συνδεδεμένη ουρά. 
   Λειτουργία: Ελέγχει αν η συνδεδεμένη ουρά είναι κενή. 
   Επιστρέφει: True αν η ουρά είναι κενή, false  διαφορετικά 
*/
{
	return (Queue.Front==NULL);
}

void AddQ(QueueType *Queue, QueueElementType Item)
/* Δέχεται:    Μια συνδεδεμένη ουρά Queue και ένα  στοιχείο Item.
   Λειτουργία: Προσθέτει το στοιχείο Item στο τέλος της συνδεδεμένης ουράς Queue.
   Επιστρέφει: Την τροποποιημένη ουρά
*/
{
	QueuePointer TempPtr;

    TempPtr= (QueuePointer)malloc(sizeof(struct QueueNode));
    TempPtr->Data = Item; 
    TempPtr->Next = NULL;
    if (Queue->Front==NULL) 
        Queue->Front=TempPtr;
    else
        Queue->Rear->Next = TempPtr;
    Queue->Rear=TempPtr;
}

void RemoveQ(QueueType *Queue, QueueElementType *Item)
/* Δέχεται:    Μια συνδεδεμένη ουρά. 
   Λειτουργία: Αφαιρεί το στοιχείο Item από την  κορυφή της συνδεδεμένης ουράς, 
                αν δεν είναι  κενή. 
   Επιστρέφει: Το στοιχείο Item και την τροποποιημένη συνδεδεμένη ουρά. 
   Έξοδος:     Μήνυμα κενής ουράς, αν η ουρά είναι  κενή 
*/
{
    QueuePointer TempPtr;
    
    if (EmptyQ(*Queue)) {
   	    printf("EMPTY Queue\n");
    }
   else
   {
        TempPtr = Queue->Front;
        *Item=TempPtr->Data;
        Queue->Front = Queue->Front->Next;     
        free(TempPtr);
        if (Queue->Front==NULL) Queue->Rear=NULL;
    }   
}

void TraverseQ(QueueType Queue)
{
    QueuePointer CurrPtr;

   if (EmptyQ(Queue))
    {
           printf("EMPTY Queue\n");
    }
   else
   {
           CurrPtr = Queue.Front;
         while ( CurrPtr!=NULL )
        {
               printf("%d %d\n", CurrPtr->Data.prot, CurrPtr->Data.code); // Αλλαγή στον τρόπο εμφάνισης
             CurrPtr = CurrPtr->Next;
        }
   }
    printf("\n");
}

