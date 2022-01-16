// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0
// Use UTF-8 encoding to view the comments

import java.util.ArrayList;

public class Suspect {
	
	//Δήλωση ιδιοτήτων υπόπτου Suspect 
	String name;
	String alias;
	String town;
	
	//Δημιουργία λιστών
	ArrayList<String> numbers = new ArrayList<String>(); //Λίστα αριθμών τηλεφώνων που χρησιμοποιεί ο ύποπτος
	ArrayList<Suspect> possiblePartners = new ArrayList<Suspect>(); //Λίστα των πιθανών συνεργατών υπόπτου
	ArrayList<Suspect> commonPartners = new ArrayList<Suspect>(); //Λίστα με κοινούς πιθανούς συνεργάτες
	
	//Κατασκευαστής
	public Suspect(String name, String alias, String town){
		this.name = name;
		this.alias = alias;
		this.town = town;
	}
	
	//Μέθοδοι
	
	//Πρόσθεση αριθμού στην λίστα των αριθμών του υπόπτου.
	public void addNumber(String number) {
		numbers.add(number); 
	}
	
	//Προσθέτει τον ύποπτο στην λίστα άλλου υπόπτου των πιθανών συνεργατών
	public void addSuspect(Suspect aSuspect) {
		
		boolean flag = false;
		for(int i=0; i<possiblePartners.size(); i++) {
			if(!possiblePartners.get(i).equals(aSuspect) && flag==false) {
				possiblePartners.add(aSuspect);
				flag=true;
			}
		}
	} 
	
	//Έλεγχος εάν δυο ύποπτοι είναι συνδεδεμένοι.
	public boolean isConnectedTo(Suspect aSuspect) { 
		
		if(possiblePartners.contains(aSuspect))
			return true;
		else 
			return false;
	}
	
	//Επιστρέφει μια λίστα με όλους τους κοινούς συνεργάτες των δυο υπόπτων
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect) {
		
		for(int i=0;i<possiblePartners.size();i++) {
				if(possiblePartners.get(i).isConnectedTo(aSuspect) && !commonPartners.contains(possiblePartners.get(i))) {
				
					commonPartners.add(possiblePartners.get(i));
				
				}
		}
		
		return commonPartners;
	}
	
	// Εκτύπωση της λίστας των πιθανών συνεργατών
	public void printInfo(Suspect aSuspect){
		for(int i=0; i<possiblePartners.size();i++) 
			System.out.println(possiblePartners.get(i).name + ", " + possiblePartners.get(i).alias);
	}
	
	// Μέθοδος getName
	public String getName() {
		return name;
	}
	
	//Μέθοδος getCodeName
	public String getCodeName() {
		return alias;
	}
		
}
