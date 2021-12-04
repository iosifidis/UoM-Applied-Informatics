// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027

import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//κατασκευή αντικειμένου της κλάσης Product
		Product best = new Product();
		
		boolean more = true;
		while(more) {
			
			Product current = new Product();
		
			//κλήση λειτουργίας ή μεθόδου readData επί του αντικειμένου current
			//Αποστολή του μηνύματος readData στο αντικείμενο current
			current.readData();
			
			//Έλεγχος αν το τρέχον είναι καλύτερο από το τρέχον καλύτερο, τότε άλλαξέ το
			if(current.isBetterThan(best))
				best=current;
			
			System.out.println("More data ? (1=YES, 2=NO)");
			int answer = in.nextInt();
			if(answer != 1)
				more = false;
			in.nextLine();
			
		}
		
		
		//Εκτύπωση καλύτερου προϊόντος
		System.out.println("BEST Product: ");
		best.printData();
		

	}

}