// Θέλω στον Student να προσθέσω μια ιδιότητα year. Αν την γράψω στην Student θα κληρονομήσουν και οι GraduateStudent και PhDStudent
//που δεν το θέλω. Οπότε φτιάχνω μια νέα υποκλάση UnderGradStudent

public class UnderGradStudent extends Student {
	
	private int year;

	public UnderGradStudent(String name, String id, int year) {
		super(name, id);
		this.year = year;
	}
	
	// Επικάλυψη / επαναορισμός μεθόδου
	public void printInfo(){
		super.printInfo();
		System.out.println("year: " + year);
	}
	
	//Αρχή υποκατάστασης: Τα αντικείμενα μιας υποκλάσης είναι και αντικείμενο της υπερκλάσης
	public void printType(){
		System.out.println("Hello I am an undergraduate student");
	}

}
