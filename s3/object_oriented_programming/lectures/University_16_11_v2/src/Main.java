
public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student("Babis","ics20121");
		Student s2 = new Student("Maria", "iis19038");
		Student s3 = new Student("Sakis", "iis19039");
		
		Course c1 = new Course("Java", 5);
		Course c2 = new Course("Cryptography", 5);
		
		ClassRoom r1 = new ClassRoom("Amf12", 2);
		ClassRoom r2 = new ClassRoom("Erg234", 3);

		// Ορισμός αίθουσας στο μάθημα
		c1.setClassroom(r1);
		c2.setClassroom(r2);
		
		// Εγγραφή 3 φοιτητών στα ανάλογα μαθήματα
		c1.enrollStudent(s1);
		c1.enrollStudent(s2);
		c1.enrollStudent(s3);
		
		// Εκτύπωση των λεπτομερειών του μαθήματος
		c1.printCourseDetails();
		//c2.printCourseDetails();
		
		// Δημιουργία αντικειμένου γραμματείας
		Registry reg1 = new Registry("Applied Informatics");
		reg1.addCourse(c1); // Προσθήκη μαθήματος στην γραμματεία
		reg1.addCourse(c2); // Προσθήκη μαθήματος στην γραμματεία
		
		// Εκτύπωση δεδομένων της γραμματείας
		reg1.printDepartmentData();

	}

}
