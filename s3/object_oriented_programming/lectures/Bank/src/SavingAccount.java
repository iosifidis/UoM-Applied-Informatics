
public class SavingAccount extends BankAccount {
	
	private double interestRate;
	

	public SavingAccount(String aName, double aBalance, double aRate){
		// Κλήση καταασκευαστή υπερκλάσης και μεταβίβαση των 2 παραμέτρων
		// ΠΑΝΤΑ καλώ τον κατασκευαστή της υπερκλάσης
		super(aName, aBalance);
		interestRate = aRate;
	}
	
	public void setRate(double amount){
		interestRate = amount;
	}
	
	public void addInterest(){
		balance += balance * interestRate;
	}
	
	// επαναορισμός ή επικάλυψη (override) μεθόδου υπερκλάσης
	public void printData(){
		//κλήση μεθόδου υπερκλάσης
		//super.printData();
		System.out.println("This is a savings bankaccount");
		System.out.println("Name: " + name);
		System.out.println("Balance: " + balance);
		System.out.println("Interest rate: " + interestRate);
	}

}
