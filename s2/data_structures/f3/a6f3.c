/*  Αρχείο: a6f3.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Μια εναλλακτική υλοποίηση μιας ουράς που χρησιμοποιεί ένα κυκλικό πίνακα και δεν απαιτεί να διατηρούμε μία κενή
    θέση μεταξύ της εμπρός και της πίσω άκρη της για να ξεχωρίζει μια κενή ουρά από μια γεμάτη χρειάζεται απλά την
    προσθήκη ενός ακέραιου πεδίου Count στην εγγραφή τύπου QueueType, στο οποίο αποθηκεύεται ο τρέχων αριθμός
    στοιχείων της ουράς. Να κάνετε τις απαραίτητες αλλαγές στη δήλωση του τύπου της εγγραφής και στις βασικές 
    λειτουργίες του ΑΤΔ ουρά με πίνακες, έτσι ώστε να χρησιμοποιείται αυτό το επιπλέον πεδίο και να μην διατηρείται
    κενή θέση στον πίνακα όπου αποθηκεύονται τα στοιχεία της ουράς. Η TraverseQ που σας δίνεται στο TestQueue 
    θα πρέπει επίσης να τροποποιηθεί. Για να ελέγξετε την ορθότητα του προγράμματος σας
    
    (a) Δημιουργήστε μια ουρά (QueueLimit=10) που περιλαμβάνει όλους τους ακέραιους αριθμούς στο διάστημα [0..9].
    Εμφανίστε την ουρά (με βοηθητική διαδικασία TraverseQ) την τιμή της Front, Rear και του μετρητή 
    των στοιχείων της ουράς.
    (b) Στη συνέχεια επιχειρήστε να προσθέσετε ένα οποιοδήποτε στοιχείο. 
    Εμφανίστε την ουρά (με βοηθητική διαδικασία TraverseQ) 
    (c) Αφαιρέστε τη κεφαλή της ουράς και εμφανίστε την ουρά (με βοηθητική διαδικασία TraverseQ), 
    το στοιχείο που αφαιρέσατε, την τιμή της Front, Rear και του μετρητή των στοιχείων της ουράς
    (d) Προσθέσετε ένα οποιοδήποτε στοιχείο και εμφανίστε την ουρά (με βοηθητική διαδικασία TraverseQ), 
    την τιμή της Front, Rear και του μετρητή των στοιχείων της ουράς
    (e) Στη συνέχεια επιχειρήστε να προσθέσετε ένα οποιοδήποτε στοιχείο. Εμφανίστε την ουρά 
    (με βοηθητική διαδικασία TraverseQ), την τιμή της Front, Rear και του μετρητή των στοιχείων της ουράς.
    (f) Αδειάστε την ουρά. Μετά την αφαίρεση κάθε φορά της κεφαλής της ουράς εμφανίστε την ουρά (με βοηθητική
    διαδικασία TraverseQ), το στοιχείο που αφαιρέσατε, την τιμή της Front, Rear και του μετρητή των στοιχείων 
    της ουράς.

*/
#include <stdio.h>

#define QueueLimit 10  //το όριο μεγέθους της ουράς

typedef int QueueElementType;   /* ο τύπος δεδομένων των στοιχείων της ουράς
                                  ενδεικτικά τύπος int */
typedef struct {
	int Front, Rear;
   int Count; 
	QueueElementType Element[QueueLimit];;
} QueueType;

typedef enum {FALSE, TRUE} boolean;

void CreateQ(QueueType *Queue);
boolean EmptyQ(QueueType Queue);
boolean FullQ(QueueType Queue);
void RemoveQ(QueueType *Queue, QueueElementType *Item);
void AddQ(QueueType *Queue, QueueElementType Item);
void TraverseQ(QueueType Queue);

int main()
{
   QueueType MyQueue;
   QueueElementType i, temp;

    //Ερώτημα a
    printf("---a---\n");
    CreateQ(&MyQueue); // Δημιουργία ουράς
    for(i=0;i<QueueLimit;i++)
        AddQ(&MyQueue, i); // Προσθήκη αριθμών στην ουρά
    TraverseQ(MyQueue); // Εκτύπωση ουράς
    printf("Front=%d Rear=%d Count=%d\n", MyQueue.Front, MyQueue.Rear, MyQueue.Count);

    //Ερώτημα b
    printf("---b---\n");
    AddQ(&MyQueue, 13); // Προσθήκη στην ουρά ενός αριθμού
    printf("\n");
    TraverseQ(MyQueue); // Εκτύπωση ουράς (εδώ είναι γεμάτη)
    printf("Front=%d Rear=%d Count=%d\n", MyQueue.Front, MyQueue.Rear, MyQueue.Count);

    //Ερώτημα c
    printf("---c---\n");
    RemoveQ(&MyQueue, &temp); // Αφαίρεση ενός αριθμού
    TraverseQ(MyQueue); // Εκτύπωση ουράς (ποιος αριθμός βγήκε)
    printf("Removed item=%d Front=%d Rear=%d Count=%d\n", temp, MyQueue.Front, MyQueue.Rear, MyQueue.Count);

    //Ερώτημα d
    printf("---d---\n");
    AddQ(&MyQueue, 13); // Προσθήκη αριθμού στην ουρά
    TraverseQ(MyQueue); // Εκτύπωση ουράς
    printf("Front=%d Rear=%d Count=%d\n", MyQueue.Front, MyQueue.Rear, MyQueue.Count);

    //Ερώτημα e
    printf("---e---\n");
    AddQ(&MyQueue, 14); // Προσθήκη επόμενου αριθμού στην ουρά
    printf("\n");
    TraverseQ(MyQueue); // Εκτύπωση ουράς (εδώ είναι γεμάτη)
    printf("Front=%d Rear=%d Count=%d\n", MyQueue.Front, MyQueue.Rear, MyQueue.Count);

    //Ερώτημα f
    printf("---f---\n");
    while(!EmptyQ(MyQueue)) // Όσο η ουρά δεν είναι άδεια
    {
        RemoveQ(&MyQueue, &temp); // Βγάζε ένα αριθμό
        TraverseQ(MyQueue); // Εκτύπωνε τον αριθμό
        printf("Removed item=%d Front=%d Rear=%d Count=%d\n", temp, MyQueue.Front, MyQueue.Rear, MyQueue.Count);
    }

    return 0;

}

// ΣΥΝΑΡΤΗΣΕΙΣ

void CreateQ(QueueType *Queue)
/*  Λειτουργία:  Δημιουργεί μια κενή ουρά.
    Επιστρέφει:  Κενή ουρά
*/
{
	Queue->Front = 0;
	Queue->Rear = 0;
   Queue->Count = 0; // Προσθήκη ακέραιου πεδίου Count
}

boolean EmptyQ(QueueType Queue)
/* Δέχεται:    Μια ουρά.
   Λειτουργία: Ελέγχει αν η ουρά είναι κενή.
   Επιστρέφει: True αν η ουρά είναι κενή, False διαφορετικά
*/
{
	return (Queue.Count == 0); // Έλεγχος αν είναι άδεια η ουρά με το πεδίο Count
}

boolean FullQ(QueueType Queue)
/* Δέχεται:    Μια ουρά.
   Λειτουργία: Ελέγχει αν η ουρά είναι γεμάτη.
   Επιστρέφει: True αν η ουρά είναι γεμάτη, False διαφορετικά
*/
{
	return (Queue.Count == QueueLimit); // Έλεγχος αν είναι γεμάτη η ουρά με το πεδίο Count
}

void RemoveQ(QueueType *Queue, QueueElementType *Item)
/* Δέχεται:    Μια ουρά.
   Λειτουργία: Αφαιρεί το στοιχείο Item από την εμπρός άκρη της ουράς
                αν η ουρά δεν είναι κενή.
   Επιστρέφει: Το στοιχείο Item και την τροποποιημένη ουρά.
   Έξοδος:     Μήνυμα κενής ουρά αν η ουρά είναι κενή
*/
{
	if(!EmptyQ(*Queue))
	{
		*Item = Queue ->Element[Queue -> Front];
		Queue ->Front  = (Queue ->Front + 1) % QueueLimit;
      (Queue->Count)--; // Στην αφαίρεση, τότε μείωσε και το Count
   }
	else
		printf("Empty Queue");
}

void AddQ(QueueType *Queue, QueueElementType Item)
/* Δέχεται:    Μια ουρά Queue και ένα στοιχείο Item.
   Λειτουργία: Προσθέτει το στοιχείο Item στην ουρά Queue
                αν η ουρά δεν είναι γεμάτη.
   Επιστρέφει: Την τροποποιημένη ουρά.
   Έξοδος:     Μήνυμα γεμάτης ουράς αν η ουρά είναι γεμάτη
*/
{
	if(!FullQ(*Queue))
	{
		Queue ->Element[Queue ->Rear] = Item;
		Queue ->Rear = (Queue ->Rear + 1) % QueueLimit;
      (Queue->Count)++; // Στην πρόσθεση, αύξησε και το Count
	}
	else
		printf("Full Queue");
}

void TraverseQ(QueueType Queue) {
	int current;
	current = Queue.Front;
	printf("Queue: ");
   if(EmptyQ(Queue))
   {printf("Empty Queue");}
	while (current != Queue.Rear || Queue.Count!=0) {
      printf("%d ", Queue.Element[current]);
		current = (current + 1) % QueueLimit;
      (Queue.Count)--;

	}
	printf("\n");
}

/*
// Η TraverseQ με τη χρήση for

void TraverseQ(QueueType Queue) {
	int current,i;
   printf("Queue: ");
	if(EmptyQ(Queue)){
        printf("Empty Queue");
	}
        else{
            current=Queue.Front;
        for(i=0;i<Queue.count;i++) {
        printf("%d ",Queue.Element[current]);
        current=(current+1) % QueueLimit;
        }
	
	}
   printf("\n");
}
*/
