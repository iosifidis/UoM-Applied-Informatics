
public class Bulk extends Container {
	
	private double weight;

	// Κατασκευαστής
	public Bulk(String code, String destination, double weight) {
		super(code, destination);
		this.weight = weight;
	}
	
	// Μέθοδος υπολογισμού χρέωσης (πολυμορφισμός)
	public double calculateCharge(){
		
		return 10*weight;
	}

}
