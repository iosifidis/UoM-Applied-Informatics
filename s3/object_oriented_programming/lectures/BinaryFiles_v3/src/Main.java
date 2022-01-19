import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Θέλω να αποθηκεύσω μια λίστα υπαλλήλων σε ένα δυαδικό αρχείο
		Employee e1 = new Employee("John");
		Employee e2 = new Employee("Bob");
		Employee e3 = new Employee("Mary");
		
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		File file = new File("Employees.ser"); // Φτιάχνουμε ένα δυαδικό αρχείο
		
		// Θα γράψουμε στο δυαδικό αρχείο, όμως θα μας στείλει exception όπότε μπαίνει σε try/catch
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(outputStream);
			
			out.writeObject(employees); // ΕΔΩ ΑΠΟΘΗΚΕΥΟΥΜΕ ΟΛΟΚΛΗΡΗ ΤΗΝ ARRAYLIST
			
			System.out.println("Employees have been serialized");
			
			out.close();
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
