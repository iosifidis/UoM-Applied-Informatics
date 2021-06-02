/*  Αρχείο: a4f6.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Σε έναν εκπαιδευτικό οργανισμό εργάζονται εκπαιδευτικοί διαφόρων ειδικοτήτων. Τα βασικά τους στοιχεία υπάρχουν σε 
    ένα αρχείου κειμένου ‘i4f6.txt’ (σε διαφορετικές γραμμές για κάθε εκπαιδευτικό):
    Ονομα: αλφαριθμητικό 10 χαρακτήρες
    Επώνυμο: αλφαριθμητικό 20 χαρακτήρες
    Τηλέφωνο: αλφαριθμητικό 10 θέσεων
    Κωδικός ειδικότητας: byte (1=Θεολόγοι, 2=Φιλόλογοι, …20=Πληροφορικοί)
    
    Στο κυρίως πρόγραμμα θα υλοποιούνται στη σειρά οι παρακάτω λειτουργίες:
    
    1. BuildHashList
    Διάβασμα των στοιχείων από το αρχείο κειμένου και δημιουργία Δομής Δεδομένων (ΔΔ) που αποθηκεύει και επεξεργάζεται 
    τα στοιχεία της με την τεχνική του κατακερματισμού με αλυσίδες συνωνύμων. Το κλειδί σχηματίζεται από το όνομα+κενό χαρακτήρα+επώνυμο. 
    Πχ αν το όνομα είναι «nikos» και το επώνυμο «dimitriou», τότε το κλειδί κατακερματισμού που θα σχηματιστεί είναι:
    «nikos dimitriou» 
    void BuildHashList(HashListType *HList);
    
    2. Insert new teacher
    Εισαγωγή των στοιχείων ενός νέου εκπαιδευτικού στη ΔΔ κατακερματισμού με αλυσίδες συνωνύμων. Η εισαγωγή νέων εκπαιδευτικών στη ΔΔ
    γίνεται επαναληπτικά μέσω σχετικού μηνύματος ‘Continue Y/N?’
    
    3. Delete a teacher
    Διαγραφή ενός εκπαιδευτικού από τη ΔΔ κατακερματισμού με αλυσίδες συνωνύμων
    
    4. Search for a teacher
    Αναζήτηση και εμφάνιση των στοιχείων ενός εκπαιδευτικού βάσει ονοματεπωνύμου στη ΔΔ κατακερματισμού με αλυσίδες συνωνύμων
    
    5. Search by subject
    Αναζήτηση και εμφάνιση των στοιχείων των εκπαιδευτικών μιας συγκεκριμένης ειδικότητας (ο κωδικός της ειδικότητας [1..20] 
    αποτελεί παράμετρο της διαδικασίας) στη ΔΔ κατακερματισμού με αλυσίδες συνωνύμων 
    void Search_HashList_By_Subject(HashListType HList, int code);
    
    Μετά τις λειτουργίες 1, 2, 3 θα καλείτε την PrintPinakes(HList).
    Ο πίνακας κατακερματισμού θα έχει 9 θέσεις και ως συνάρτηση κατακερματισμού θα χρησιμοποιηθεί η εξής:
    h(i) = average % 9
    όπου
    average = (κωδικός_πρώτου_ χαρακτήρα + κωδικός_τελευταίου_χαρακτήρα) / 2
    Θεωρήστε ότι χρησιμοποιούνται οι ακόλουθοι κωδικοί για τους χαρακτήρες: ‘Α’ = 1, ‘Β’ = 2, …, ‘Ζ’ = 26. Ο πρώτος και ο
    τελευταίος χαρακτήρας του ονοματεπωνύμου θα μετατρέπεται στον αντίστοιχο κεφαλαίο χαρακτήρα, εφόσον είναι πεζός.
    Ο μέσος όρος average θα υπολογίζεται με μια συνάρτηση findAverage, η οποία θα καλείται από τη συνάρτηση HashKey.

    
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define HMax 9              /*     το μέγεθος του πίνακα HashTable
                                ενδεικτικά στην άσκηση ίσο με 9 */
#define VMax 30             /*το μέγεθος της λίστας,
                                ενδεικτικά ίσο με 30 */
#define EndOfList -1        /* σημαία που σηματοδοτεί το τέλος της λίστας
                                και της κάθε υπολίστας συνωνύμων */

// Δήλωση τύπων
typedef char KeyType[32]; // Τύπος για κλειδί κατακερματισμού

typedef struct{
    char phone[11];
    int type;
} ListElementType;  /*τύπος δεδομένων για τα στοιχεία της λίστας */

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
void PrintPinakes(HashListType HList);

int findAverage(char s[]);
void BuildHashList(HashListType *HList);
void Search_HashList_By_Subject(HashListType HList, int code);


int main()
{
	// Δήλωση μεταβλητών
    HashListType HList;
    ListElm AnItem;
    KeyType AKey;
    int Loc, Pred;
    char surname[20];
    char ch;
    int code;

	// Ερώτημα 1
    printf("1. Create HashList\n");
    BuildHashList(&HList); // Δημιουργία δομής κατακερματισμού από το αρχείο
    PrintPinakes(HList);

	// Ερώτημα 2
    printf("2. Insert new teacher\n");
    do // Επαναληπτικά
    {
        printf("Enter teacher's name: ");
        scanf("%s", AnItem.RecKey); getchar(); // Διάβασε όνομα εκπαιδευτικού
        printf("Enter teacher's surname: ");
        scanf("%s", surname); getchar(); // Διάβασε επώνυμο εκπαιδευτικού
        strcat(AnItem.RecKey, " ");
        strcat(AnItem.RecKey, surname); // Δημιουργία κλειδιού κατακερματισμού (ονοματεπώνυμο)
        printf("Enter teacher's phone: ");
        scanf("%s", AnItem.Data.phone); getchar(); // Διάβασε το τηλέφωνο του εκπαιδευτικού
        printf("Enter teacher code: ");
        scanf("%d", &AnItem.Data.type); // Διάβασε τον κωδικό ειδικότητας του εκπαιδευτικού
        AnItem.Link = EndOfList;
        AddRec(&HList, AnItem); // Εισήγαγε τον εκπαιδευτικό στη δομή

        printf("\nContinue Y/N: ");
        do{
            scanf("%c", &ch); // Διάβασε τον χαρακτήρα ch
        } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y');
    } while (toupper(ch)!='N');
    PrintPinakes(HList);

    // Ερώτημα 3
    printf("3. Delete a teacher\n");
    printf("Enter teacher's name: ");
    scanf("%s", AKey); getchar(); // Διάβασε όνομα εκπαιδευτικού
    printf("Enter teacher's surname: ");
    scanf("%s", surname); getchar(); // Διάβασε επώνυμο εκπαιδευτικού
    strcat(AKey, " ");
    strcat(AKey, surname); // Δημιουργία κλειδιού κατακερματισμού
    DeleteRec(&HList, AKey); // Διέγραψε τον εκπαιδευτικό από τη δομή
    PrintPinakes(HList);

    // Ερώτημα 4
    printf("4. Search for a teacher\n");
    printf("Enter teacher's name: ");
    scanf("%s", AnItem.RecKey); getchar(); // Διάβασε όνομα εκπαιδευτικού
    printf("Enter teacher's surname: ");
    scanf("%s", surname); getchar(); // Διάβασε επώνυμο εκπαιδευτικού
    strcat(AnItem.RecKey, " ");
    strcat(AnItem.RecKey, surname); // Δημιουργία κλειδιού κατακερματισμού
    SearchHashList(HList, AnItem.RecKey, &Loc, &Pred); // Αναζήτησε τον εκπαιδευτικό στη δομή
    if(Loc!=-1) // Αν βρεθεί ο εκπαιδευτικός
        printf("[%s, %s, %d]\n\n", HList.List[Loc].RecKey, HList.List[Loc].Data.phone, HList.List[Loc].Data.type); // Εμφάνισε τα στοιχεία του
    else // Διαφορετικά
        printf("DEN YPARXEI EGGRAFH ME KLEIDI %s\n\n", AnItem.RecKey); // Εμφάνισε μήνυμα

    // Ερώτημα 5
    printf("5. Search by subject\n");
    printf("Enter code: ");
    scanf("%d", &code); // Διάβασε κωδικό ειδικότητας
    Search_HashList_By_Subject(HList, code); // Αναζήτησε τους εκπαιδευτικούς της ειδικότητας

    return 0;
}

// Συναρτήσεις

int findAverage(KeyType s)
{
    // Δηλώνω τις μεταβλητές
    int first, last;

    first=toupper(s[0]); // Αποθήκευσε στην first τον πρώτο χαρακτήρα του s (αφού έχει μετατραπεί σε κεφαλαία)
    last=toupper(s[strlen(s)-1]); // Αποθήκευσε στην last τον κωδικό του τελευταίου χαρακτήρα του (αφού έχει μετατραπεί σε κεφαλαία)

    return ((first-64)+(last-64))/2; // Επέστρεψε (κωδικός_πρώτου_ χαρακτήρα + κωδικός_τελευταίου_χαρακτήρα) / 2
}


int HashKey(KeyType Key)
/* Δέχεται:    Την τιμή Key ενός κλειδιού.
   Λειτουργία: Βρίσκει την τιμή κατακερματισμού HValue για το κλειδί Key.
   Επιστρέφει: Την τιμή κατακερματισμού HValue
*/
{
    int avg;

	avg=findAverage(Key); // Υπολόγισε τον ακέραιο avg από το κλειδί κατακερματισμού

	/*σε περίπτωση που το KeyType δεν είναι ακέραιος
	θα πρέπει να μετατρέπεται κατάλληλα το κλειδί σε αριθμό*/
	return avg%HMax; // Επέστρεψε την τιμή κατακερματισμού
}

void BuildHashList(HashListType *HList)
{
    // Δηλώνω τις μεταβλητές
    ListElm AnItem;
    FILE *fp;
    char surname[20], termch;
    int nscan;

    CreateHashList(HList); // Δημιουργία δομή κατακερματισμού

    fp=fopen("i4f6.txt", "r"); // Άνοιξε το αρχείο "i4f6.txt" για ανάγνωση

    if(fp!=NULL){ // Αν το αρχείο άνοιξε επιτυχώς
        while(TRUE){
            // Διάβασε τα στοιχεία του εκπαιδευτικού
            nscan=fscanf(fp, "%10[^,],%20[^,],%10[^,],%d%c", AnItem.RecKey,surname,AnItem.Data.phone,&AnItem.Data.type,&termch);
            if(nscan==EOF) // Αν η ανάγνωση έφτασε στο τέλος του αρχείου
                break; // σπάσε ρε μόρτη
            if(nscan!=5 || termch != '\n') // Αν η ανάγνωση της εγγραφής δεν ήταν επιτυχής
                printf("Error\n"); // Κάτι δεν έκανες σωστά
            else{ // Αλλιώς
                strcat(AnItem.RecKey, " ");
                strcat(AnItem.RecKey, surname); // Δημιούργησε το κλειδί κατακερματισμού
                AddRec(HList, AnItem); // Εισήγαγε τον εκπαιδευτικό στη δομή
            }
        }
    }
    fclose(fp); // Κλείσε το αρχείο
}

void Search_HashList_By_Subject(HashListType HList, int code)
{
    // Δηλώνω τις μεταβλητές
    int i, SubIndex;

    printf("List of teachers with subject code %d: \n", code);
    for (i=0; i<HMax;i++) // Για κάθε θέση i του πίνακα κατακερματισμού
    {
        //Διατρέχουμε τη λίστα συνωνύμων για τη θέση i
        SubIndex = HList.HashTable[i]; // Ανάθεση στο SubIndex του πρώτου στοιχείου της λίστας συνωνύμων για τη θέση i
        while ( SubIndex != EndOfList ) // Όσο δεν έχουμε φτάσει στο τέλος της λίστας συνωνύμων
            {
            if(HList.List[SubIndex].Data.type==code) // Αν η ειδικότητα του εκπαιδευτικού για το τρέχον στοιχείο είναι ίσο με το code
            {
                //Εμφάνισε τα στοιχεία του εκπαιδευτικού
                printf("%d: [%s, %s, %d]\n", SubIndex, HList.List[SubIndex].RecKey,HList.List[SubIndex].Data.phone, code);
            }
            SubIndex = HList.List[SubIndex].Link; // Ανάθεση στο SubIndex του επόμενου στοιχείου της λίστας συνωνυμων
    }
}
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
		if (strcmp(HList.List[Next].RecKey, KeyArg) == 0) //Αλλαγές στην SearchSynonymList για τη διαχείριση συμβολοσειρών (χρήση strcmp)
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
		printf("DEN YPARXEI  EGGRAFH ME KLEIDI %s \n",DelKey); // Αλλαγή από %d σε %s επειδή είναι string
	}
}

void PrintPinakes(HashListType HList)
{
    int i;
    printf("Hash table\n");
    for(i=0;i<HMax;i++)
        printf("%d, ",HList.HashTable[i]);

    printf("\nHash List\n");
    for(i=0;i<HList.Size;i++)
       printf("%d) %s, %d\n",i,HList.List[i].RecKey,HList.List[i].Link);
    printf("\n");
}