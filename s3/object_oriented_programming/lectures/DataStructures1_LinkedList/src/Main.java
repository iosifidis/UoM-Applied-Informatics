import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		// ΣΥΝΔΕΔΕΜΕΝΕΣ ΛΙΣΤΕΣ
		// Φτιάχνω μια συνδεδεμένη λίστα αντικειμένων τύπου Integer
		LinkedList<Integer> list = new LinkedList<>();
		
		// Κανονικά πρέπει να το γράψω έτσι αλλά η Java, αν το γράψω μόνο 5, το μετατρέπει η ίδια σε αντικείμενο
		list.add(new Integer(5));
		
		//Εδώ μετατρέπει τους αριθμούς σε αντικείμενα Integer
		list.add(7);
		list.add(3);
		list.add(11);
		
		
//		for(Integer i: list)
//			System.out.println(i);
		
		// Επαναλήπτης που θα διασχίσει ακεραίους της δομής δεδομένων (δουλεύει σε όλες τις δομές)
		Iterator<Integer> iter = list.iterator();
		
		//Όσο ο επαναλήπτης έχει επόμενο στοιχείο
		while(iter.hasNext()){
			//Φέρτο και τύπωσέ το
			System.out.println(iter.next());
		}
		
		// Αν θέλω να ξανατρέξω την λίστα, πρέπει να τον φρεσκάρω
		// iter = list.iterator();
 }	
}
