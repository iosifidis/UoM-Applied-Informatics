/*  Αρχείο: a22f5.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

*/

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

#define digits 16

long long GetLongLong(void);
void card_digit(long long card, long long CARD[digits]);
int count(long long card);

int main()
{
    long long card;
    long long CARD[digits];
    int i, sum=0, validation=0;

    /* Εισαγωγή κάρτας */
    printf("Insert card number: ");
    card=GetLongLong();
    // Έλεγχος εάν δεν εισαχθούν 16 ψηφία
    if (count(card)!=16)
        {validation=0;}

    /* Καταχώρηση της κάρτας στον πίνακα CARD */
    else{
        card_digit(card,CARD);
        if (CARD[0]<4 || CARD[0]>7) // Έλεγχος εάν το 1ο ψηφείο είναι μικρότερο από 4 και μεγ από 7
            {validation=0;}
        else
        {
            for (i=0;i<digits;i+=2)
                {
                CARD[i]*=2;
                CARD[i]=(count(CARD[i])==1? CARD[i]: (CARD[i]/10+CARD[i]%10));
                }
             sum=0;
             for (i=0;i<digits;i++)
             {
                sum+=CARD[i];
             }
            if (sum%10==0) {validation=1;}
            else  {validation=0;}
        }
    }
    /* Εκτύπωση αποτελέσματος */
    printf("%lld is %s\n", card, (validation==1) ? "VALID" : "invalid");

   return 0;

}

/* Συνάρτηση καταχώρησης κάθε ψηφίου σε διαφορετική θέση του πίνακα */
void card_digit(long long card, long long CARD[digits])
{
    int i = 1; // Μετρητής
    while (card!=0)
    {
        CARD[digits-i]=card%10; // Καταχώρησε στην τελευταία-i θέση το τελευταίο ψηφίο της κάρτας
        card=card/10; // Κόψε το τελευταίο ψηφίο της κάρτας
        i++; // Αύξησε το μετρητή κατά 1
    }
}

/* Συνάρτηση μέτρησης των ψηφίων της κάρτας */
int count(long long card)
{
    int count = 0; // Μετρητής
    while (card != 0)
    {
        card /= 10; // Αφαίρεσε το τελευταίο ψηφίο της κάρτας
        count++; // Μέτρα την επανάληψη. Πόσα ψηφία είναι
    }
    return count;
}

long long GetLongLong(void)
{
	string line;
	long long value;
	char termch;
	while (TRUE) {
		line = GetLine();
		switch (sscanf(line, " %lld %c", &value, &termch)) {
			case 1:
				FreeBlock(line);
				return (value);
			case 2:
				printf("Unexpected character: '%c'\n", termch);
				break;
			default:
				printf("Please enter an integer\n");
				break;
		}
		FreeBlock(line);
		printf("Retry: ");
	}
}
