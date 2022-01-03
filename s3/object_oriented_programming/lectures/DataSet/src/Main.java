
public class Main {

	public static void main(String[] args) {
		
		// Δημιουργία ενός αντικειμένου dataset
		DataSet ds = new DataSet();
		
		// Δημιουργία αντικειμένων BankAccount
		BankAccount ba1 = new BankAccount(1200);
		BankAccount ba2 = new BankAccount(2100);
		BankAccount ba3 = new BankAccount(1600);
		
		// Δημιουργία αντικειμένων Student 
		Student s1 = new Student(8.9);
		Student s2 = new Student(6.7);
		Student s3 = new Student(9.4);
		
		// Προσθήκη αντικειμένων BankAccount στο Dataset
		ds.add(ba1);
		ds.add(ba2);
		ds.add(ba3);
		
		// Προσθήκη αντικειμένων Student στο Dataset
//		ds.add(s1);
//		ds.add(s2);
//		ds.add(s3);

		// Εκτύπωση του Dataset με την χρήση της διεπαφής
		System.out.println("Average: " + ds.getAverage());
		System.out.println("Maximum: " + ds.getMaximum().getMeasure());
		System.out.println("Minimum: " + ds.getMinimum().getMeasure());
		
		// Για BankAccount: Αρχικό πρόγραμμα χωρίς την χρήση της διεπαφής
//		System.out.println("Average: " + ds.getAverage());
//		System.out.println("Maximum: " + ds.getMaximum().getBalance());
//		System.out.println("Minimum: " + ds.getMinimum().getBalance());
		
		// Για Student: Αρχικό πρόγραμμα χωρίς την χρήση της διεπαφής
//		System.out.println("Average: " + ds.getAverage());
//		System.out.println("Maximum: " + ds.getMaximum().getGPA());
//		System.out.println("Minimum: " + ds.getMinimum().getGPA());
	}

}
