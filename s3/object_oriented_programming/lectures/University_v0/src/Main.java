// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027

public class Main {

	public static void main(String[] args){
		
		// Μπορώ να πάρω τις τιμές από το πληκτρολόγιο
		// Scanner in = new Scanner(System.in);
		// System.out.println("Enter a Name: ");
		// String name = in.nextLine();
		// System.out.println("Enter some id: ");
		// String id = in.nextLine();
		// Student s1 = new Student(name,id);
		
		// χρήση διαφορετικών κατασκευαστών
		Student s1 = new Student("Babis", "ics20155");
		Student s2 = new Student("Maria");
		Student s3 = new Student();
		
		// εκτύπωση αντικειμένων
		s1.printInfo();
		s2.printInfo();
		s3.printInfo();
		
		s3.setName("Takis");
		s3.printInfo();
		
		System.out.println(s1.getName());
		
	}
	
}
