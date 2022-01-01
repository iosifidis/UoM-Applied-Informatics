
public class Course {

	private String name;
	private int ects;
	
//	// Αναφορά που δείχνει σε έναν φοιτητή
//	private Student enrolledStudent;
	
	// Για πολλούς φοιτητές που παρακολουθούν, πρέπει να φτιάξω έναν πίνακα
	private Student[] enrolledStudents = new Student[100];
	
	private int numberOfStudents;
	
	public Course(String aName, int aNumber){
		name = aName;
		ects = aNumber;
		// Η αρχικοποίηση είτε εδώ είτε στην δήλωσή του
		numberOfStudents=0;
	}
	
	// Μέθοδος set
	public void enrollStudent(Student s){
//		// Για έναν φοιτητή
//		enrolledStudent = s;
		
		// Για πολλούς φοιτητές
		
		enrolledStudents[numberOfStudents] = s;
		numberOfStudents++;
	
	}
	
	public void printInfo(){
		System.out.println("Course Name: " + name);
		System.out.println("ECTS: " + ects);
		System.out.println("has the following students");
		// Διατρέχω και εκτυπώνω τον πίνακα με τους φοιτητές
		for(int i=0; i<numberOfStudents; i++){
			System.out.println("student name: " + enrolledStudents[i].getName());
			
		}
		
//		// Εκτυπώνω το όνομα του φοιτητή
//		System.out.println("student name: " + enrolledStudent.getName());
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getECTS(){
		return ects;
	}
	
	
	
}