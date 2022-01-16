import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("John");
		names.add("Bob");
		names.add("Nick");
		names.add("Mary");
		names.add("Helen");
		
		System.out.println("----Sorted----");
		Collections.sort(names); // Ταξινομώ την λίστα
		for(String name: names)
			System.out.println(name);
		
		System.out.println("----Reversed----");
		Collections.reverse(names); // Αντιστρέφω την ταξινόμηση
		for(String name: names)
			System.out.println(name);
		
		System.out.println("----Shuffled----");
		Collections.shuffle(names); // Τυχαίο ανακάτεμα. Τυχαία σειρά
		for(String name: names)
			System.out.println(name);
		
		System.out.println("----Swapped----");
		Collections.swap(names, 2, 3); // Εναλλαγή σειράς
		for(String name: names)
			System.out.println(name);
		
		System.out.println("----Frequency----");
		names.add("Mary");
		names.add("Mary");
		int freq = Collections.frequency(names, "Mary"); // Εύρεση συχνότητας εμφάνισης
		System.out.println("Frequency of Mary is: " + freq);
		
		System.out.println("----Min and Max elements----"); // Βρίσκω το ελάχιστο και το μέγιστο
		String max = Collections.max(names);
		String min = Collections.min(names);
		
		System.out.println("Max is: " + max);
		System.out.println("Min is: " + min);
	}

}
