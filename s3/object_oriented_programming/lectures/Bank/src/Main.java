
public class Main {

	public static void main(String[] args) {
		
		BankAccount ba1 = new BankAccount("John", 1500);
//		ba1.setName("John");
//		ba1.setBalance(1500);
		ba1.printData();
		
		SavingAccount sa1 = new SavingAccount("Mary", 1800, 0.05);
//		sa1.setName("Mary");
//		sa1.setBalance(1800);
//		sa1.printData();
//		
//		sa1.setRate(0.05);
//		sa1.addInterest();
		sa1.printData();
		

	}

}
