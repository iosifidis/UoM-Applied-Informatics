
public class Main {

	public static void main(String[] args){
		
		Student s1 = new Student("John", "ics20133");
		Student s2 = new Student("Mary", "iis19047");
		Student s3 = new Student("Babis", "iis20100");
		
		Course c1 = new Course("Java" , 5);
		Course c2 = new Course("Machine Learning" , 5);

		
//		// Θέτω την τιμή του αντικειμένου μαθήματος c1 στην αναφορά s1
//		s1.setCourse(c1);
//
//		c1.printInfo();
		
		// Για να μην χρησιμοποιήσω αυτό, θα πάω στην Student και θα τροποποιήσω την setCourse
//		// Θέτω την τιμή του φοιτητή s1 στην αναφορά c1
//		c1.enrollStudent(s1);
		
//		s2.setCourse(c2);
//		
//		s1.printInfo();
//		// s2.printInfo();
		

		// Γράφω 3 φοιτητές σε ένα μάθημα
		c1.enrollStudent(s1);
		c1.enrollStudent(s2);
		c1.enrollStudent(s3);
		
		// Εκτυπώνω όλους τους φοιτητές
		c1.printInfo();
		
		
	}
}
