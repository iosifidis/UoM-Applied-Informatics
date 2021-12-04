
public class GraduateStudent extends Student {
	
	private String supervisor;

	public GraduateStudent(String aName, double aGpa, String aSupervisor) {
		super(aName, aGpa);
		supervisor = aSupervisor;
	}
	
	public void printInfo(){
		super.printInfo();
		System.out.println("Supervisor: " + supervisor);
	}
	

}
