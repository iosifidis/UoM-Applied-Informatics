// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0

import java.util.Random;

public class Dealer {
	
	// Create objects Random
	private Random r = new Random();
	private Random h = new Random();
	
	// Create a method getRandom
	public int getRandom() { 
		
		// Range of the random cards
		int min = 2;
		int max = 11;
		
		// Return the random card
		return r.nextInt((max - min) + 1) + min; 
		}
	
	// Create a method getHit
	public int getHit() { 
		
		// Range of the random hit or stay
		int stay = 0;
		int hit = 1;
		
		// Return the random number
		return h.nextInt(hit - stay + 1)+stay; 
		}
}
