
public class Soldier {
	
	private String id;
	// στατική ιδιότητα μέσα στην κλάση και όχι για το αντικείμενο
	private static int counter = 0;
	
	public Soldier(String someId){
		id=someId;
		counter++;
	}
	
	// στατική μέθοδος για να μπορώ να την καλώ χωρίς να έχω φτιάξει αντικείμενο
	public static void printNumber(){
		
		System.out.println("Total number: " + counter);
	}
	

}
