import java.util.HashMap;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		
		// Δομή δεδομένων που κάνει αντιστοιχία σε 2 στοιχεία (key --> value)
		// Τα κλειδιά πρέπει να είναι μοναδικά. Είναι Set οπότε ΔΕΝ πρέπει να είναι ίδια
		// ΑΝ ΖΗΤΑΕΙ ΑΝΤΟΙΣΤΟΙΧΙΣΗ ΤΙΜΩ, ΦΩΝΑΖΕΙ ΝΑ ΕΙΝΑΙ MAP
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("Mary", "2310-538759");
		map.put("Nick", "2310-766350");
		map.put("Helen", "2310-845788");
		map.put("Mike", "2310-224990");
		
		// Πως διατρέχω δομή τύπου map για να δω τα στοιχεία της
		for(String key: map.keySet()){ //keySet επιστρέφει το σύνολο των κλειδιών
			String value = map.get(key); // Παίρνω την τιμή που αντιστοιχεί στο key
			System.out.println(key + ": " + value);
		}
		
		// Εκτύπωση με Iterator
		System.out.println("-----------------");
		Iterator<String> i = map.keySet().iterator(); //keySet επιστρέφει το σύνολο των κλειδιών
		while(i.hasNext()) {
			String key = i.next();
			String value = (String)map.get(key); // παίρνουμε την τιμή που αντιστοιχεί στο κλειδί
			
			System.out.println("Key: " + key + " Value: " + value);
		}
		
		map.remove("Helen"); // Αφαίρεση της εγγραφής Helen
		System.out.println("------------");
		for(String key: map.keySet()){ //keySet επιστρέφει το σύνολο των κλειδιών
			String value = map.get(key); // Παίρνω την τιμή που αντιστοιχεί στο key
			System.out.println(key + ": " + value);
		}
		
	}

}
