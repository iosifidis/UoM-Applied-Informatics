import java.util.ArrayList;

public class Course {
	
	private String name;
	
	// Φτιάχνω μια λίστα με φοιτητές
	private ArrayList<Student> students = new ArrayList<Student>();

	// Κατασκευαστής
	public Course(String name) {
		this.name = name;
	}
	
	// Μέθοδος προσθήκης φοιτητή στην λίστα με τους φοιτητές
	public void enrollStudent(Student aStudent){
		students.add(aStudent);
		
	}
	
	// Μέθοδος εκτύπωσης του μαθήματος
	public void printCourceDetails(){
		System.out.println("------------------");
		System.out.println("Course name: " +name);
		System.out.println("has the following students: ");
		for(Student student: students)
			System.out.println(student);
		
	}
	
	public String getName(){
		return name;
	}
	
}
