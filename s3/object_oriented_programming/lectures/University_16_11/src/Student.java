
public class Student {
	
	private String name;
	private double gpa;
	
	public Student(String aName, double aGpa) {
		name = aName;
		gpa = aGpa;
	}
	
	public void printInfo(){
		System.out.println("Name: " + name);
		System.out.println("GPA: " + gpa);
	}
	
	

}
