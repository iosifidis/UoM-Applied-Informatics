public class BankAccount {
    private final String iban;
    private double balance;
    private final Currency currency;

    private Product financialProduct;

    public BankAccount(String iban, Currency theCurrency, double initial) {
        this.iban = iban;
        this.currency = theCurrency;
        balance = initial;
    }

    public BankAccount(String iban, Currency theCurrency) {
        this.iban = iban;
        this.currency = theCurrency;
        balance = 0.0;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit of "+amount + " NEW BALANCE = "+balance + " "+currency.getCode());
        }
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("withdraw of "+amount + " NEW BALANCE = "+balance);
        }
    }

    public String getIban() {
        return iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setFinancialProduct(Product financialProduct) {
        this.financialProduct = financialProduct;
    }

    public Product getFinancialProduct() {
        return financialProduct;
    }

    public double getBalance() {
        return balance;
    }


    public String toStringaaa() {
        return iban + " Balance = " + balance +" "+ currency.getCode();
    }
}
