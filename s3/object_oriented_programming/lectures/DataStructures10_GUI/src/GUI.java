import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI extends JFrame{
	
	private JPanel panel = new JPanel();
	private JTextField input = new JTextField("add a name here");
	private JButton addButton = new JButton("Add");
	private JButton shuffleButton = new JButton("Shuffle");
	
	// Δημιουργία λίστας
	private JList list = new JList();
	
	// Τροφοδοτεί την λίστα
	private DefaultListModel<String> model = new DefaultListModel<>();
	
	// Προσθήκη μπάρας κύλισης
	private JScrollPane scrollPane;
	
	public GUI(){
		
		list.setModel(model); // Προσθέτω την δομή πάνω στην λίστα
		scrollPane = new JScrollPane(list); // Περιτυλίγει το γραφικό συστατικό list
		
		// Προσθέτω τα συστατικά στο panel
		panel.add(input);
		panel.add(addButton);
		panel.add(scrollPane); // Βάζω την λίστα+την μπάρα κύλισης στο panel
		panel.add(shuffleButton);
		
		// Προσθέτω το panel στο παράθυρο
		this.setContentPane(panel);
		panel.setBackground(Color.GREEN); //Χρώμα παραθύρου
		
		// Σύμπτυξη όλων των ενεργειών του Button
		// Δημιουργία ButtonListener
		// Συγγραφή actionPerformed
		// Κατασκευή listener
		// Σύνδεση listener με button
		addButton.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				model.addElement(input.getText()); // Παίρνω ότι έχει πληκτρολογήσει ο χρήστης και το βάζει στην λίστα
				
			}
			
			
		});
		
		// Ανώμνυμη κλάση ActionListener και πρέπει να φτιάξω την actionPerformed
		shuffleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Θέλω να ταξινομίσω την δομή λίστα (models) που δεν είναι τύπου λίστας
				//Η μέθοδος elements επιστρέφει ένα enumeration interface και η .list μου κάνει το μοντέλο τύπο λίστας
				//Πάντρεμα δομής σε μια άλλη
				ArrayList<String> namesList = Collections.list(model.elements());
				
				Collections.shuffle(namesList); // Αφού έγινε λίστα, μπορώ να εφαρμόσω μια μέθοδο shuffle
				
				model.clear(); //καθαρισμός μοντέλου
				
				// Ξαναβάζω τα στοιχεία ανακατεμένα
				for(String name: namesList)
					model.addElement(name);
				
			}
			
			
		});
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Algorithms");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
