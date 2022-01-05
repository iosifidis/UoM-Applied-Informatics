import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Collection<BankAccount> set = new TreeSet<BankAccount>();
		
		BankAccount BA1 = new BankAccount("001", 1500, "Papadopoulos");
		BankAccount BA2 = new BankAccount("002", 2500, "Nikolaou");
		BankAccount BA3 = new BankAccount("003", 1000, "Petrou");
		
		set.add(BA1);
		set.add(BA2);
		set.add(BA3);
		
		for(BankAccount account: set) {
			
		   System.out.println(account.getId() + ", " + 
				              account.getBalance() + ", " +
				              account.getHolderName());
		}		
	}
}

//Δημιουργώ Interface. Για να βάλω κάτι μέσα στην TreeSet πρεπεί ΥΠΟΧΡΕΩΤΙΚΑ να υλοποιεί την διασύνδεση Comparable
class BankAccount implements Comparable {
	private String id;
	private double balance;
	private String holderName;
	
	// Πρέπει να υλοποιήσω την μέθοδο του interface
	@Override
	public int compareTo(Object other) {
		BankAccount otherAccount = (BankAccount)other; // Κάνω casting BankAccount
		if(this.balance < otherAccount.balance)
			return -1; 
		else if(this.balance > otherAccount.balance)
			return 1;
		else
			return 0;
		
		// Άν ηθελα να ταξινομήσω με βάση τον id
		//return id.compareTo(otherAccount.id);
	}
	
	// Κατασκευαστής
	public BankAccount(String id, double balance, String holderName) {
		this.id = id;
		this.balance = balance;
		this.holderName = holderName;
	}

	public String getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public String getHolderName() {
		return holderName;
	}

}
