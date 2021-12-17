
public abstract class Container {
	
	private String code;
	private String destination;
	
	public Container(String code, String destination) {
		this.code = code;
		this.destination = destination;
	}
	
	//Δημιουργία μεθόδου για να την χρησιμοποιήσω στην Ship ώστε να υπολογίσω την χρέωση του πλοίου. 
	//Την φτιάχνω αφηρημένη (abstract) και μετατρέπω και την κλάση
	public abstract double calculateCharge();
	

}
