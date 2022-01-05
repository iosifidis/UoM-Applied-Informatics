import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		// ΣΥΝΟΛΑ
		HashSet set = new HashSet(); // Το κάνω έτσι για να κάνω type casting όταν θα διατρέξω το σύνολο
//				HashSet<String> set = new HashSet<String>();
		
		// Προσθέτω ονόματα στο σύνολο
		set.add("John");
		set.add("Mary");
		set.add("Mary");
		set.add("Bob");
		set.add("John");
		set.add("Nick");
		
		// Επαναλήπτης
		Iterator iter = set.iterator();
		//Iterator<String> iter = set.iterator();
		
		// Διατρέχω το σύνολο
		while(iter.hasNext()){
			String name = (String)iter.next(); // Επειδή το hashset έχει object, πρέπει να το μετατρέψω σε String
			System.out.println(name);
			
			//Επίσης δουλεύει και το
			//System.out.println(iter.next().toString());
		}	
			// Τα αποτελέσματα ΔΕΝ έχουν διάταξη και ΔΕΝ έχουν τα διπλότυπα.
			// Αν χρειαστεί να βγάλω διπλότυπα, τα ρίχνω σε σύνολο και βγαίνουν
	}
}