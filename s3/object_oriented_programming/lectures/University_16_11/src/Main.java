
public class Main {

	public static void main(String[] args) {
//		Student s1 = new Student("Nick", 8.4);
//		s1.printInfo();
//		
//		GraduateStudent gs1 = new GraduateStudent("Robert", 8.7, "Jones");
//		gs1.printInfo();

		// Αρχή υποκατάστασης ένας πτυχιακός φοιτητής δείχνει σε αντικείμενο μεταπτυχιακού φοιτητή
		Student s1 = new GraduateStudent("Bob", 6.7, "Robers");
		// Πολυμπορφισμός. Θα δείχνει στην printInfo της υποκλάσης. Θα κλειθεί η μέθοδος του αντικειμένου
		s1.printInfo();
		
	}

}