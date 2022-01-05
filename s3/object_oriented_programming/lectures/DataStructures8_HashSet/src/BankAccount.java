
public class BankAccount {
	
	private double balance;
	private String code;
	
	public BankAccount(double balance, String code) {
		this.balance = balance;
		this.code = code;
	}

	public double getBalance() {
		return balance;
	}

	public String getCode() {
		return code;
	}
	
	
	// Όταν φτιάχνω μια κλάση και θέλω να εισάγω τα αντικείμενά της σε μια HashSet, πέρπει να επικαλύψω την hashcode
	// Επικάλυψη της hashCode για να καταλάβει και να βάλει τους λογαριασμούς σε ίδια θέση 
	// αφού έχουν ίδιο κωδικό και υπόλοιπο. Άρα πρέπει να εφαρμόσει το hashCode πάνω στο code που είναι ίδιο.
	public int hashCode() {
		return code.hashCode();
	}
	
	// Πρέπει να επικαλύψω και την equals μαζί με την hashCode.
	public boolean equals(Object other) {
		BankAccount otherAccount = (BankAccount)other;
		if(this.code.equals(otherAccount.code))
			return true;
		else
			return false;
	}
}
