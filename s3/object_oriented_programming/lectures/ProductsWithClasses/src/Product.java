import java.util.Scanner;

public class Product {
	
	// ιδιότητες κλάσης - attributes
	
	private String name;
	private int score;
	private double price;
	
	//κατασκευαστής - constructor
	public Product(){
		name = "";
		score = 0;
		price = 1;
	}
	
	// Λειτουργίες κλάσης -> μέθοδοι (methods)
	// Μέθοδος ανάγνωσης δεδομένων
	public void readData(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the product name: ");
		name = in.nextLine();
		System.out.println("Please enter the product price: ");
		price = in.nextDouble();
		System.out.println("Please enter the product score: ");
		score = in.nextInt();
		
	}
	
	// Μέθοδος εκτύπωσης δεδομένων
	public void printData(){
		
		System.out.println("The product is: " + name);
		System.out.println("The price is: " + price);
		System.out.println("The score is: " + score);
	}
	
	// Μέθοδος σύγκρισης δυο προϊόντων (2 αντικειμένων)
	public boolean isBetterThan(Product other){
		
		if(this.score/this.price > other.score/other.price) 
			return true;
		return false;
	}


}