
public class Student {
	
	private String name;
	private String id;
	
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	// Επικάλυψη της toString και αξιοποίηση του πολυμπορφισμού. 
	// Χωρίς αυτό, όταν εκτελείται η print εμφανίζει Student@ee7d9f1 (Αντικείμενο@διεύθυνση)
	// Η υπογραφή πρέπει να είναι ίδια γιατί στην object η μέθοδος toString εμφανίζεται έτσι
	public String toString(){
		return (name + ", " + id);
	}
	
	//Επικάλυψη της equals
	public boolean equals(Object obj){
		
		//Ρητή μετατροπή τύπου από Object σε Student
		Student otherStudent = (Student)obj;
		
		//Συγκρίνω όνομα μου αν ταυτίζεται με το όνομα του otherStudent
		//Όταν κάνω μια ιδιότητα private δεν είναι ορατή σε άλλες κλάσεις. Στην περίπτωσή μου είναι ίδια κλάση οπότε την χρησιμοποιώ
		//Σύγκριση μπορεί να γίνει με == αλλά καλύτερα να γίνει με equals επειδή η String έχει υλοποιημένη την equals
		if(this.name.equals(otherStudent.name) && this.id.equals(otherStudent.id))
			return true;
		else
			return false;
		
	}
	

}
