
public class Student {
	
	private String name;
	private String id;
	
	// Κατασκευαστής
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	// Μέθοδος εκτύπωσης
	public void printInfo(){
		
		System.out.println("Name: " + name);
		System.out.println("Id: " + id);
		System.out.println("--------------------");
	}

}
