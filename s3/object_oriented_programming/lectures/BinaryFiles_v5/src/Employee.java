import java.io.Serializable;

// Πρέπει να κάνω υλοποίηση της διασύνδεσης για να μπορούν να πάνε σε δυαδικό αρχείο (βγάζει σφάλμα αν δεν έχει)
public class Employee implements Serializable{
	
	private String name;
	private Car ownedCar;
	
	public Employee(String name, Car aCar){
		this.name = name;
		this.ownedCar = aCar;
	}
	
	public String getName(){
		return name;
	}
	
	public Car getCar(){
		return ownedCar;
	}

}
