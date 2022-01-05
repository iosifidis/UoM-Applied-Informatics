import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		// ΔΕΝΤΡΟ (Τα αποτελέσματα θα είναι ταξινομημένα)
		Collection<String> set = new TreeSet<String>();
		
		set.add("Olga");
		set.add("Nikos");
		set.add("Babis");
		set.add("Takis");
		
//		for(String name: set)
//			System.out.println(name);
		
		Iterator<String> iter = set.iterator();
		
		// Εμφανίζονται ταξινομημένα (προστίθενται σε δυαδικό δέντρο)
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}

}
