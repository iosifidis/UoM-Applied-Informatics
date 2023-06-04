
public class BankAccount {
	private String iban;
	private double balance;
	private Currency currentCurrency;
	private Product currentProduct;
	
	public BankAccount(String i, Currency c, double b) {
		iban = i;
		balance = b;
		currentCurrency = c;
	}
	
	public BankAccount(String i, Currency c) {
		iban = i;
		balance = 0.0;
		currentCurrency = c;
	}	
	
	public void setFinancialProduct(Product p) {
		currentProduct = p;
	}
	
	public void deposit(double a) {
		balance = balance + a;
	}

	public void withdraw(double a) {
		balance = balance - a;
	}
	
	public String toString() {
		return "[" + iban + "], balance=" + balance;  
	}
	
	public double calculateProfit() {
		deposit(currentProduct.calculateProfit(balance));
		return currentProduct.calculateProfit(balance);
	}

}
