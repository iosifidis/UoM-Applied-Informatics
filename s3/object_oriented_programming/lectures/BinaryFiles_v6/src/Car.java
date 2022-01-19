import java.io.Serializable;

// Για αποθήκευση σε δυαδικό αρχείο
public class Car implements Serializable{

	private String brand;
	private int cc;
	
	public Car(String brand, int cc) {

		this.brand = brand;
		this.cc = cc;
	}
	
	public String getDetails(){
		return (brand + ", " + cc);
	}
	
	
}
