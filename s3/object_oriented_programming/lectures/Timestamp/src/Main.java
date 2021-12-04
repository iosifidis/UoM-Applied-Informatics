
public class Main {

	public static void main(String[] args) {
		TimeStamp t1 = new TimeStamp(23, 45, 17);
		
		t1.printTime();
		
//		t1.hour++;
//		t1.hour++;
		

		t1.incrementHour();
		t1.incrementHour();
		
		// Έχοντας public ιδιότητες στην κλάση. Παραβιάζει συνθήκη ώρας 0<= hour < 24. Λεπτά και δευτερόλεπτα μεταξύ του 0 και 60
		t1.printTime();

	}

}
