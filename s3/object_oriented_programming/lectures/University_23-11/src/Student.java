//ΑΦΗΡΗΜΕΝΗ ΚΛΑΣΗ (abstract)= δεν μπορώ να χρησιμοποιήσω στην main την κλάση, έστω και κατά λάθος. Δεν φτιάχνω αντικείμενο Student

public abstract class Student {
	
	private String name;
	private String id;
	
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public void printInfo(){
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
	}
	
	//Ένοια αφαίρεσης
	//Αυτήν δεν θα την χρησιμοποιήσει κανείς. Μέθοδος αφηρημένη (abstract). Χωρίς υλοποίηση.
	//Η μέθοδος αυτή πρέπει να είναι σε abstract κλάση. 
	//Την έχω φτιάξει προς όφελος των υποκλάσεων για να επιτρέψω ΠΟΛΥΜΟΡΦΙΣΜΟ. Να μπορεί να εκτυπώσει η υποκλάση
	public abstract void printType();
	

}
