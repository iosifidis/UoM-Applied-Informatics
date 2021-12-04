
public class PhDStudent extends Student {
	
	private String thesis;

	public PhDStudent(String name, String id, String thesis) {
		super(name, id);
		this.thesis = thesis;
	}
	
	public void printInfo(){
		super.printInfo();
		System.out.println("Thesis: " + thesis);
	}
	

	public void printType(){
		System.out.println("Hello I am a PhD student");
	}
}
