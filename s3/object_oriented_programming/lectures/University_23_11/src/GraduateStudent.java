
public class GraduateStudent extends Student {
	
	private String supervisor;

	public GraduateStudent(String name, String id, String supervisor) {
		super(name, id);
		this.supervisor = supervisor;
	}

	// Επικάλυψη / επαναορισμός μεθόδου
	public void printInfo(){
		super.printInfo();
		System.out.println("Supervisor: " + supervisor);
		
	//Αρχή υποκατάστασης: Τα αντικείμενα μιας υποκλάσης είναι και αντικείμενο της υπερκλάσης
	}

	public void printType(){
		System.out.println("Hello I am a graduate student");
	}
	
}
