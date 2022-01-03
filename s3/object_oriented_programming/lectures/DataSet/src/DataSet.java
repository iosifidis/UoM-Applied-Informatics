
public class DataSet {
	
	// Για ΔΙΕΠΑΦΗ
	
	private int counter;
	private double sum;
	
	// Είναι reference προς μια κλάση Measurable
	private Measurable maximum;
	private Measurable minimum;
	
	public DataSet(){
		//Έναν ακέραιο, double αν δεν τα αρχικοποιήσω, θα έχουν τιμή 0. 
		//Οπότε ψιλοάχρηστο. Πιο πολύ για τον προγραμματιστή είναι αυτό
		counter=0;
		sum=0;
		maximum = null;
		minimum = null;
	}
	
	// Μέθοδος add Measurable
	public void add(Measurable item){
		
		sum += item.getMeasure();
		
		if(counter == 0 || item.getMeasure() > maximum.getMeasure())
			// maximum και item είναι αναφορές, 
			//οπότε maximum δείχνει Measurable με μεγαλύτερο υπόλοιπο
			maximum = item;
		
		if(counter == 0 || item.getMeasure() < minimum.getMeasure())
			minimum = item;
			
		counter++;	
		
	}
	
	public double getAverage(){
		if(counter == 0)
			return 0;
		return sum/counter;
	}
	
	public Measurable getMaximum(){
		return maximum;
	}
	
	public Measurable getMinimum(){
		return minimum;
	}
	
	
	// Για Student
//	
//	private int counter;
//	private double sum;
//	
//	// Είναι reference προς μια κλάση Student
//	private Student maximum;
//	private Student minimum;
//	
//	public DataSet(){
//		//Έναν ακέραιο, double αν δεν τα αρχικοποιήσω, θα έχουν τιμή 0. 
//		//Οπότε ψιλοάχρηστο. Πιο πολύ για τον προγραμματιστή είναι αυτό
//		counter=0;
//		sum=0;
//		maximum = null;
//		minimum = null;
//	}
//	
//	public void add(Student item){
//		
//		sum += item.getGPA();
//		
//		if(counter == 0 || item.getGPA() > maximum.getMeasure())
//			// maximum και item είναι αναφορές, 
//			//οπότε maximum δείχνει στον φοιτητή με μεγαλύτερο υπόλοιπο
//			maximum = item;
//		
//		if(counter == 0 || item.getMeasure() < minimum.getMeasure())
//			minimum = item;
//			
//		counter++;	
//		
//	}
//	
//	public double getAverage(){
//		if(counter == 0)
//			return 0;
//		return sum/counter;
//	}
//	
//	public Student getMaximum(){
//		return maximum;
//	}
//	
//	public Student getMinimum(){
//		return minimum;
//	}
	
	
	// Για το BankAccount
	
//	private int counter;
//	private double sum;
//	// Είναι reference προς μια κλάση BankAccount
//	private BankAccount maximum;
//	private BankAccount minimum;
//	
//	public DataSet(){
//		//Έναν ακαίρεο, double αν δεν τα αρχικοποιήσω, θα έχουν τιμή 0. 
//		//Οπότε ψιλοάχρηστο. Πιο πολύ για τον προγραμματιστή είναι αυτό
//		counter=0;
//		sum=0;
//		maximum = null;
//		minimum = null;
//	}
//	
//	public void add(BankAccount item){
//		
//		sum += item.getBalance();
//		
//		if(counter == 0 || item.getBalance() > maximum.getBalance())
//			// maximum και item είναι αναφορές, 
//			//οπότε maximum δείχνει στον τραπεζικό λογαριασμό με μεγαλύτερο υπόλοιπο
//			maximum = item;
//		
//		if(counter == 0 || item.getBalance() < minimum.getBalance())
//			minimum = item;
//			
//		counter++;	
//		
//	}
//	
//	public double getAverage(){
//		if(counter == 0)
//			return 0;
//		return sum/counter;
//	}
//	
//	public BankAccount getMaximum(){
//		// Επιστρέφει τραπεζικό λογαριασμό
//		return maximum;
//	}
//	
//	public BankAccount getMinimum(){
//	// Επιστρέφει τραπεζικό λογαριασμό
//		return minimum;
//	}
}
