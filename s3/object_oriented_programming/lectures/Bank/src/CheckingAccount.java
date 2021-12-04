
public class CheckingAccount extends BankAccount {
	
	public int transactionsCounter;

	public CheckingAccount(String aName, double aBalance) {
		super(aName, aBalance);
		transactionsCounter = 0;
	}
	
	public void deposit(double amount){
		// κλήση μεθόδου υπερκλάσης από την υποκλάση
		super.deposit(amount);		
		transactionsCounter++;
		if(transactionsCounter >=3)
			balance -=0.5;
	}
}
