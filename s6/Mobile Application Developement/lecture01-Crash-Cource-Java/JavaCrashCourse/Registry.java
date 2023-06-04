import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registry {
    private Map<String,  Customer> customerMap;
    private List<Customer> customerList;

    public Registry() {
        customerMap = new HashMap<>();
        this.customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        String afm = customer.getAfm();
        if(customerMap.containsKey(afm)){
            System.out.println("Customer with AFM "+afm +" already exists !");
        }
        else {
            customerList.add(customer);
            customerMap.put(afm, customer);
        }
    }

    public int customersCount(){
        return customerList.size();
    }

    public void calculateProfit(){
        double totalProfit = 0.0;
        for(Customer customer : customerList){
            BankAccount account = customer.getAccount();
            Product financialProduct = account.getFinancialProduct();
            double profit = financialProduct.calculateProfit(account.getBalance());
            System.out.println("Profit for customer "+customer.getName()+" = "+profit);
            account.deposit(profit);
            totalProfit += profit;
        }
        System.out.println("TOTAL PROFIT = "+totalProfit);
    }


    public void printCustomers(){
        for(Customer customer : customerList){
            System.out.println(customer);
        }

        System.out.println("==== TOTAL "+customersCount() + " CUSTOMERS ====");
    }
}
