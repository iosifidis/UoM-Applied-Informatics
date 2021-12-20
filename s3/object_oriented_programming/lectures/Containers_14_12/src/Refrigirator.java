
public class Refrigirator extends Container{
	
	private double power;

	// Κατασκευαστής
	public Refrigirator(String code, String destination, double power) {
		super(code, destination);
		this.power = power;
	}
	
	// Μέθοδος υπολογισμού χρέωσης (πολυμοορφισμός)
	public double calculateCharge(){

		return 2000 * power;
	}

}
