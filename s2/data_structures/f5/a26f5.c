/*  Αρχείο: a26f5.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Δίνεται το αρχείο φοιτητών “foitites.dat”. Κάθε στοιχείο του αρχείου αυτού είναι μια εγγραφή με πεδία:
    Αριθμός μητρώου (ΑΜ: int), Επώνυμο (αλφαριθμητικό 20 χαρακτήρες), Ονομα (αλφαριθμητικό 20 χαρακτήρες), Φύλο
    (χαρακτήρας, τιμή F/M), Ετος (int), Βαθμός (μέσος όρος: float). Για την πιο αποτελεσματική επεξεργασία του αρχείου
    αυτού δημιουργείται ένα ευρετήριο (index) ως ΔΔΑ. Κάθε στοιχείο του ευρετηρίου αυτού αποτελείται από τον ΑΜ και τον
    αντίστοιχο αριθμό εγγραφής (γραμμής) στο αρχείο “foitites.dat”. Η αρίθμηση των γραμμών του αρχείου ξεκινούν από την
    τιμή 0.
    Γράψτε ένα πρόγραμμα που εκτελεί τις παρακάτω λειτουργίες και χρησιμοποιεί ως ευρετήριο ένα ΔΔΑ:
    1. Δημιουργία του index (ΔΔΑ) από το αρχείο “foitites.dat”.
    Θα διαβάζει 1-1 τις εγγραφές του αρχείου “foitites.dat”και θα καταχωρεί στο ΔΔΑ τον ΑΜ του φοιτητή και τον
    αντίστοιχο αύξοντα αριθμό εγγραφής (γραμμής) στο αρχείο. Θα επιστρέφει το πλήθος των κόμβων του ΔΔΑ.
    Συνάρτηση int BuildBST(BinTreePointer *Root);
    2. Θα εμφανίζει το πλήθος των κόμβων του ΔΔΑ όπως και τους κόμβους του ΔΔΑ με αύξουσα διάταξη ως προς ΑΜ.
    3. Εισαγωγή νέων εγγραφών φοιτητών στο αρχείο foitites.dat και ενημέρωση του ΔΔΑ. Κάθε αλφαριθμητικό πεδίο όπως
    και το πεδίο φύλο (τύπου χαρακτήρας) να διαβάζονται με scanf() και στη συνέχεια getchar(). Για το φύλο δε χρειάζεται
    η να γίνεται έλεγχος εγκυρότητας θεωρούμε ότι θα δοθεί F ή Μ. Η fopen θα κληθεί με 2 παράμετρο “a” καθώς οι νέες
    εγγραφές θα προστεθούν μετά την τελευταία εγγραφή του αρχείου. Μετά από κάθε προσθήκη εγγραφής στο αρχείο θα εμφανίζετε
    το μέγεθος του αρχείου. (δείτε στο στιγμιότυπο εκτέλεσης).
    Συνάρτηση void writeNewStudents(BinTreePointer *Root, int *size);
    4. Θα εμφανίζει το πλήθος των κόμβων του ΔΔΑ όπως και τους κόμβους του ΔΔΑ με αύξουσα διάταξη ως προς ΑΜ.
    5. Αναζήτηση φοιτητή. Θα δίνεται ο ΑΜ του φοιτητή και θα τον αναζητά στο ΔΔΑ. Στη συνέχεια εφόσον υπάρχει στο ΔΔΑ
    θα τον εντοπίζει στο αρχείο “foitites.dat” και θα εμφανίζει όλες τις πληροφορίες της αντίστοιχης εγγραφής. Αν δεν
    υπάρχει στο ΔΔΑ θα εμφανίζει σχετικό μήνυμα.
    6. Θα εμφανίζει το πλήθος των κόμβων του ΔΔΑ όπως και τους κόμβους του ΔΔΑ με αύξουσα διάταξη ως προς ΑΜ.
    7. Εκτύπωση των στοιχείων όλων των φοιτητών που είναι καταχωρημένοι στο αρχείο “foitites.dat” με ΜΟ μεγαλύτερο
    από ένα δοσμένο βαθμό (πχ 0).
    Συνάρτηση void printStudentsWithGrade(float theGrade);
    Το αρχείο “foitites.dat” θα «ανοίγει» και θα «κλείνει» σε κάθε συνάρτηση που χρησιμοποιείται και με την κατάλληλη
    παράμετρο (“a” για εγγραφή στο τέλος του αρχείου ή “r” για διάβασμα των εγγραφών του αρχείου).
    Για κάθε μια από τις παραπάνω λειτουργίες εμφανίζεται στη main() σχετικό μήνυμα (Qx...)
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

// Δήλωση τύπων
typedef struct
{
    int code;
    int recNo;
} BinTreeElementType;

typedef struct BinTreeNode *BinTreePointer;

typedef struct BinTreeNode {
    BinTreeElementType Data;
    BinTreePointer LChild, RChild;
} BinTreeNode;

typedef struct
{
    int code;
    char surname[20];
    char name[20];
    char sex;
    int year;
    float grade;
} StudentT;

typedef enum {
    FALSE, TRUE
} boolean;

// Δήλωση συναρτήσεων
void CreateBST(BinTreePointer *Root);
boolean BSTEmpty(BinTreePointer Root);
void RecBSTInsert(BinTreePointer *Root, BinTreeElementType Item);
void RecBSTInorder(BinTreePointer Root);
void RecBSTSearch(BinTreePointer Root, BinTreeElementType KeyValue, boolean *Found, BinTreePointer *LocPtr);

int BuildBST(BinTreePointer *Root);
void writeNewStudents(BinTreePointer *Root, int *size);
void printStudentsWithGrade(float theGrade);
void PrintStudent(int recNum);

int main()
{
   // Δηλώνω μεταβλητές
   BinTreePointer ARoot, LocPtr;
   float theGrade;
   int size; // πλήθος κόμβων του ΔΔΑ
   StudentT student;
   boolean Found;
   BinTreeElementType key;


   // Ερώτημα 1
   printf("Q1. Build BST from a file\n");
   size=BuildBST(&ARoot); // Δημιουργία ευρετηρίου και επιστροφή πλήθους κόμβων

   // Ερώτημα 2
   printf("Q2. Print size and BST\n");
   printf("Size=%d\n",size);
   printf("Nodes of BST\n");
   RecBSTInorder(ARoot); // Εμφάνιση των κόμβων δέντρου (σε αύξουσα διάταξη)

   // Ερώτημα 3
   printf("\nQ3. Write new students, update file and BST\n");
   writeNewStudents(&ARoot, &size); // Εισαγωγή νέων φοιτητών

   // Ερώτημα 4
   printf("Q4. Print size and BST\n");
   printf("Size=%d\n",size);
   printf("Nodes of BST\n");
   RecBSTInorder(ARoot); // Εμφάνιση των κόμβων δέντρου (σε αύξουσα διάταξη)

   // Ερώτημα 5
   printf("\nQ5. Search for a student\n");
   printf("Give student's code? "); // Διάβασε το ΑΜ
   scanf("%d",&key.code);
   RecBSTSearch(ARoot,key,&Found,&LocPtr); // Αναζήτησε τον φοιτητή
   if (Found)
   { // key.recNo = LocPtr->Data.recNo
     PrintStudent(LocPtr->Data.recNo);}
   else
   {printf("Student with code %d not found!\n",LocPtr->Data.code);}

   // Ερώτημα 6
   printf("Q6. Print size and BST\n");
   printf("Size=%d\n",size);
   printf("Nodes of BST\n");
   RecBSTInorder(ARoot);// Εμφάνιση των κόμβων δέντρου (σε αύξουσα διάταξη)

   // Ερώτημα 7
   printf("\nQ7. Print students with grades >= given grade\n");
    printf("Give the grade: ");
    scanf("%f", &theGrade);
    printStudentsWithGrade(theGrade);


   return 0;
}

// Συναρτήσεις

int BuildBST(BinTreePointer *Root)
{
  FILE *fp;
  int size; // Πλήθος εγγραφών φοιτητή
  int nscan;
  char termch;
  BinTreeElementType indexRec; // Εγγραφή φοιτητή για το ΔΔΑ
  StudentT student; // Εγγρφή για την ανάγνωση των στοιχείων φοιτητή από το αρχείο

  CreateBST(Root);

  fp = fopen("foitites.dat" ,"r"); // Ανοίγω αρχείο για ανάγνωση
  size=0; // Αρχικοποίηση του size

  if(fp == NULL) // Αν το αρχείο δεν άνοιξε, βγάλε μήνυμα σφάλματος
      {printf("Problem opening file\n");
      exit(1);}
  else // Αν το αρχείο άνοιξε επιτυχώς
    {
     while(TRUE)
     {
         nscan = fscanf(fp,"%d,%20[^,],%20[^,],%c,%d,%f%c",&student.code,student.name,student.surname,&student.sex,&student.year,&student.grade,&termch); // Διάβασε το από το αρχείο την εγγραφή φοιτητή
         if ( nscan == EOF ) // Αν έφτασε στο τέλος του αρχείου
            {printf("Tree built successfully!\n"); // Διαβάστηκε
            break;} // Σπάσε ρε μόρτη
         if ( nscan != 7||termch!='\n' ) // Αν η ανάγνωση της εγγραφής δεν ήταν επιτυχής
            {printf("Error\n");break;} // Εμφάνισε σφάλμα. Ουδείς άσφαλτος
         else // Αλλιώς
         {
             indexRec.code=student.code; // Καταχώρησε στο indexRec τον ΑΜ που διάβασες
             indexRec.recNo=size; // Καταχώρησε στον indexRec τον τρέχοντα αριθμό εγγραφής
             RecBSTInsert(&(*Root),indexRec); // Εισαγωγή της εγγραφής του φοιτητή στο ΔΔΑ
             size++; // Αύξησε κατα 1 το πλήθος των εγγραφών
         }
     }

    }
  fclose(fp); // Κλείσε το αρχείο
  return size; // Επέστρεψε το size
}

void PrintStudent(int recNum)
{
    FILE *fp;
    int nscan;
    int lines; // γραμμές του αρχείου που διαβάστηκαν
    char termch;
    StudentT student; // εγγραφή για την ανάγνωση των στοιχείων του φοιτητή από το αρχείο
    BinTreeElementType indexRec;

    lines=0; // Αρχικοποίηση του lines

    fp=fopen("foitites.dat","r"); // Άνοιξε το αρχείο

    if(fp == NULL) // Αν δεν άνοιξε το αρχείο
      printf("Problem opening file"); // Εμφάνισε σφάλμα
    else // Αν άνοιξε σωστά
      {
         while(lines<=recNum) // Όσο δεν έφτασε στη γραμμή του ζητούμενου φοιτητή
         {
          nscan = fscanf(fp, "%d,%20[^,],%20[^,],%c,%d,%f%c",&student.code,student.name, student.surname,&student.sex,&student.year,&student.grade,&termch); // Διάβασε από το αρχείο την εγγραφή του φοιτητή
          if ( nscan == EOF ) // Αν η ανάγνωση έφτασε στο τέλος του αρχείου
            {break;} // Σπάσε ρε μόρτη
          if ( nscan != 7||termch!='\n' ) // Αν η ανάγνωση της εγγραφή δεν ήταν επιτυχής
            { printf("Error\n");} // Εμφάνισε λάθος

          lines++; // Αύξησε το πλήθος των γραμμών

          }
          if(lines==recNum+1)
        printf("%d,%s,%s,%c,%d,%.1f\n",student.code,student.name, student.surname,student.sex,student.year,student.grade); // Εμφάνισε όλα τα στοιχεία του φοιτητή
        fclose(fp); // Κλείσε το αρχείο
    }

}


void printStudentsWithGrade(float theGrade)
{
    // Δήλωση μεταβλητών
    FILE *fp;
    int nscan;
    char termch;
    StudentT student;

    fp = fopen("foitites.dat" ,"r"); // Ανοίγω αρχείο για ανάγνωση

    if(fp == NULL) // Αν απέτυχε να ανοίξει το αρχείο
      printf("Problem opening file"); // Μήνυμα λάθους
    else // Αν άνοιξε με επιτυχία
      {
         while(TRUE)
         {
          nscan = fscanf(fp, "%d,%20[^,],%20[^,],%c,%d,%f%c",&student.code,student.name, student.surname,&student.sex,&student.year,&student.grade,&termch); // Διάβασε το αρχείο από την εγγραφή του φοιτητή
          if ( nscan == EOF ) // Αν έχει φτάσει στο τέλος του αρχείου
            {break;} // Σπάσε ρε μόρτη
          if ( nscan != 7||termch!='\n' ) // Αν η ανάγνωση της εγγραφής δεν ήταν επιτυχής
            { printf("Error\n");} // Κάπου έγινε λάθος. Ξαναψάξε
          else // Αλλιώς
           {
             if (student.grade>=theGrade) // Αν ο βαθμός του φοιτητή είναι >= theGrade
             {
                 printf("%d,%s,%s,%c,%d,%.1f\n",student.code,student.name, student.surname,student.sex,student.year,student.grade); // Εμφάνισε τα στοιχεία του φοιτητή
             }
           }
          }

        fclose(fp); // Κλείνω το αρχείο
    }


}

void writeNewStudents(BinTreePointer *Root, int *size)

{
   BinTreePointer LocPtr;
   StudentT student; // εγγραφή για ανάγνωση των στοιχείων φοιτητή από το αρχείο
   boolean Found;
   int code;
   char ch;
   FILE *fp;
   BinTreeElementType indexRec; // Εγγραφή φοιτητή για το ΔΔΑ


    fp=fopen("foitites.dat","a");
    if(fp == NULL) // Αν απέτυχε να ανοίξει το αρχείο
      printf("Problem opening file"); // Μήνυμα λάθους
    else // Αν άνοιξε με επιτυχία
      {
          do // Επαναληπτικά
            {
                 printf("Give student's AM? "); // Διάβασε το ΑΜ
                 scanf("%d",&indexRec.code);
                 RecBSTSearch(*Root,indexRec,&Found,&LocPtr); // Αναζήτησε τον φοιτητή με το παραπάνω ΑΜ
                 if(!Found) // Αν δε βρέθηκε
                 {
                 student.code=indexRec.code; // Καταχώρησε το ΑΜ στην εγγραφή για το αρχείο
                 printf("Give student surname? "); // Διάβασε επώνυμο
                 scanf("%s",student.surname); getchar(); // Προσοχή, όχι &
                 printf("Give student name? "); // Διάβασε όνομα
                 scanf("%s",student.name); getchar() ;
                 printf("Give student sex F/M? "); // Διάβασε φύλο
                 scanf("%c",&student.sex); getchar();
                 printf("Give student's registration year? "); // Διάβασε έτος
                 scanf("%d",&student.year);
                 printf("Give student's grade? "); // Διάβασε βαθμό
                 scanf("%f",&student.grade);

                 indexRec.code = student.code;
                 indexRec.recNo = *size;
                 RecBSTInsert(Root,indexRec); // Εισαγωγή του φοιτητή στο ΔΔΑ
                 fprintf(fp,"%d,%s,%s,%c,%d,%.1f\n",student.code,student.name, student.surname,student.sex,student.year,student.grade); // Εγγραφή στο αρχείο
                 (*size)++; // Αύξηση πλήθους φοιτητών κατά 1
                 printf("Size=%d\n",*size);
                 }
                 else
                  {printf("Student with code AM %d already exists!\n",indexRec.code);}


            printf("\nContinue Y/N: ");
            do // Επαναληπτικά
            {

            scanf("%c", &ch); // Διάβασε τον χαρακτήρα ch
            } while (toupper(ch)!= 'N' && toupper(ch)!= 'Y'); // όσο ο χαρακτήρας δεν είναι N ή Υ

       } while (toupper(ch)!='N'); // όσο ο χαρακτήρας δεν είναι Ν
       }

    fclose(fp); // Κλείνω το αρχείο
}

void RecBSTInorder(BinTreePointer Root)
/* Δέχεται:    Ένα δυαδικό δέντρο με το δείκτη Root να δείχνει στην ρίζα του.
   Λειτουργία: Εκτελεί ενδοδιατεταγμένη διάσχιση του δυαδικού δέντρου και
                επεξεργάζεται κάθε κόμβο ακριβώς μια φορά.
   Εμφανίζει: Το περιεχόμενο του κόμβου, και εξαρτάται από το είδος της επεξεργασίας
*/
{
    if (Root!=NULL) {
    //    printf("L");
        RecBSTInorder(Root->LChild);
        printf("(%d, %d), ",Root->Data.code,Root->Data.recNo); // 'Αλλαξε από printf("%d ",Root->Data);
    //    printf("R");
        RecBSTInorder(Root->RChild);
    }
   // printf("U");
}

void CreateBST(BinTreePointer *Root)
/* Λειτουργία: Δημιουργεί ένα κενό ΔΔΑ.
   Επιστρέφει:  Τον μηδενικό δείκτη(NULL) Root
*/
{
    *Root = NULL;
}

boolean BSTEmpty(BinTreePointer Root)
/* Δέχεται:   Ενα ΔΔα με το Root να δείχνει στη ρίζα του.
  Λειτουργία: Ελέγχει αν το ΔΔΑ είναι κενό.
  Επιστρέφει: TRUE αν το ΔΔΑ είναι κενό και FALSE διαφορετικά
*/
{
    return (Root==NULL);
}


void RecBSTSearch(BinTreePointer Root, BinTreeElementType KeyValue,
                    boolean *Found, BinTreePointer *LocPtr)
/* Δέχεται:    Ένα ΔΔΑ με το δείκτη Root να δείχνει στη ρίζα του και μια τιμή KeyValue.
   Λειτουργία: Αναζητά στο ΔΔΑ έναν κόμβο με τιμή KeyValue στο πεδίο κλειδί του.
   Επιστρέφει: Η Found έχει τιμή TRUE και ο δείκτης LocPtr δείχνει στον κόμβο που
                περιέχει την τιμή KeyValue, αν η αναζήτηση είναι επιτυχής.
                Διαφορετικά η Found έχει τιμή FALSE
*/
{
    if (BSTEmpty(Root))
        *Found=FALSE;
    else
        if (KeyValue.code < Root->Data.code)
            RecBSTSearch(Root->LChild, KeyValue, &(*Found), &(*LocPtr));
        else
            if (KeyValue.code > Root->Data.code)
                RecBSTSearch(Root->RChild, KeyValue, &(*Found), &(*LocPtr));
            else
                {
                    *Found = TRUE;
                    *LocPtr=Root;
                }
}

void RecBSTInsert(BinTreePointer *Root, BinTreeElementType Item)
/* Δέχεται:     Ένα ΔΔΑ με το δείκτη Root να δείχνει στη ρίζα του και ένα στοιχείο Item.
   Λειτουργία:  Εισάγει το στοιχείο Item στο ΔΔΑ.
   Επιστρέφει: Το τροποποιημένο ΔΔΑ με τον δείκτη Root να δείχνει στη ρίζα του
*/
{
    if (BSTEmpty(*Root)) {
        (*Root) = (BinTreePointer)malloc(sizeof (struct BinTreeNode));
        (*Root) ->Data = Item;
        (*Root) ->LChild = NULL;
        (*Root) ->RChild = NULL;
    }
    else
        if (Item.code < (*Root) ->Data.code)
            RecBSTInsert(&(*Root) ->LChild,Item);
        else if (Item.code > (*Root) ->Data.code)
            RecBSTInsert(&(*Root) ->RChild,Item);
        else
            printf("TO STOIXEIO EINAI HDH STO DDA\n");
}

