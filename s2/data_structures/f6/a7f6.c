/*  Αρχείο: a7f6.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Γράψτε ένα πρόγραμμα για τη δημιουργία και επεξεργασία μιας ΔΔ που αποθηκεύει και επεξεργάζεται τα στοιχεία της με 
    την τεχνική του κατακερματισμού με αλυσίδες συνωνύμων, στην οποία αποθηκεύονται τα στοιχεία των μελών ενός
    γυμναστηρίου. Κάθε εγγραφή περιλαμβάνει τα εξής στοιχεία της κάρτας μέλους που δίνεται σε κάθε μέλος όταν
    εγγράφεται στο γυμναστήριο:
    - τον κωδικό (ακέραιος αριθμός – κλειδί κατακερματισμού)
    - το όνομα μέλους (username) (αλφαριθμητικό 20 θέσεων)
    - το ποσό οφειλής του μέλους στο γυμναστήριο (ακέραιος)
    Η συνάρτηση κατακερματισμού να είναι: h(i) = i % 5.
    Στο κυρίως πρόγραμμα θα υλοποιούνται στη σειρά οι παρακάτω λειτουργίες:
    1. Create HashList
    Δημιουργία της δομής δεδομένων
    
    2. Insert new member
    Εισαγωγή νέου μέλους
    
    3. Search for a member
    Αναζήτηση μέλους – αν υπάρχει μέλος με το συγκεκριμένο κωδικό θα εμφανίζονται τα στοιχεία του, 
    αλλιώς θα εμφανίζεται το μήνυμα ‘DEN YPARXEI EGGRAFH ME KLEIDI x’, όπου x ο κωδικός που δόθηκε προς αναζήτηση
    
    4. Update member amount
    Ενημέρωση της οφειλής του μέλους – ο χρήστης δίνει τον κωδικό του μέλους και το ποσό και ενημερώνεται κατάλληλα 
    το ποσό της οφειλής. Κατ’ αρχήν θα γίνεται έλεγχος αν υπάρχει μέλος με το συγκεκριμένο κωδικό, αν δεν
    υπάρχει θα εμφανίζεται το μήνυμα ‘DEN YPARXEI EGGRAFH ME KLEIDI x’, όπου x ο κωδικός που δόθηκε. 
    Αν ο κωδικός υπάρχει θα διαβάζεται το ποσό που θα πληρώσει. Θα γίνεται έλεγχος ώστε το ποσό που δίνεται να είναι
    μικρότερο ή ίσο της καταχωρημένης οφειλής.
    
    5. Delete a member
    Διαγραφή μέλους – η διαγραφή δεν μπορεί να πραγματοποιηθεί αν το ποσό οφειλής του μέλους δεν έχει εξοφληθεί. 
    Σε αυτή την περίπτωση η διαγραφή δεν πραγματοποιείται και εμφανίζεται το μήνυμα ‘Not deleted arrange amount’. 
    Κατ’ αρχήν θα γίνεται έλεγχος αν υπάρχει μέλος με το συγκεκριμένο κωδικό, αν δεν υπάρχει θα εμφανίζεται το μήνυμα 
    ‘DEN YPARXEI EGGRAFH ME KLEIDI x’, όπου x ο κωδικός που δόθηκε. Ο χρήστης δίνει τον κωδικό ενός μέλους 
    του γυμναστηρίου και εμφανίζονται τα περιεχόμενα της υπολίστας των συνωνύμων στην οποία ανήκει. Θα γίνεται έλεγχος 
    αν υπάρχει μέλος με το συγκεκριμένο κωδικό, αν δεν υπάρχει θα εμφανίζεται το μήνυμα ‘DEN YPARXEI EGGRAFH ME KLEIDI x’,
    όπου x ο κωδικός που δόθηκε.
    
    6. Print list of synonyms
    Συνάρτηση void PrintListOfSynonyms(HashListType HList, int key);
    Για τις λειτουργίες 2 έως και 6 ο χρήστης του προγράμματος θα έχει τη δυνατότητα εισαγωγής, αναζήτησης, ενημέρωσης,
    διαγραφής και εμφάνισης της λίστας συνωνύμων για όσα μέλη του γυμναστηρίου επιθυμεί μέσω σχετικού μηνύματος
    ‘Continue Y/N?’ Μετά τις λειτουργίες 1, 2, 4, 5 θα καλείτε τις Print_HashList(HList) και PrintPinakes(HList). Στην
    Print_HashList(HList) δε θα εμφανίζετε τη λίστα με τις ελεύθερες θέσεις της δομής.
    
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define HMax 5              /*     το μέγεθος του πίνακα HashTable
                                ενδεικτικά ίσο με 5 */
#define VMax 30             /*το μέγεθος της λίστας,
                                ενδεικτικά ίσο με 30 */
#define EndOfList -1        /* σημαία που σηματοδοτεί το τέλος της λίστας
                                και της κάθε υπολίστας συνωνύμων */

// Δήλωση τύπων
typedef struct{
	char name[20];
	int amount;
} ListElementType;  /*τύπος δεδομένων για τα στοιχεία της λίστας */
typedef int KeyType;

typedef struct {
	KeyType RecKey;
	ListElementType Data;
	int Link;
} ListElm;

typedef struct  {
	int HashTable[HMax];   // πίνακας δεικτών προς τις υπολίστες συνωνύμων
    int Size;                // πλήθος εγγραφών της λίστας List
	int SubListPtr;          // Dδείκτης σε μια υπολίστα συνωνύμων
    int StackPtr;           // δείκτης προς την πρώτη ελεύθερη θέση της λίστας List
	ListElm List[VMax];
} HashListType;

typedef enum {
    FALSE, TRUE
} boolean;

// Δήλωση συναρτήσεων
void CreateHashList(HashListType *HList);
int HashKey(KeyType Key);
boolean FullHashList(HashListType HList);
void SearchSynonymList(HashListType HList,KeyType KeyArg,int *Loc,int *Pred);
void SearchHashList(HashListType HList,KeyType KeyArg,int *Loc,int *Pred);
void AddRec(HashListType *HList,ListElm InRec);
void DeleteRec(HashListType *HList,KeyType DelKey);

void Print_HashList(HashListType HList);
void PrintPinakes(HashListType HList);
void PrintListOfSynonyms(HashListType HList, KeyType key);

int main()
{
	// Δήλωση μεταβλητών
    char ch;
    HashListType HList;
    ListElm AnItem;
    KeyType AKey;
    int Loc, Pred;

	// Ερώτημα 1
    printf("1. Create HashList\n");
    CreateHashList(&HList); // Δημιούργησε τη δομή κατακερματισμού
    Print_HashList(HList);
    PrintPinakes(HList);

	// Ερώτημα 2
    printf("2. Insert new member\n");
    do // Επαναληπτικά
    {
        printf("Give code: ");
        scanf("%d", &AnItem.RecKey); // Διάβασε κωδικό πελάτη
        printf("Give name: ");
        scanf("%s", AnItem.Data.name); getchar(); // Διάβασε όνομα πελάτη
        printf("Give amount: ");
        scanf("%d", &AnItem.Data.amount); // Διάβασε το ποσό που χρωστάει ο πελάτης
        AddRec(&HList, AnItem);

        printf("\nContinue Y/N: ");
        do{ // Επαναληπτικά
            scanf("%c", &ch); // Διάβασε τον χαρακτήρα ch
        } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y');
    } while (toupper(ch)!='N');
    Print_HashList(HList);
    PrintPinakes(HList);

    // Ερώτημα 3
    printf("3. Search for a member\n");
    do // Επαναληπτικά
    {
        printf("Give code: "); 
        scanf("%d", &AnItem.RecKey); // Διάβασε κωδικό πελάτη
        SearchHashList(HList, AnItem.RecKey, &Loc, &Pred); // Αναζήτησε τον πελάτη με τον παραπάνω κωδικό
        if(Loc!=EndOfList) // Αν βρεθεί ο πελάτης Εμφάνισε τα στοιχεία του
            printf("[%d, %s, %d, %d]\n", HList.List[Loc].RecKey, HList.List[Loc].Data.name, HList.List[Loc].Data.amount, HList.List[Loc].Link);
        else // Αλλιώς εμφάνισε μήνυμα
            printf("DEN YPARXEI EGGRAFH ME KLEIDI %d\n", AnItem.RecKey);
        printf("\nContinue Y/N: ");
        do{ // Επαναληπτικά
            scanf("%c", &ch); // Διάβασε τον χαρακτήρα ch
        } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y');
    } while (toupper(ch)!='N');

    // Ερώτημα 4
    printf("4. Update member amount\n");
    do // Επαναληπτικά
    {
        printf("Give code: ");
        scanf("%d", &AnItem.RecKey); // Διάβασε κωδικό πελάτη
        SearchHashList(HList, AnItem.RecKey, &Loc, &Pred); // Αναζήτησε τον πελάτη με τον παραπάνω κωδικό
        if(Loc!=EndOfList) // Αν βρεθεί ο πελάτης
        { // Εμφάνισε τα στοιχεία του
            printf("[%d, %s, %d, %d]\n", HList.List[Loc].RecKey, HList.List[Loc].Data.name, HList.List[Loc].Data.amount, HList.List[Loc].Link);
            printf("Give amount: ");
            scanf("%d", &AKey); // Διάβασε το νέο ποσό
            if(HList.List[Loc].Data.amount>=AKey) // Αν το ποσό του πελάτη είναι μεγαλύτερο ή ίσο του νέου ποσού
                HList.List[Loc].Data.amount-=AKey; // Ενημέρωσε το ποσό του πελάτη
        }
        else // Αλλιώς εμφάνισε μήνυμα
            printf("DEN YPARXEI EGGRAFH ME KLEIDI %d\n", AnItem.RecKey);
        printf("\nContinue Y/N: ");
        do{ // Επαναληπτικά
            scanf("%c", &ch); // Διάβασε τον χαρακτήρα ch
        } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y');
    } while (toupper(ch)!='N');

    Print_HashList(HList);
    PrintPinakes(HList);

    // Ερώτημα 5
    printf("5. Delete a member\n");
    do // Επαναληπτικά
    {
        printf("Give code: ");
        scanf("%d", &AnItem.RecKey); // Διάβασε κωδικό πελάτη
        SearchHashList(HList, AnItem.RecKey, &Loc, &Pred); // Αναζήτησε τον πελάτη με τον παραπάνω κωδικό
        if(Loc!=EndOfList) // Αν βρεθεί ο πελάτης
        {
            if(HList.List[Loc].Data.amount==0) // Αν ο πελάτης δεν χρωστάει ποσό
                DeleteRec(&HList, AnItem.RecKey); // Διέγραψε τον πελάτη από τη δομή
            else // Αν χρωστάει, εμφάνισε μήνυμα
                printf("Not deleted arrange amount\n");
        }
        else // Αν δεν βρεθεί ο πελάτης εμφάνισε μήνυμα
            printf("DEN YPARXEI EGGRAFH ME KLEIDI %d\n", AnItem.RecKey);

        printf("\nContinue Y/N: ");
        do{ // Επαναληπτικά
            scanf("%c", &ch);
        } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y');
    } while (toupper(ch)!='N');
    Print_HashList(HList);
    PrintPinakes(HList);

    // Ερώτημα 6
    printf("6. Print list of synonyms\n");
    do // Επαναληπτικά
    {
        printf("Give code: ");
        scanf("%d", &AnItem.RecKey); // Διάβασε κωδικό πελάτη
        SearchHashList(HList, AnItem.RecKey, &Loc, &Pred); // Αναζήτησε τον πελάτη με τον παραπάνω κωδικό
        if(Loc!=EndOfList) // Αν βρεθεί ο πελάτης
        { // Εμφάνισε τα στοιχεία του
            printf("[%d, %s, %d, %d]\n", HList.List[Loc].RecKey, HList.List[Loc].Data.name, HList.List[Loc].Data.amount, HList.List[Loc].Link);
            PrintListOfSynonyms(HList, AnItem.RecKey); // Εμφάνισε τη λίστα συνωνύμων για τον κωδικό του πελάτη
        }
        else // Αλλιώς εμφάνισε μήνυμα
            printf("DEN YPARXEI EGGRAFH ME KLEIDI %d\n", AnItem.RecKey);
        printf("\nContinue Y/N: ");
        do{ // Επαναληπτικά
            scanf("%c", &ch);// Διάβασε τον χαρακτήρα ch
        } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y');
    } while (toupper(ch)!='N');

    return 0;
}

// Συναρτήσεις

int HashKey(KeyType Key)
/* Δέχεται:    Την τιμή Key ενός κλειδιού.
   Λειτουργία: Βρίσκει την τιμή κατακερματισμού HValue για το κλειδί Key.
   Επιστρέφει: Την τιμή κατακερματισμού HValue
*/
{
	/*σε περίπτωση που το KeyType δεν είναι ακέραιος
	θα πρέπει να μετατρέπεται κατάλληλα το κλειδί σε αριθμό*/
	return Key%HMax;
}

void CreateHashList(HashListType *HList)
/* Λειτουργία: Δημιουργεί μια δομή HList.
   Επιστρέφει: Την δομή HList
*/
{
	int index;

	HList->Size=0;           //ΔΗΜΙΟΥΡΓΕΙ ΜΙΑ ΚΕΝΗ ΛΙΣΤΑ
	HList->StackPtr=0;       //ΔΕΙΚΤΗς ΣΤΗ ΚΟΡΥΦΗ ΤΗΣ ΣΤΟΙΒΑΣ ΤΩΝ ΕΛΕΥΘΕΡΩΝ ΘΕΣΕΩΝ

    /*ΑΡΧΙΚΟΠΟΙΕΙ ΤΟΝ ΠΙΝΑΚΑ HashTable ΤΗΣ ΔΟΜΗΣ HList ΩΣΤΕ ΚΑΘΕ ΣΤΟΙΧΕΙΟΥ ΤΟΥ
        ΝΑ ΕΧΕΙ ΤΗ ΤΙΜΗ EndOfList (-1)*/
    index=0;
	while (index<HMax)
	{
		HList->HashTable[index]=EndOfList;
		index=index+1;
    }

     //Δημιουργία της στοίβας των ελεύθερων θέσεων στη λίστα HList
    index=0;
	while(index < VMax-1)
	{
		HList->List[index].Link=index+1;
		index=index+1;
	}
	HList->List[index].Link=EndOfList;
}

boolean FullHashList(HashListType HList)
/* Δέχεται:    Μια δομή HList.
   Λειτουργία: Ελέγχει αν η λίστα List της δομής HList είναι γεμάτη.
   Επιστρέφει: TRUE αν η λίστα List είναι γεμάτη, FALSE διαφορετικά.
*/
{
	return(HList.Size==VMax);
}

void SearchSynonymList(HashListType HList,KeyType KeyArg,int *Loc,int *Pred)
/* Δέχεται:     Μια δομή HList και μια τιμή κλειδιού KeyArg.
    Λειτουργία: Αναζητά μια εγγραφή με κλειδί KeyArg στην υπολίστα συνωνύμων.
    Επιστρέφει: Τη θέση Loc της εγγραφής και τη θέση Pred της προηγούμενης
                εγγραφής στην υπολίστα
*/
{
	int Next;
	Next=HList.SubListPtr;
	*Loc=-1;
	*Pred=-1;
	while(Next!=EndOfList)
	{
		if (HList.List[Next].RecKey==KeyArg)
		{
			*Loc=Next;
			Next=EndOfList;
		}
		else
		{
			*Pred=Next;
			Next=HList.List[Next].Link;
		}
	}
}
void SearchHashList(HashListType HList,KeyType KeyArg,int *Loc,int *Pred)
/* Δέχεται:     Μια δομή HList και μια τιμή κλειδιού KeyArg.
    Λειτουργία: Αναζητά μια εγγραφή με κλειδί KeyArg στη δομή HList.
    Επιστρέφει: Τη θέση Loc της εγγραφής και τη θέση Pred της
                προηγούμενης εγγραφής της υπολίστας στην οποία ανήκει.
                Αν δεν υπάρχει εγγραφή με κλειδί KeyArg τότε Loc=Pred=-1
*/
{
	int HVal;
	HVal=HashKey(KeyArg);
    if (HList.HashTable[HVal]==EndOfList)
	{
		*Pred=-1;
		*Loc=-1;
	}
	else
	{
		HList.SubListPtr=HList.HashTable[HVal];
		SearchSynonymList(HList,KeyArg,Loc,Pred);
	}
}

void AddRec(HashListType *HList,ListElm InRec)
/* Δέχεται:    Μια δομή HList και μια εγγραφή InRec.
   Λειτουργία: Εισάγει την εγγραφή InRec στη λίστα List, αν δεν είναι γεμάτη,
                και ενημερώνει τη δομή HList.
   Επιστρέφει: Την τροποποιημένη δομή HList.
   Έξοδος:     Μήνυμα γεμάτης λίστας, αν η List είναι γεμάτη, διαφορετικά,
                αν υπάρχει ήδη εγγραφή με το ίδιο κλειδί,
                εμφάνιση αντίστοιχου μηνύματος
*/
{
	int Loc, Pred, New, HVal;

   // New=0;
	if(!(FullHashList(*HList)))
	{
		Loc=-1;
		Pred=-1;
		SearchHashList(*HList,InRec.RecKey,&Loc,&Pred);
		if(Loc==-1)
		{
			HList->Size=HList->Size +1;
			New=HList->StackPtr;
			HList->StackPtr=HList->List[New].Link;
			HList->List[New]=InRec;
			if (Pred==-1)
			{
			    HVal=HashKey(InRec.RecKey);
                HList->HashTable[HVal]=New;
				HList->List[New].Link=EndOfList;
			}
			else
			{
                HList->List[New].Link=HList->List[Pred].Link;
				HList->List[Pred].Link=New;
			}
		}

		else
		{
			printf("YPARXEI HDH EGGRAFH ME TO IDIO KLEIDI \n");
		}
	}
	else
	{
		printf("Full list...");
	}
}
void DeleteRec(HashListType *HList,KeyType DelKey)
/* DEXETAI:    TH DOMH (HList) KAI To KLEIDI (DelKey) THS EGGRAFHS
               POY PROKEITAI NA DIAGRAFEI
   LEITOYRGIA: DIAGRAFEI, THN EGGRAFH ME KLEIDI (DelKey) APO TH
               LISTA (List), AN YPARXEI ENHMERWNEI THN DOMH HList
   EPISTREFEI: THN TROPOPOIHMENH DOMH (HList)
   EJODOS:     "DEN YPARXEI EGGRAFH ME KLEIDI" MHNYMA
*/
{
	int Loc, Pred, HVal;

	SearchHashList(*HList,DelKey,&Loc,&Pred);
	if(Loc!=-1)
	{
		if(Pred!=-1)
		{
			HList->List[Pred].Link=HList->List[Loc].Link;
		}
		else
		{
			HVal=HashKey(DelKey);
		    HList->HashTable[HVal]=HList->List[Loc].Link;
		}
		HList->List[Loc].Link=HList->StackPtr;
		HList->StackPtr=Loc;
		HList->Size=HList->Size -1;
	}
	else
	{
		printf("DEN YPARXEI  EGGRAFH ME KLEIDI %d \n",DelKey);
	}
}

void Print_HashList(HashListType HList)
{
   int i, SubIndex;

     printf("HASHLIST STRUCTURE with SYNONYM CHAINING\n");
     printf("========================================\n");

          printf("PINAKAS DEIKTWN STIS YPO-LISTES SYNWNYMWN EGGRAFWN:\n");
            for (i=0; i<HMax;i++)
              printf("%d| %d\n",i,HList.HashTable[i]);

          printf("OI YPO-LISTES TWN SYNWNYMWN EGGRAFWN:\n");
          for (i=0; i<HMax;i++)
          {
              SubIndex = HList.HashTable[i];
              while ( SubIndex != EndOfList )
              {
                   printf("[%d, %s, %d, %d]",HList.List[SubIndex].RecKey,HList.List[SubIndex].Data.name,HList.List[SubIndex].Data.amount,HList.List[SubIndex].Link);
                   printf(" -> ");
                   SubIndex = HList.List[SubIndex].Link;
               } //* while *)
              printf("TELOS % dHS YPO-LISTAS\n", i);
          }

          printf("MEGE8OS THS LISTAS = %d\n", HList.Size);
          printf("========================================\n");
}

void PrintPinakes(HashListType HList)
{
    int i;
	printf("Hash table\n");
	for (i=0; i<HMax;i++)
              printf("%d| %d\n",i,HList.HashTable[i]);

	printf("Hash List\n");
    for (i=0;i<HList.Size;i++)
	   printf("%d) %d, %s, %d, %d\n",i,HList.List[i].RecKey,HList.List[i].Data.name,HList.List[i].Data.amount,HList.List[i].Link);
	printf("\n");
}

void PrintListOfSynonyms(HashListType HList, KeyType key)
{
    KeyType Hval, SubIndex; // Δήλωση μεταβλητών

    Hval=HashKey(key); // Υπολογίζω την τιμή κατακερματισμού του key

    SubIndex=HList.HashTable[Hval]; // Αρχικοποίησε κατάλληλα το SubIndex στην αρχή της λίστας συνωνύμων
    while(SubIndex!=EndOfList) // Όσο δεν φτάνουμε στο τέλος της λίστας
    {  // Εμφάνισε όλα τα στοιχεία του τρέχοντος πελάτη της λίστας
        printf("%d: [%d, %s, %d]\n",SubIndex,HList.List[SubIndex].RecKey,HList.List[SubIndex].Data.name,HList.List[SubIndex].Data.amount);
        SubIndex=HList.List[SubIndex].Link; // Ενημέρωσε το SubIndex στο επόμενο στοιχείο της λίστας συνωνύμων
    }
}
