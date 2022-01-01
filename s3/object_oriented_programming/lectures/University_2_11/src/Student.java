
public class Student {
	
	private String name;
	private String id;
	
	//Κατασκευαστής που δέχεται παραμέτρους όνομα και id
	public Student(String aName, String someId){
		this.name = aName;
		this.id = someId;
		
	}
	
	//Κατασκευαστής που δέχετε παράμετρο μόνο το όνομα
	public Student(String aName){
		name = aName;
		id = "not defined yet";
	}
	
	// κατασκευαστής χωρίς παραμέτρους
	public Student(){
		name = "not defined yet";
		id = "not defined yet";
	}
	
	// μέθοδος εκτύπωση πληροφοριών
	public void printInfo(){
		
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
	}
	
	// μέθοδος set θέτω τιμή στις ιδιότητες μέσω παραμέτρου
	public void setName(String aName){
		
		name = aName;
	}
	
	// μέθοδος get λαμβάνω μια τιμή από την ιδιότητα
	public String getName(){
		return name;
		
	}

}