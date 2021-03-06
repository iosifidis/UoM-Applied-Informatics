/*  Αρχείο: a6f6.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0
    
    Να γραφεί ένα πρόγραμμα το οποίο εμφανίζει μέσους όρους σωματομετρικών στοιχείων μιας ομάδας Ν ατόμων 
    (το Ν είναι “σταθερά” και καθορίζεται με αντίστοιχη εντολή define). Για την υποβολή της άσκησης μπορείτε 
    να θέσετε το Ν ίσο με 5. Το πρόγραμμα θα εκτελεί τις παρακάτω λειτουργίες με τη χρήση συναρτήσεων: 
    a. Θα διαβάζει Ν τετράδες ακέραιων αριθμών (σωματομετρικά στοιχεία) και θα τους καταχωρεί σε διδιάστατο 
    πίνακα (συνάρτηση readData). Κάθε τετράδα αναφέρεται στα στοιχεία ενός ατόμου, που είναι κατά σειρά τα εξής:
     το φύλο (0 αν είναι άνδρας, 1 αν είναι γυναίκα)
     το βάρος (σε κιλά, ακέραια τιμή)
     το ύψος (σε εκατοστά, ακέραια τιμή) 
     η ηλικία (σε χρόνια, ακέραια τιμή)
    b. Θα εμφανίζει το μέσο όρο του βάρους, του ύψους και της ηλικίας τόσο για τους άνδρες όσο και για τις
    γυναίκες. Ο υπολογισμός (και όχι η εμφάνιση) του μέσου όρου για κάθε ένα στοιχείο (ύψος, βάρος ηλικία) 
    θα γίνεται με τη βοήθεια μιας (και μόνο) συνάρτησης void FindMean. Εκτός των άλλων παραμέτρων που θα 
    ορίσετε στη συνάρτηση, αυτή θα έχει ως παράμετρο και έναν αριθμοδείκτη (τιμές 1, 2, 3). Ο αριθμοδείκτης 
    θα δείχνει το αντίστοιχο στοιχείο της τετράδας, του οποίου ο μέσος όρος υπολογίζεται στη συγκεκριμένη κλήση, 
    δηλαδή τη κατάλληλη στήλη του διδιάστατου πίνακα. Για παράδειγμα, όταν ο αριθμοδείκτης είναι 1, τότε θα
    υπολογίζεται ο μέσος όρος του βάρους. Η συνάρτηση FindMean σε κάθε κλήση της θα «επιστρέφει» συγχρόνως 
    τον αντίστοιχο μέσο όρο για τους άνδρες και τον αντίστοιχο μέσο όρο για τις γυναίκες, θα «επιστρέφει» 
    δηλαδή 2 τιμές. (δείτε παρατήρηση 5 για τον όρο «επιστρέφει»). Στη συνάρτηση main() θα καλούνται κατάλληλα 
    οι παραπάνω συναρτήσεις/διαδικασίες προκειμένου να διαβαστούν τα δεδομένα και στη συνέχεια να εμφανιστούν 
    οι μέσοι όροι του βάρους, του ύψους και της ηλικίας των ανδρών και των γυναικών. 
    Οι μέσοι όροι θα εμφανίζονται με ακρίβεια ενός δεκαδικού ψηφίου.

*/

#include <stdio.h>
#include "simpio.h"

#define N 5

/* Πρωτότυπα συναρτήσεων */
void readData(float tab[][4]);
void FindMean(int deiktis, float mo[], float table[N][4]);

int main()
{

/* Δήλωση και αρχικοποίηση μεταβλητών και πινάκων */
    float mow[2]={0,0}, moh[2]={0,0}, moa[2]={0,0};
    float somatometriseis[N][4];

/* Κλήση συνάρτησης readData για συμπλήρωση πίνακα */
    readData(somatometriseis);

/* Κλήση συνάρτησης FindMean για εύρεση μέσων όρων και εκτύπωση αποτελεσμάτων */
    FindMean(1, mow, somatometriseis);
    printf("Mesos oros barous andrwn: %.1f\n",mow[0]);
    printf("Mesos oros barous gynaikwn: %.1f\n",mow[1]);
    printf("\n");
    FindMean(2, moh, somatometriseis);
    printf("Mesos oros ypsous andrwn: %.1f\n",moh[0]);
    printf("Mesos oros ypsous gynaikwn: %.1f\n",moh[1]);
    printf("\n");
    FindMean(3, moa, somatometriseis);
    printf("Mesos oros hlikias andrwn: %.1f\n",moa[0]);
    printf("Mesos oros hlikias gynaikwn: %.1f\n",moa[1]);
    return 0;
}

/* Συναρτήσεις */

void readData(float tab[][4])
{
    int i;
    for (i=0;i<N;i++){
        printf("Dwse fylo: ");
        scanf("%f",&tab[i][0]);
        printf("Dwse baros: ");
        scanf("%f",&tab[i][1]);
        printf("Dwse ypsos: ");
        scanf("%f",&tab[i][2]);
        printf("Dwse ilikia: ");
        scanf("%f",&tab[i][3]);
        printf("-----\n");
        }
}

void FindMean(int deiktis, float mo[], float table[N][4])
{
    int i, men=0, women=0;
    for(int i=0;i<N;i++){

        if(table[i][0] == 0){
            mo[0] += table[i][deiktis]; // Μετρητής, ανάλογα με τον δείκτη, και αποθήκευση στη θέση για άντρα
            men+=1; // Μετρητής αντρών
        }
        else {
            mo[1] += table[i][deiktis]; // Μετρητής, ανάλογα με τον δείκτη, και αποθήκευση στη θέση για γυναίκα
            women+=1; // Μετρητής γυναικών
        }
    }

/* Υπολογισμός μέσων όρων και αποθήκευση στον πίνακα για άντρα και γυναίκα αντίστοιχα. */
    if (men!=0) {mo[0] /=men;}
    else {mo[0] =0;} // Σε περίπτωση που δεν μετρηθεί άνδρας ή γυναίκα, αποθηκεύεται 0

    if (women!=0) {mo[1] /=women;}
    else {mo[1] =0;} // Σε περίπτωση που δεν μετρηθεί άνδρας ή γυναίκα, αποθηκεύεται 0
}
