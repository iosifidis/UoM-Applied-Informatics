/*  Αρχείο: a7f8.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Μία εταιρία ενοικίασης αυτοκινήτων διατηρεί για την κάθε ενοικίαση τα εξής στοιχεία:
    - Αριθμός ενοικίασης
    - Μάρκα
    - Κυβικά
    - Όνομα ενοικιαστή
    - Ημέρες ενοικίασης
    - Τιμή ανά ημέρα
    Να γραφεί πρόγραμμα που θα εκτελεί τις παρακάτω λειτουργίες:
    1. Εισαγωγή του πλήθος των ενοικιάσεων
    2. Εισαγωγή των στοιχείων κάθε ενοικίασης
    3. Υπολογισμός αναλυτικής κατάστασης πληρωμής.
    4. Υπολογισμός της ενοικίασης με το μεγαλύτερο κέρδος
    5. Εμφάνιση αναλυτικής κατάστασης
    6. Εμφάνιση των στοιχείων (Μάρκα, Κυβικά, Συνολικό Ποσό) για την ενοικίαση με το
    μεγαλύτερο κέρδος.
    Τα παραπάνω δεδομένα θα εισάγονται σε πίνακα δομών (μέγιστη διάσταση πίνακα Ν=20). Στην i θέση του
    πίνακα θα καταχωρούνται τα στοιχεία του i αυτοκινήτου. Ο αριθμός ενοικίασης θα δίνεται αυτόματα από το
    πρόγραμμα και όχι από τον χρήστη (για την i ενοικίαση θα δίνεται ως αριθμός ενοικίασης το i).

*/

#include <stdio.h>
#include <string.h>
#include "genlib.h"
#include "simpio.h"


#define RENTS 20

/* Δημιουργία δομών */
typedef struct
{
    int number;
    char type[20];
    int  cc;
    char name[20];
    int days;
    float daily_rate;
    float total_charge;
} car_rentalT;

typedef struct{
	char type[20];
	int cc;
	float amount;
} best_carT;

/* Πρωτότυπα συναρτήσεων */
int get_data(car_rentalT rentals[]);
float calc_totals(int num_rentals, car_rentalT rentals[]);
best_carT find_best (int num_rentals, car_rentalT rentals[]);
void print_data (int num_rentals, car_rentalT rentals[], float total, best_carT best);


int main()
{
    car_rentalT rentals[RENTS];
    best_carT car1;
    int num_rentals;
    float total;

    num_rentals = get_data(rentals);
    total = calc_totals(num_rentals, rentals);
    car1= find_best(num_rentals, rentals);

    print_data(num_rentals, rentals, total, car1);
    return 0;
}

/* Συναρτήσεις */

/* Λήψη δεδομένων και αποθήκευση σε πίνακα της δομής car_rentalT */
int get_data(car_rentalT rentals[])
{
    int i, num_rentals;
    printf("Dose ton arithmo enoikiaseon: ");
    num_rentals = GetInteger();
    printf("\n");
    for(i=0;i<num_rentals;i++)
    {
        printf("Dose ta stoixeia tis enoikiasis %d  \n", i);
        rentals[i].number = i;

        printf("Dose marka: ");
        gets(rentals[i].type);

        printf("Dose kyvika: ");
        rentals[i].cc=GetInteger();

        printf("Dose onoma pelati: ");
        gets(rentals[i].name);

        printf("Dose imeres enoikiasis: ");
        rentals[i].days=GetInteger();

        printf("Dose timi ana imera: ");
        rentals[i].daily_rate=GetReal();
        printf("\n");

 }
 return num_rentals;
}


/* Υπολογισμός συνολικού ποσού ενοικιάσεων */
float calc_totals(int num_rentals, car_rentalT rentals[])
{
    int i;
    float total=0;

    for(i=0;i<num_rentals;i++)
        {rentals[i].total_charge=rentals[i].days*rentals[i].daily_rate;
        total+=rentals[i].total_charge;
        }
    return total;
}

/* Εύρεση ενοικίασης με το μεγαλύτερο κέρδος */
best_carT find_best (int num_rentals, car_rentalT rentals[])
{
    int i;
    best_carT best;

    strcpy(best.type, rentals[0].type);
    best.cc = rentals[0].cc;
    best.amount = rentals[0].total_charge;

    for (i=1;i<num_rentals;i++)
    {
        if (best.amount < rentals[i].total_charge){
            strcpy(best.type, rentals[i].type);
            best.amount = rentals[i].total_charge;
            best.cc = rentals [i].cc;}
        }
return best;
}

/* Εκτύπωση αποτελεσμάτων */
void print_data (int num_rentals, car_rentalT rentals[], float total, best_carT best)
{
    int i;

    printf("\n\n");
    printf("%-7s %-20s %-10s %-5s %-5s %-6s %-8s\n", "Number", "Name", "Type", "CC", "Days", "Price", "Total");
    for (i=0; i<73;i++) printf("-");
    printf("\n");

    for(i=0; i< num_rentals; i++)
    {
        printf("%-7d %-20s %-10s %-5d %-5d %-6.2f %-8.2f\n",
        rentals[i].number,
        rentals[i].name,
        rentals[i].type,
        rentals[i].cc,
        rentals[i].days,
        rentals[i].daily_rate,
        rentals[i].total_charge);
    }

    for(i=0; i<73; i++) printf("-");
	printf("\n");
    printf("%58s %-8.2f\n", "Total", total);
    printf("Best car: %s %d rented for %.2f Euros.\n",best.type, best.cc, best.amount);

}
