
public class Student implements Measurable{

	private double gpa;

	// Κατασκευαστής
	public Student(double gpa) {
		//Omit call .. για να μην βγάζει το super όταν πατώ alt+shift+s 
		this.gpa = gpa;
	}
	
	//Αλλάζω από getGPA σε getMeasure
	public double getMeasure(){
		return gpa;
	}
	
}
