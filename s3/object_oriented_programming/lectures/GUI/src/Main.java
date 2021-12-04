import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		MyFrame mf = new MyFrame();
		
		// ΣΕΤ εντολών που εκτελούμε κάθε φορά για να φτιάξουμε παράθυρο
		//Ορατό παράθυρο, ανάλογα με το στάδιο της εκτέλεσης
		mf.setVisible(true);
		
		//Μέγεθος παραθύρου
		mf.setSize(400,400);

		//Ένας τίτλος πάνω στο παράθυρο
		mf.setTitle("My first window στα ελληνικά");

		//Τι θα κάνει το παράθυρο όταν πατήσουμε το X πάνω στο παράθυρο
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
