import java.util.ArrayList;

public class Course {
	
	private String name;
	private ArrayList<Student> students = new ArrayList<Student>();

	
	public Course(String name) {
		this.name = name;
	}
	

	public void enrollStudent(Student aStudent){
		students.add(aStudent);
		
	}
	
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
