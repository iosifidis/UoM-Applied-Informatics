
public class Customer {
	private String name;
	private String afm;
	private BankAccount account;
	
	public Customer(String n, String a, BankAccount ba) {
		name = n;
		afm = a;
		account = ba;
	}

	public BankAccount getAccount() {
		return account;
	}

	public boolean hasAFM() {
		return !(afm.equals(""));
	}

	public String getAFM() {
		return afm;
	}

	public double calculateProfit() {
		return account.calculateProfit();
		//Product p = account.getProduct();
		//return p.calculateProfit();
	}
	
	public String toString() {
		return name + " " + account.toString();
	}
	
}
