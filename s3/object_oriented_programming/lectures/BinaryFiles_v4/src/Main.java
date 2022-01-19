import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Φτιάχνω μια κενή λίστα για να μπορεί να δεχτεί την ArrayList που θα διαβάσει από το αρχείο
		ArrayList<Employee> employees = null;
		
		// Ανάγνωση αντικειμένου υπάλληλος από αρχείο
		// Εμφανίζει exception οπότε try/catch
		File file = new File("Employees.ser"); // Αναπαράσταση του αρχείου δίσκου
		try {
			FileInputStream inputStream = new FileInputStream(file); // Το στέλνω για να το διαβάσει επειδή δεν μπορώ να το διαβάσω κατευθείαν
			
			ObjectInputStream in = new ObjectInputStream(inputStream); // Επειδή δεν μπορώ να το διαβάσω bytε προς byte ο στέλνω για να διαβάσει ολόκληρα αντικείμενα
			
			// Αναθέτω το αντικείμενο που διάβασα σε ένα αντικείμενο employees (ΡΗΤΗ ΜΕΤΑΤΡΟΠΗ ΕΔΩ γιατί θεωρητικά δεν ξέρω τι επιστρέφει)
			// Εμφανίζει exception η readObject (δεν μπορεί να καταλάβει την κλάση)
			employees = (ArrayList<Employee>)in.readObject();
			
			System.out.println("Object has been deserialized");
			// Εκτυπώνω το όνομα
			for(Employee e: employees)
				System.out.println("The retrieved employee object has name: " + e.getName());
			// Κλείνω ρεύματα
			in.close();
			inputStream.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
