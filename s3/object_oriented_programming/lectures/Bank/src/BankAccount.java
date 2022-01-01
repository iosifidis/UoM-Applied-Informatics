
public class BankAccount {
	
	// public = ορατή στις υποκλάσεις αλλά όχι στον υπόλοιπο κόσμο. Δεν επιτρέπεται πρόσβαση και αλλαγή τιμής.
	// protected = υποδηλώνει ότι μια ιδιότητα δεν είναι προσπελάσιμη από αντικείμενα άλλων κλάσεων, 
	// επιτρέπεται όμως η πρόσβαση από αντικείμενα των υποκλάσεων.
	
	// εδώ κληρονομείται στην SavingAccount και είναι προσβάσιμη μέσα σε αυτήν
	protected String name;
	protected double balance;
	
	public BankAccount(String aName, double aBalance){
		name = aName;
		balance = aBalance;
	}
	
	public void printData(){
		System.out.println("This is the regular bankaccount");
		System.out.println("Name: " + name);
		System.out.println("Balance: " + balance);
	}
	
	public void deposit(double amount){
		balance += amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
