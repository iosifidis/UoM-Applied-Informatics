// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0

import java.util.Random;

public class Player {

	// Create an object Random
	private Random r = new Random();
	
	// Create a method getRandom
	public int getRandom() {
		
		// Range of the random cards 
		int min = 2;
		int max = 11;
		
		// Return the random card
		return r.nextInt((max - min) + 1) + min; 
		}

}
