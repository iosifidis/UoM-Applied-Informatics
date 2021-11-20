// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Open input stream
		Scanner in = new Scanner(System.in);
		
		// Create objects (player p and dealer d)
		Player p = new Player();
		Dealer d = new Dealer();
		
		// Create and initialize sum of cards (for both player and dealer)
	    int pTotal = 0, dTotal = 0;
	    
	    // Create a string for the question hit or stay
	    String answer;
		
	    // Title of the game
		System.out.println("Welcome to the simplified blackjack game!");
		
		// Get random cards for the first two player's cards and find the total
		int card1 = p.getRandom();
		int card2 = p.getRandom();
		pTotal = card1 + card2;
		
		// Display the cards and total
		System.out.println("You get a " + card1 + " and " + card2 + ".");
		System.out.println("Your total is " + pTotal + "." + "\n");
		
		// Get random cards for dealer 
		int dcard1 = d.getRandom();
		int dcard2 = d.getRandom();
		dTotal = dcard1 + dcard2;
		
		// Display only the first dealer's card
		System.out.println("The dealer has a " + dcard1 + " showing, and a hidden card." + "\n");
		
		// If player's total is more than 21, then dealer wins
		if(pTotal > 21) {
			System.out.println("DEALER WINS!");
			
		}	
		
		// If player's total is less than 21, then we have a game	
		if(pTotal<21) {
			
			// Question if player want to hit or stay
			System.out.print("Would you like to “hit” or “stay”? ");
			answer = in.nextLine();
			
			// Loop if player replies hit
			while(answer.equals("hit")) {
					
				// Get next random card and display on the screen
				int nextCard = p.getRandom();
				System.out.println("You drew a " + nextCard + ".");
					
				// Find new total of the player's cards
				pTotal += nextCard;
					
				// If player's total is more than 21, then dealer wins and break the loop
				if(pTotal > 21) {
					System.out.println("Your total is " + pTotal + ".");
					System.out.println("");
					System.out.println("DEALER WINS!");
					break;		
				}
				
				// Display player's total
				System.out.println("Your total is " + pTotal + ".");
				System.out.println("");
				
				// Question if player wants another card or not
				System.out.print("Would you like to “hit” or “stay”? ");
				answer = in.nextLine();
					
			}
		}
		
		// If player's total is more than 21, then dealer wins and game ends. Else, dealer's turn.
		if(pTotal<21) {

			// Dealer shows his cards and his total
			System.out.println("");
			System.out.println("OK, dealer is playing.");
			System.out.println("His hidden card was " + dcard2 + ".");
			System.out.println("His total is " + dTotal + ".");
			
			// Set flag answer = hit so it will enter the while loop for dealer
			answer = "hit";
		
			// If dealer's total is more than 21, then player wins, change flag and dealer never plays.
			if(dTotal > 21) {
				System.out.println("");
				System.out.println("YOU WIN!");
				answer = "stay";
			}
								
			// Dealer's while loop 
			while(answer.equals("hit")) {
					
				// If dealer has total more than 16, he stays and brakes the loop
				if(dTotal > 16) {
					System.out.println("");
					System.out.println("Dealer stays.");
					break;
				}	
				
				// Dealers hits a card
				System.out.println("");
				System.out.println("Dealer chooses to hit.");
					
				// Get next random card for dealer and finds new total
				int dnextCard = d.getRandom();
				dTotal += dnextCard;
				
				// Display the card and total
				System.out.println("He draws a " + dnextCard + ".");
				System.out.println("His total is " + dTotal + ".");
					
				// Dealer hit randomly. If draw = 1 then he hits. Else stays.
				int draw = d.getHit();
				if(draw == 1){
					answer = "hit";
				}
				else {
					answer = "stays";
				}
				
				// If dealer's total is more than 21, then player wins, change flag and dealer never plays.
				if(dTotal > 21) {
					System.out.println("");
					System.out.println("YOU WIN!");
					answer = "stay";
					break;
						
				}
					
			}
		}
		
		// Print results
		
		// If any of the players has more than 21, then game over.
		if(pTotal > 21 || dTotal > 21) {
			System.out.println("");
			System.out.println("GAME OVER!");
		}
		
		// If any of the players has less than 21, then compare their totals
		else {
			
			// Print results
			System.out.println("");
			System.out.println("Dealer total is " + dTotal + ".");
			System.out.println("Your total is " + pTotal + ".");
			System.out.println("");
			
			// Compare who wins
			if(pTotal > dTotal) 
				System.out.println("YOU WIN!");
			else 
				System.out.println("DEALER WINS!");

			// End game
			System.out.println("");
			System.out.println("GAME OVER!");
				
		}
		
		// Close input stream
		in.close();
	}
}