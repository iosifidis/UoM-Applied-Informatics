import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		// ΑΦΙΑΡΕΣΗ ΔΙΠΛΟΤΥΠΩΝ
		ArrayList<String> inputs = new ArrayList();
		
		// Προσθέτω ονόματα στην λίστα
		inputs.add("John");
		inputs.add("Mary");
		inputs.add("Mary");
		inputs.add("Bob");
		inputs.add("John");
		inputs.add("Nick");

		// Επαναλήπτης
		Iterator<String> iter = inputs.iterator();
		
		// Διατρέχω την λίστα
		while(iter.hasNext()){
			String name = iter.next();
			System.out.println(name);
			
		}	
		
		System.out.println("-------------------");
		
		// Φτιάχνω ένα Collection και αναθέτω ένα HashSet του οποίου βάζω μέσα την λίστα για να αφαιρέσω τα διπλότυπα
		Collection<String> noDups = new HashSet<String>(inputs);
		
		// Μηδενισμός του Επαναλήπτη. Μπορώ να χρησιμοποιήσω και άλλον θεωτηρικά.
		iter = noDups.iterator();
		
		// Διατρέχω το Collection. Βλέπω έχουν βγει τα διπλότυπα
		while(iter.hasNext()){
			String name = iter.next();
			System.out.println(name);
			
		}	
	}
}