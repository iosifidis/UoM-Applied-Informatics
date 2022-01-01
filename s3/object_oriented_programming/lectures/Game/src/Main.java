
public class Main {

	public static void main(String[] args) {
		
		// καλώ μέθοδο χωρίς να έχω δημιουργήσει αντικείμενο
		Soldier.printNumber();
		
		// Φτιάχνω 2 στρατιωτάκια
		Soldier s1 = new Soldier("XY101");
		Soldier s2 = new Soldier("ZW150");
		
		// Εκτυπώνω πόσα στρατιωτάκια έχω
		s1.printNumber();
		s2.printNumber();

		// Φτιάχνω ένα ακόμα στρατιωτάκι
		Soldier s3 = new Soldier("XX350");
		s1.printNumber(); // Ρωτάω το πρώτο στρατιωτάκι πόσα έχω δημιουργήσει
		Soldier.printNumber(); // ίδιο αποτέλεσμα με την προηγούμενη
		
		//Mathematics m1 = new Mathematics();
		System.out.println(Mathematics.powerOfThree(3));
		System.out.println("PI: " + Mathematics.PI); // Επειδή είναι δηλωμένη η ιδιότητα ως public 
	}

}
