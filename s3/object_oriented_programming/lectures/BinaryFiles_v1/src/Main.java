import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		
		Employee e = new Employee("John");
		
		// Δημιουργία αρχείου για να αποθηκεύσω τον υπάλληλο (ser = serialization)
		File file = new File("employee.ser");

		//Εμφάνιση exceptions
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);
			
			//Υψηλότερου επιπέδου εντολές. Γράφω ένα αντικείμενο καλώντας εντολή writeobject
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(e); // Γράφω τον υπάλληλο στο αρχείο
			System.out.println("Object has been serialized");
			// Κλείνω ρεύματα με αντίστροφη σειρά
			out.close();
			fileOut.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
