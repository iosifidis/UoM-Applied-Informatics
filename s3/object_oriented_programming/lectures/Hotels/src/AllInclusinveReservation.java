
public class AllInclusinveReservation extends Reservation {
	
	int meals;

	public AllInclusinveReservation(int days, int meals) {
		super(days);
		this.meals = meals;
	}
	
	public double calculateCost() {
		
		return days * (120+ meals*30);
	}

}
