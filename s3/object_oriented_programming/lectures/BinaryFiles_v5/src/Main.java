import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Θέλω να αποθηκεύσω μια λίστα υπαλλήλων με δικό του αμάξι σε ένα δυαδικό αρχείο
		
		Car car1 = new Car("Fiat", 1000);
		Car car2 = new Car("Mazda", 2500);
		Car car3 = new Car("Toyota", 1200);
		
		Employee e1 = new Employee("John", car2);
		Employee e2 = new Employee("Bob", car1);
		Employee e3 = new Employee("Mary", car3);
		
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		File file = new File("Employees.ser");
		
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(outputStream);
			out.writeObject(employees); // ΕΔΩ ΑΠΟΘΗΚΕΥΟΥΜΕ ΟΛΟΚΛΗΡΗ ΤΗΝ ARRAYLIST ΜΑΖΙ ΜΕ ΤΟ ΑΜΑΞΙ ΤΟΥ
			
			System.out.println("Employees have been serialized");
			// Κλείνουμε τα ρεύματα
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
