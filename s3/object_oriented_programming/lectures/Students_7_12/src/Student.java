
public class Student {
	
	private String name;
	private String id;
	
	// Κατασκευαστής
	public Student(String name, String id) {
	
		this.name = name;
		this.id = id;
	}
	
	// Επικάλυψη της toString
	public String toString(){
		
		return (name + ", " + id);
	}
	

}
