import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Registry {
	private ArrayList<Customer> cList = new ArrayList<Customer>();
	private Map<String, Customer> cMap = new HashMap<String, Customer>();
	
	public void addCustomer(Customer c) {
		if (c.hasAFM()) {
			cMap.put(c.getAFM(), c);
		} else {
			cList.add(c);
		}
	}
	
	public void printCustomers() {
		for (int i=0; i<cList.size(); i++) {
			System.out.println(cList.get(i).toString());
		}
		
		for (String key: cMap.keySet()) {
			System.out.println(cMap.get(key).toString());
		}
	}
	
	public void calculateProfit() {
		double sum = 0.0;
		
		for (int i=0; i<cList.size(); i++) {
			sum = sum + cList.get(i).calculateProfit();
		}
		
		for (String key: cMap.keySet()) {
			sum = sum + cMap.get(key).calculateProfit();
		}
		System.out.println("Profit of all customers: " + sum);
	}
}
