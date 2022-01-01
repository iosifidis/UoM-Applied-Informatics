
public class Student {
	
	private String name;
	private String id;
	// Ιδιότητα Course
	// Αναφορά προς το μάθημα
	private Course myCourse;

	// Μέθοδος set για ορισμό μαθήματος και εγγραφή φοιτητή στο μάθημα που παρακολουθεί
	public void setCourse(Course aCourse){

		myCourse = aCourse;
		// Μέθοδος που καλείται για να εγγράψει τον φοιτητή στο μάθημα
		aCourse.enrollStudent(this);
	}
	
	public Student(String aName, String someId){
		name = aName;
		id = someId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public void printInfo(){
		
		System.out.println("Name: " + name);
		System.out.println("Id: " + id);
		System.out.println("--------------------");
		System.out.println("Is enrolled in ");
		if(myCourse!= null){
			System.out.println("Course: " + myCourse.getName());
		    System.out.println("ECTS: " + myCourse.getECTS());
		}
		else
			System.out.println("No course selected");
		}
	
}
