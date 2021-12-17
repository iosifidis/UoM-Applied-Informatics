import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContainerFrame extends JFrame {

	//1. Δημιουργία του panel
	private JPanel panel = new JPanel();
	
	//2. Δημιουργία γραφικών συστατικών
	private JTextField codeField = new JTextField("Enter code");
	private JTextField destinationField = new JTextField("Enter destination");
	private JTextField weightField = new JTextField("Enter weight");
	private JTextField powerField = new JTextField("Enter power");
	private JButton createBulkButton = new JButton("Create Βulk");
	private JButton createRefrField = new JButton("Create Refr");
	private JList list = new JList();
	
	//Δηλώνω ιδιότητα που δεν δείχνει πουθενά. Θέλω να δείχνει σε όλα τα πλοία. Θα το συνδέσω στον κατασκευαστή
	private ArrayList<Ship> allShips;
	
	//Δομή δεδομένων model για χρήση στην λίστα
	private DefaultListModel model = new DefaultListModel();
	
	//Μου στέλνει η Main τις "διευθύνσεις" των αντικειμένων της λίστας. Η χρήση της ships μέσα στον κατασκευαστή
	public ContainerFrame(ArrayList<Ship> ships){
		
		//Ανάθεση στην ιδιότητα που δημιούργησα να δείχνει στην λίστα που πήρα από την Main
		//Γεφύρωσα το χάσμα της γραφικής διασύνδεσης με τα αντικείμενα της main 
		allShips = ships;
		
		// Εισαγωγή κειμένου επιλογών στην λίστα
		// Διατρέχω όλα τα πλοία
		for(Ship ship: allShips)
			model.addElement(ship.getName());
		
		// Εισαγωγή του model στην λίστα
		list.setModel(model);
		
		//3. Εισαγωγή γραφικών συστατικών στο panel
		panel.add(codeField);
		panel.add(destinationField);
		panel.add(weightField);
		panel.add(powerField);
		panel.add(createBulkButton);
		panel.add(createRefrField);
		panel.add(list);
		
		//Προσθήκη στοιχείων στην λίστα
		
		
		//4. Προσαρμογή του panel πάνω στο παράθυρο
		this.setContentPane(panel);
		
		// Δημιουργώ ακροατή (βήμα 3ο)
		ButtonListener listener = new ButtonListener();
		
		//Σύνδεση με τον ακροατή συμβάντων (βήμα 4)
		createBulkButton.addActionListener(listener);
		createRefrField.addActionListener(listener);
		
		
		//Δημιουργία παραθύρου
		this.setVisible(true);
		this.setSize(200,400);
		this.setTitle("Create and Load Containers");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

	
	// Δημιουργία κλάσης Ακροατή (βήμα 1)
	class ButtonListener implements ActionListener{

		
		
		
		//2. Μέθοδος που θα εκτελείται όταν πατάμε το πλήκτρο
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//Παίρνω όνομα πλοίου και προορισμό
			String code = codeField.getText();
			String destination = destinationField.getText();
			
			//Παίρνουμε το πλοίο που επέλεξε ο χρήστης
			String selectedShipName = (String)list.getSelectedValue(); // Η getSelectedValue επιστρέφει object οπότε το κάνω String
			
			//Πρέπει να βρω το πλοίο που έχει αυτό το όνομα
			Ship selectedShip = null;
			
			for(Ship ship: allShips) // Διατρέχω την λίστα των πλοίων που έχω πάρει από την main
				if(ship.getName().equals(selectedShipName))
					selectedShip = ship;
			
			// Δημιουργώ το container για να μην παραπονιέται μετά την if/else
			Container container;
			
			// Πρέπει να καταλάβω ποιο πλήκτρο πατήθηκε
			if(arg0.getSource().equals(createBulkButton) ){ // Αν πατήθηκε το createBulkButton
				
				// Διαβάζω δεδομένα				
				String weightText = weightField.getText();
				double weight = Double.parseDouble(weightText); // Αλλάζω το string σε double
				//Φτιάχνω το container με τα δεδομένα που εισήγαγε ο χρήστης
				container = new Bulk(code, destination, weight);
				
								
			}
			else {// Αν πατήθηκε το createRefrField
				String powerText = powerField.getText();
				double power = Double.parseDouble(powerText);
				container = new Refrigirator(code,destination,power);
				
			}
			
			// Βρήκα το πλοίο και του προσθέτω το container
			selectedShip.addContainer(container); // Πρέπει να δηλώσω το container πριν το if/else
			// Εκτυπώνω 
			System.out.println("Total charge of ship " + selectedShipName + " is: " + selectedShip.calculateTotalCharge());
		}
		
		
		
	}
	
	
	
}
