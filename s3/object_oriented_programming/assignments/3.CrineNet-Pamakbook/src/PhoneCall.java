// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0
// Use UTF-8 encoding to view the comments

public class PhoneCall extends Communication{
	
	// Δήλωση ιδιότητας
	private int seconds;
	
	// Κατασκευαστής
	public PhoneCall(String num1, String num2, int day, int month, int year, int seconds){
		super(num1, num2, day, month, year); //Υποκλάση της Communication
		this.seconds = seconds;
	}
	
	//Μέθοδος εκτύπωσης
	public void printInfo() {
		System.out.println("This phone call has the following info");
		super.printInfo(); //Λαμβάνει την printInfo της υπερκλάσης Communication
		System.out.println("Duration: " +seconds);
	}
	
	//Μέθοδος getCallDuration για λήψη δευτερολέπτων κλήσης
	public int getCallDuration() {
		return seconds;
	}
}