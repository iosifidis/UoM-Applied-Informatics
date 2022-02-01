// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0
// Use UTF-8 encoding to view the comments

public class Communication {
	
	// Δήλωση ιδιοτήτων
	protected String num1;
	protected String num2;
	protected int day;
	protected int month;
	protected int year;
	
	//Κατασκευαστής
	public Communication(String num1, String num2, int day, int month, int year){
		this.num1 = num1;
		this.num2 = num2;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	//Μέθοδος εκτύπωσης
	public void printInfo() {
		System.out.println("Between " + num1 + " --- " + num2);
		System.out.println("on " + year +"/" + month +"/" + day);
	}
	
}