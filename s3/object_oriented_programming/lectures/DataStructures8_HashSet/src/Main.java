import java.util.HashSet;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		
		BankAccount BA1 = new BankAccount(1500, "001");
		BankAccount BA2 = new BankAccount(1500, "001");
		
		HashSet<BankAccount> hashSet = new HashSet<BankAccount>();
		
		hashSet.add(BA1);
		hashSet.add(BA2);
		
//		for(BankAccount account: hashSet)
//			System.out.println(account.getCode() + ", " 
//					           + account.getBalance()); 

		Iterator iter = hashSet.iterator();
		
		while(iter.hasNext()){
			BankAccount account = (BankAccount)iter.next();
			System.out.println(account.getCode() + ", " + account.getBalance());
		
		}	
		
	}

}
