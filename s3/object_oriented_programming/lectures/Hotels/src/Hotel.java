import java.io.Serializable;
import java.util.ArrayList;


public class Hotel implements Serializable {
	
	private String name;
	private ArrayList<Reservation> reservations = new ArrayList<>();//'Εβαλα κρατήσεις
	
	public Hotel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void addReservation(Reservation r){
		reservations.add(r);
	}
	
	// Υπολογισμός χρεώσεων κρατήσεων
	public double calculateTotalCharge(){
		int total=0;
		for(Reservation res: reservations)
			sum += res.calculateCost();	
		return total;
		
	}
}
