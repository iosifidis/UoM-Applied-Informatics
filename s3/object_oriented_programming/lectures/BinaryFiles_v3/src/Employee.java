import java.io.Serializable;

// Πρέπει να κάνω υλοποίηση της διασύνδεσης για να μπορούν να πάνε σε δυαδικό αρχείο (βγάζει σφάλμα αν δεν έχει)
public class Employee implements Serializable{
	
	private String name;
	
	public Employee(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

}
