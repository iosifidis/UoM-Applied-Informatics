// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Δημιουργία ενός αντικειμένου (in) της κλάσης Scanner
		Scanner in = new Scanner(System.in);
		
		String bestName = "";
		double bestPrice = 1;
		int bestScore = 0;
		
		boolean more = true;
		while(more) {
			
			String currentName;
			double currentPrice;
			int currentScore;
			
			System.out.println("Please enter the product name: ");
			currentName = in.nextLine();
			System.out.println("Please enter the product price: ");
			currentPrice = in.nextDouble();
			System.out.println("Please enter the product score: ");
			currentScore = in.nextInt();
			
			// Έλεγχος εάν το τρέχον προϊόν είναι το καλύτερο
			if(currentScore/currentPrice > bestScore/bestPrice) {
				
				bestName = currentName;
				bestPrice = currentPrice;
				bestScore = currentScore;
			}
		
			// Ερώτημα εισαγωγής νέου προϊόντος. Αλλαγή σημαίας
			System.out.println("Another product? (1: YES, 2: NO)");
			int answer = in.nextInt();
			if(answer !=1)
				more = false;
			// Εκκαθάριση input buffer
			in.nextLine();
		}
		// Εκτύπωση καλύτερου προϊόντος
		System.out.println("Best product with the following data");
		System.out.println("Name: " + bestName);
		System.out.println("Price: " + bestPrice);
		System.out.println("Score: " + bestScore);
		
		// Κλείσιμο ρεύματος εισόδου
		in.close();
		
	}
}
