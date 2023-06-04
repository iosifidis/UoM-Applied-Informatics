
public class MainClass {

	public static void main(String[] args) {
    	// Create a registry and customers
        Registry registry = new Registry();
        Customer c1 = new Customer("Kostas", "3217", new BankAccount("GR321",Currency.EURO));
        Customer c2 = new Customer("Maria", "8854",new BankAccount("GR8889999",Currency.EURO, 100));
        Customer c3 = new Customer("Giannis", "123", new BankAccount("GR99215874",Currency.EURO, 100));
        Customer c4 = new Customer("Giannis", "666", new BankAccount("GR8841252",Currency.DOLLAR, 100));
        Customer c5 = new Customer("Apostolis", "", new BankAccount("GR8841252",Currency.DOLLAR, 100));

        // Add customers to registry
        registry.addCustomer(c1);
        registry.addCustomer(c2);
        registry.addCustomer(c3);
        registry.addCustomer(c4);
        registry.addCustomer(c5);

        // Add financial products to customers
        c1.getAccount().setFinancialProduct(new ShortTermProduct());
        c2.getAccount().setFinancialProduct(new ShortTermProduct());
        c3.getAccount().setFinancialProduct(new LongTermProduct());
        c4.getAccount().setFinancialProduct(new LongTermProduct());
        c5.getAccount().setFinancialProduct(new LongTermProduct());

        // Calculate profit
        registry.calculateProfit();
		registry.printCustomers();

	}

}
