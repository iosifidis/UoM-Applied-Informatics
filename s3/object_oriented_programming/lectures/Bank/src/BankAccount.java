
public class BankAccount {
	
	// public = ορατή στις υποκλάσεις αλλά όχι στον υπόλοιπο κόσμο
	// ενώ κληρονομείται στην SavingAccount δεν είναι προσβάσιμη μέσα σε αυτήν
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
