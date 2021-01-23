/*  Αρχείο: BestTime2Party.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

    Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved. Contributors provide an express grant of patent rights.


    */

#include <stdio.h>
#include <string.h>

// Καθορισμός σταθερών
#define SIZE 3
#define LENGTH 25
#define SLOT 6

// Προτώτυπα συναρτήσεων
int maxim(int SLOTS[SLOT]);
void signature();

int main()
{

// Δήλωση και αρχικοποίηση μεταβλητών και πινάκων
    char GROUPS[SIZE][LENGTH];
    char temp; // για τον καθαρισμό του buffer
    int wraf[SIZE];
    int wran[SIZE];
    int SLOTS[SLOT]={0,0,0,0,0,0}; // Πίνακας μετρητών ωρών
    int time_slots[SLOT]={18,19,20,21,22,23}; // Βοηθητικός πίνακας ωρών (χρήση στην εκτύπωση)
    int max, i, j;

// Ανατρέχουμε τους πίνακες με τις ώρες άφιξης-αναχώρησης για να σχημαριστεί ο πίνακας με τους μετρητές
    for (i=0 ; i<SIZE; i++){
       	printf("Dose sugrotima: ");
    	scanf("%[^\n]s",&GROUPS[i]); // Το [^\n] επιτρέπει στο string να λάβει κείμενο με κενά.

        printf("Dose ora afiksis: ");
        scanf("%d",&wraf[i]);

        printf("Dose ora anaxorisis: ");
        scanf("%d",&wran[i]);

        scanf("%c",&temp); // temp για καθαρισμό του buffer

        if (wraf[i]<19) {SLOTS[0]+=1;}
    	if (wraf[i]<=19 && wran[i]>=20) {SLOTS[1]+=1;}
    	if (wraf[i]<=20 && wran[i]>=21) {SLOTS[2]+=1;}
    	if (wraf[i]<=21 && wran[i]>=22) {SLOTS[3]+=1;}
    	if (wraf[i]<=22 && wran[i]>=23) {SLOTS[4]+=1;}
    	if (wraf[i]>=23 || wran[i]==24) {SLOTS[5]+=1;}
    }

// Χρήση της συνάρτησης για εύρεση του μέγιστου (ώρας με τα περισσότερα συγκροτήματα)
   max=maxim(SLOTS);

// Εκτύπωση αποτελέσματος
 for (i=0;i<SLOT;i++){
    if (SLOTS[i]==max)
    	// Εκτύπωση καλύτερης ώρας
        {printf("Stis %d kai gia 1 wra emfanizontai %d sygkrotimata: \n",time_slots[i],SLOTS[i]);
        printf("---------------------------------------------------\n");
        // Εκτύπωση συγκροτημάτων
        for (j=0;j<SIZE;j++)
            {if (wraf[j]<=time_slots[i] && wran[j]>time_slots[i])
                printf("%s\n",GROUPS[j]);}
    }
    }
    signature(); // Υπογραφή

    return 0;

}


// Συναρτήσεις

// Εύρεση του μέγιστου
int maxim(int SLOTS[SLOT])
{
    int max,i;
    max=SLOTS[0];
    for (i=1;i<SLOT;i++)
        {if (SLOTS[i]>max)
            {max=SLOTS[i];}}
    return max;
}

// Προσωπική υπογραφή
void signature()
{   printf("\n-------------------------------------------\n");
    printf("| Developer: Efstathios Iosifidis         |\n");
 //   printf("-------------------------------------------\n");
    printf("| Github: http://www.github.com/iosifidis |\n");
 //   printf("------------------------------------------\n");
    printf("| Webpage: http://iosifidis.gr            |\n");
    printf("-------------------------------------------\n");
    printf("| LICENSE: GNU General Public License v3.0|\n");
    printf("-------------------------------------------\n");
    }
