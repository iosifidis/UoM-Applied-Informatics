
public class Main {

	public static void main(String[] args) {
		
		// καλώ μέθοδο χωρίς να έχω δημιουργήσει αντικείμενο
		Soldier.printNumber();
		
		Soldier s1 = new Soldier("XY101");
		Soldier s2 = new Soldier("ZW150");
		
		s1.printNumber();
		s2.printNumber();

		Soldier s3 = new Soldier("XX350");
		s1.printNumber();
		Soldier.printNumber(); // ίδιο αποτέλεσμα με την προηγούμενη
		
		//Mathematics m1 = new Mathematics();
		System.out.println(Mathematics.powerOfThree(3));
		System.out.println("PI: " + Mathematics.PI);
	}

}
