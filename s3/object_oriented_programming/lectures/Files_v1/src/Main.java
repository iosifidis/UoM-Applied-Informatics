import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Θα προσθέτουμε στοιχεία σε ascii αρχείο.
		ArrayList<String> names = new ArrayList<>();
		
		names.add("John");
		names.add("Mary");
		names.add("Helen");
		names.add("Bob");
		names.add("Nick");
		
		// Δημιουργώ ένα αρχείο
		File f = new File("names.txt");
		//Δημιουργώ ένα αντικείμενο FileWriter για να γράψω σε αρχείο και στέλνω το αρχείο που δημιούργησα πιο πάνω.
		// Στην αρχή, μας εμφανίζει ένα checked exception. 
		// Πρέπει να κάνω χειρισμό. Επιλέγω try/catch
		try {
			FileWriter writer = new FileWriter(f);
			
			for(String name: names){
				writer.write(name); // Εγγραφή στο αρχείο
				writer.write(System.lineSeparator()); // Αλλαγή γραμμής στο σύστημα που εκτελείται ο κώδικας
			}
			
			writer.close(); // Κλείνω το ρεύμα...
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
