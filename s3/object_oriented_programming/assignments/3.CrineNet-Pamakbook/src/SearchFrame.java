// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0
// Use UTF-8 encoding to view the comments

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchFrame extends JFrame {
	
	// Δήλωση συστατικών στοιχείων παραθύρου
	private JPanel panel = new JPanel(); // Δημιουργία νέου panel
	private JTextField susName = new JTextField("Please enter a suspect's name"); //Εισαγωγή ονόματος υπόπτου για εύρεση	
	private JButton findButton = new JButton("Find"); //Πήλκτρο Find για εύρεση υπόπτου
	
	//Δηλώνω ιδιότητα που δεν δείχνει πουθενά. Θέλω να δείχνει στην registry που πήρα από την main. 
	private Registry newr;
	// Από την registry, θέλω να πάρω ΜΟΝΟ τα ονόματα των υπόπτων. Θα το συνδέσω όλα στον κατασκευαστή
	private ArrayList<Suspect> someSuspects; 
	
	public SearchFrame (Registry r) {
		
		newr=r; // Γεφυρώνω την registry που έλαβα από την main με την γραφική διεπαφή 
		someSuspects=r.allSuspects; // Από την registry, παίρνω μόνο τους υπόπτους
		
		// Προσθήκη των συστατικών στο panel
		panel.add(susName);
		panel.add(findButton);
		
		// Δήλωση ButtonListener και προσθήκη του στο πλήκτρο findButton
		ButtonListener listener = new ButtonListener();
		findButton.addActionListener(listener);
		
		// Προσθήκη του panel στο παράθυρο
		this.setContentPane(panel);
		
		// Δημιουργία παραθύρου
		this.setSize(350, 150);
		this.setTitle("Find Suspect");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	}
	
	// Δημιουργία κλάσης Ακροατή για το πλήκτρο Find
	class ButtonListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			String aName= susName.getText();
			boolean exists=false;
			for(int i=0;i<someSuspects.size();i++) {	
				if(aName.equals(someSuspects.get(i).getName())) {
					new SuspectInfoFrame(newr,aName,i);
					SearchFrame.this.dispose();
					exists=true;
				}
	         }
			if(exists==false) {
				JOptionPane.showMessageDialog(null,"Suspect " +aName + " Not Found."); 
				}
		}
	}
}
