import java.util.ArrayList;

public class Course {
	
	private String name;
	private int ects;
	// Φτιάχνω μια ArrayList για να καταχωρώ φοιτητές που έχουν εγγραφεί στο μάθημα
	// Βάζω <> και μέσα τον τύπο των αντικειμένων που θα αποθηκεύω στην ArrayList
	private ArrayList<Student> students = new ArrayList<>();
	// Ιδιότητα ClassRoom για σύνδεση μαθήμτος με τάξη
	private ClassRoom myClassroom;
	
	// Κατασκευαστής
	public Course(String name, int ects) {
		this.name = name;
		this.ects = ects;
	}

	// Μέθοδος εγγραφής στο μάθημα
	public void enrollStudent(Student aStudent){
		
		// Κάνω έλεγχο αν το μέγεθος της λίστα των μαθητών είναι μικρότερο από το μέγεθος που χωράει η αίθουσα
		if(students.size() < myClassroom.getCapacity()){
			students.add(aStudent); // Πρόσθεσε τον φοιτητή
			System.out.println("Student successfully enrolled"); // Εκτύπωσε μήνυμα επιτυχίας
		}
		else
			System.out.println("Sorry the course is full"); // Εκτύπωσε μήνυμα αποτυχίας
	}
	
	// Μέθοδος εκτύπωσης λεπτομερειών μαθήματος
	public void printCourseDetails(){
		System.out.println("Course name: " + name);
		System.out.println("ECTS: " + ects);
		// Εκτύπωση αίθουσας
		System.out.println("Classroom: " + myClassroom.getLocation());
		
		for(int i=0 ; i<students.size(); i++){
			// Αν στο ArrayList δεν είχα εισάγει το <>, τότε πρέπει να κάνω ρητή μετατροπή σε Student
			// Student s = (Student) students.get(i);
			
			Student s = students.get(i);
			s.printInfo();
			
			// Σε μια σειρά θα έβγαινε students.get(i).printInfo();
		}
	
	}
	
	public void setClassroom(ClassRoom aClassroom) {
		
		myClassroom = aClassroom;
	}
	
}
