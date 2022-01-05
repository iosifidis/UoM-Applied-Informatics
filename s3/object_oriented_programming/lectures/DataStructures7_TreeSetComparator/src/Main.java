import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		AccountNameComparator myComparator = new AccountNameComparator();
		
		// Η TreeSet δέχεται ως παράμετρο έναν εξωτερικό συγκριτή (ένα αντικείμενο τύπου Comparator)
		// ΜΟΝΟ ένας συγκριτής κάθε φορά. Αλλιώς πρέπει να τον αλλάζω.
		Collection<BankAccount> set = new TreeSet<BankAccount>(myComparator);
		
		BankAccount BA1 = new BankAccount("001", 1500, "Papadopoulos");
		BankAccount BA2 = new BankAccount("002", 2500, "Nikolaou");
		BankAccount BA3 = new BankAccount("003", 1000, "Petrou");
		
		set.add(BA1);
		set.add(BA2);
		set.add(BA3);
		
		for(BankAccount account: set) {
			
		   System.out.println(account.getId() + ", " + 
				              account.getBalance() + ", " +
				              account.getHolderName());
		}	
	}
}

class BankAccount {
	private String id;
	private double balance;
	private String holderName;	
	
	public BankAccount(String id, double balance, String holderName) {
		this.id = id;
		this.balance = balance;
		this.holderName = holderName;
	}

	public String getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public String getHolderName() {
		return holderName;
	}

}

//Εξωτερικός συγκριτής βάση τραπεζικού Κωδικού
class AccountCodeComparator implements Comparator<BankAccount> {
	
	public int compare(BankAccount account1, BankAccount account2) {
		String code1 = account1.getId();
		String code2 = account2.getId();
		
		return code1.compareTo(code2);
	}
}

//Εξωτερικός συγκριτής βάση ιδιοκτήτη λογαριασμού
class AccountNameComparator implements Comparator<BankAccount> {
	
	public int compare(BankAccount account1, BankAccount account2) {
		String name1 = account1.getHolderName();
		String name2 = account2.getHolderName();
		
		return name1.compareTo(name2);
	}
}


