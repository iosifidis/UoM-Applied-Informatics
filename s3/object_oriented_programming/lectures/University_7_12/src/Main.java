
public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student("John", "ics20133");
		// Φτιάχνω ένα νέο αντικείμενο με τα ίδια στοιχεία
		Student s2 = new Student("John", "ics20133");
		
		// Όταν στέλνω ένα αντικείμενο μέσα σε print επιστρέφει το όνομα αντικειμένου και την διεύθυνσή του.
		System.out.println(s1);
		System.out.println(s2);
		
		// Σύγκριση των αντικειμένων με ==
//		// Εκτυπώνει την else (the two object are different) γιατί συγκρίνει αντικείμενα. 
//		// Οι διευθύνσεις είναι διαφορετικές. Είναι αυτές που συγκρίνονται με ==. 
//		// Συγκρίνω τα αντικείμενα ΜΟΝΟ με μέθοδο equals
//		if(s1==s2)
//			System.out.println("The two objects refer to the same student");
//		else
//			System.out.println("The two objects are different");
		
		// Σύγκριση των αντικειμένων με equals
		if(s1.equals(s2))
			System.out.println("The two objects refer to the same student");
		else
			System.out.println("The two objects are different");
		
		
		
	}

}
