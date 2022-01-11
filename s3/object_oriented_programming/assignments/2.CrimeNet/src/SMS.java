// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0
// Use UTF-8 encoding to view the comments

public class SMS extends Communication{
	
	// Δήλωση ιδιότητας
	private String message;
	
	//Κατασκευαστής
	public SMS(String num1, String num2, int day, int month, int year, String message){
		super(num1, num2, day, month, year); //Υποκλάση της Communication
		this.message = message;	
	}
		
	//Μέθοδος εκτύπωσης
	public void printInfo() {
		System.out.println("This SMS has the following info");
		super.printInfo(); //Λαμβάνει την printInfo της υπερκλάσης Communication
		System.out.println("Text: " +message);
	}
		
	//Μέθοδος getSMS για λήψη μηνύματος SMS
	public String getSMS() {
		return message;
	}

}
