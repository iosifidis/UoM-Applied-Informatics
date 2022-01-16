import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		// Δομή map με όνομα και λίστα με βιβλία
		HashMap<String, ArrayList<Book>> library = new HashMap<>();
		
		// Δημιουργία λίστας βιβλίων του John
		ArrayList<Book> johnsBooks = new ArrayList<>();
		
		johnsBooks.add(new Book("The Alchemist"));
		johnsBooks.add(new Book("The chatcher in the Rye"));
		
		// Δημιουργία λίστας βιβλίων της Mary
		ArrayList<Book> marysBooks = new ArrayList<>();
		
		marysBooks.add(new Book("Ti mas kryvoyn"));
		marysBooks.add(new Book("Giati mas psekazoun?"));
		
		// Προσθήκη των λιστών στο hashmap και αντοιστοιχία των κλειδιών
		library.put("John", johnsBooks);
		library.put("Mary", marysBooks);
		
		// Εκτύπωση
		for(String member : library.keySet()){
			System.out.println(member + " has borrowed the following books");
			ArrayList<Book> books = library.get(member);
			for(Book book: books)
				System.out.println(book.getTitle());
			System.out.println("---------------");
			
		}
		
		
	}
}

class Book {
	
	private String title;
	
	public Book(String title) {
		
		this.title = title;
	}
	
	public String getTitle(){
		
		return title;
	}
	
}
