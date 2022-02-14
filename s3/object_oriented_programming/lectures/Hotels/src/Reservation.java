
// Κλάση
public class Reservation {
	
	protected int days;

	public Reservation(int days) {
		this.days = days;
	}
	
	public double calculateCost() {
		
		return days*120;
	}
	

}
