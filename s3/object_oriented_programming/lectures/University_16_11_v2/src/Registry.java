import java.util.ArrayList;

public class Registry {

	private String departmentName;
	
	// Δημιουργία μιας ArrayList για καταχώρηση των μαθημάτων στην main
	private ArrayList<Course> courses = new ArrayList<>();
	
	// Κατασκευαστής
	public Registry(String aName) {
		departmentName = aName;
	}

	// Μέθοδος προσθήκης μαθήματος στην ArrayList
	public void addCourse(Course aCourse){
		
		courses.add(aCourse);
		
	}
	
	// Εκτύπωση όλων των πληροφοριών της γραμματείας
	public void printDepartmentData(){
		
		System.out.println("Department Name: " + departmentName);
		System.out.println("Has the following courses: ");
		
		for(int i=0 ; i<courses.size(); i++){
			Course c = courses.get(i);
			c.printCourseDetails();
		}
	}
	
}
