
public class BankAccount implements Measurable {

	private double balance;

	// Κατασκευαστής
	public BankAccount(double balance) {
		this.balance = balance;
	}

	//Αλλάζω το getBalance σε getMeasure 
	public double getMeasure() {
		return balance;
	}
	
	
	
}
