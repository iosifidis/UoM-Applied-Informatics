/*  Αρχείο: a11bf5.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Άδεια χρήσης: GNU General Public License v3.0

*/

#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

#define CTS 10
#define S 3

void ReadData(int row, int col, double temper[row][col]);
double CalculateAverage(int row, int col, double temper[row][col]);
void CalculateAvCity(int row, int col, double temper[row][col], double average[row]);
void CalculateMaxDeviation(int row, int col, double natavg,double temper[row][col], double mdeviation[row]);
void Print_results(double natavg, int row, double average[row], double mdeviation[row]);

int main()
{
    double temper[CTS][S], average[CTS], mdeviation[CTS];
    double natavg;

	/*Read all Temperatures*/
	ReadData(CTS, S, temper);

	/*Calculating The Average of all Cities&Temps*/
    	natavg = CalculateAverage(CTS, S, temper);

	/*Calculating Average temp on each City*/
	CalculateAvCity(CTS, S, temper, average);

	/*Calculating max Deviation*/
	CalculateMaxDeviation(CTS, S, natavg, temper, mdeviation);


    /*Printing results*/
    Print_results(natavg, CTS, average, mdeviation);


    return 0;
}

void ReadData(int row, int col, double temper[row][col])
{	int i, j;
	for (i=0; i<row; i++)
		for (j=0; j<col; j++){
			printf("Temp of City %d During %d 8-hour period: ",i,j);
              		temper[i][j] = GetReal();
              }
}

double CalculateAverage(int row, int col, double temper[row][col])
{
    int i, j;
    double natavg;

    natavg = 0;
    for (i=0; i<row; i++)
      for (j=0; j<col; j+=1)
         natavg += temper[i][j];
    return natavg/(row*col);


}

void CalculateAvCity(int row, int col, double temper[row][col], double average[row])
{
    int i, j;

   for (i=0; i<row; i++)
    {
        average[i] = 0;
        for (j=0; j<col; j++)
        {
            average[i] += temper[i][j];
        }
        average[i] = average[i]/col;
    }
}

void CalculateMaxDeviation(int row, int col, double natavg, double temper[row][col], double mdeviation[row])
{
    int i, j;
    double devnat[row][col];

    for (i=0; i<row; i++)
        for (j=0; j<col; j++)
            devnat[i][j] = fabs(natavg-temper[i][j]);
    for (i=0; i<row; i++)
    {
        mdeviation[i] = devnat[i][0];
        for(j=1; j<col; j++){
            if (mdeviation[i]<devnat[i][j])
            	{mdeviation[i] = devnat[i][j];}
        }
    }
}

void Print_results(double natavg, int row, double average[row], double mdeviation[row])
{
    int i;
    printf("%3.1f\n", natavg);
    for (i=0; i<row; i+=1)
		printf("City %d  %.1f  %.1f\n",i, average[i], mdeviation[i]);

}
