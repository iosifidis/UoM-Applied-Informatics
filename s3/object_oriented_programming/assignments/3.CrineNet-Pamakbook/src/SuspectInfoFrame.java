// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0
// Use UTF-8 encoding to view the comments

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class SuspectInfoFrame extends JFrame {
    
	// Χρώμα
	private Border grey;
    
	// Δήλωση συστατικών στοιχείων παραθύρου
	private JPanel MegaPanel , SusInfopanel , SMSpanel , Partnerspanel , SuggestedPartpanel;
	private JButton findSMSButton , ReturntoMainB;
	private JTextField SusName,SusCodeName,aNumberField;
	private JTextArea PartnersField , SuggPartField , SMSField , PhoneField;
	private JLabel SuspLabel , SuggPartnersLabel;
	
	// Δηλώνω ιδιότητα τύπου Registry που δεν δείχνει πουθενά. Θέλω να δείχνει στην registry που πήρα από το SearchFrame.
	private Registry registryC;
	// Και ιδιότητα τύπου int, η θέση του υπόπτου στην Registry.
	int position;
	
	public SuspectInfoFrame(Registry r, String name, int pos) {

		registryC=r; // Γεφυρώνω τα 2 παράθυρα (την registry που έλαβα από την SearchFrame) 
		this.position=pos; // Γεφυρώνω την θέση που έλαβα από την SearchFrame με το κυρίως παράθυρο 
		
		MegaPanel=new JPanel(); // Φτιάχνω ένα νέο αντικείμενο, το μεγάλο panel του παράθυρο
		
		// Panel υπόπτου (όνομα, alias, τηλέφωνα)
		SusInfopanel = new JPanel();
		SusName = new JTextField(name); // Πεδίο κειμένου (όνομα) 
		SusCodeName = new JTextField(registryC.getSuspects().get(pos).getCodeName()); // Πεδίο κειμένου (alias)

		// Πεδίο με τηλέφωνα
		PhoneField = new JTextArea();
		String numbersOfSus = "";
		for(int i=0; i<registryC.getSuspects().get(pos).getListOfNumbers().size(); i++) {
			numbersOfSus += registryC.getSuspects().get(pos).getListOfNumbers().get(i).toString() + "\n" ;
		}
		
		PhoneField.append(numbersOfSus); // Προσθήκη των αριθμών στο συστατικό πεδίο κειμένου		
		
		// Προσθήκη των συστατικών στο panel υπόπτου
		SusInfopanel.add(SusName);
		SusInfopanel.add(SusCodeName);
		SusInfopanel.add(PhoneField);
		
		// Χρωματισμός, μέγεθος κλπ του panel
		PhoneField.setPreferredSize(new Dimension(130,80));
		grey=BorderFactory.createLineBorder(Color.gray,1);
		SusInfopanel.setBorder(grey);
	
		//Panel με SMS του υπόπτου με τον αριθμό τηλεφώνου που εισάγουμε
		SMSpanel = new JPanel(); // Δημιουργία Panel
		aNumberField = new JTextField(10); // Πεδίο εισαγωγής αριθμού που αναζητούμε
		SMSField = new JTextArea(); // Πεδίο κειμένου των μηνυμάτων
		findSMSButton = new JButton("Find SMS"); // Πλήκτρο για αναζήτηση
		
		// Προσθήκη των συστατικών στοιχείων στο panel
		SMSpanel.add(aNumberField);
		SMSpanel.add(SMSField);
		SMSpanel.add(findSMSButton);
		
		// Χρωματισμός panel και μέγεθος πεδίου
		SMSpanel.setBorder(grey);
		SMSField.setPreferredSize(new Dimension(200,150));
		
		// Δήλωση ButtonListener και προσθήκη του στο πλήκτρο findSMSButton
		FindSmsButtonListener findlistener= new FindSmsButtonListener();
		findSMSButton.addActionListener(findlistener);
		
		//Panel πιθανών συνεργατών του υπόπτου
		Partnerspanel = new JPanel(); // Δημιουργία panel
		SuspLabel = new JLabel("Partners"); // Δημιουργία συστατικού ετικέτας
		PartnersField = new JTextArea(); // Δημιουργία συστατικού πεδίου εμφάνισης πιθανών συνεργατών
		
		Collection<String> posPartList = new TreeSet<String>(); // Φτιάχνω ένα TreeSet για να τους βάλω αλφαβητικά
		
		for(int i=0;i<registryC.getSuspects().get(pos).getListOfAssociates().size();i++) {
			// Προσθέτω όλους τους πιθανούς αλφαβητικά
			posPartList.add(registryC.getSuspects().get(pos).getListOfAssociates().get(i).getName() +"," + registryC.getSuspects().get(pos).getListOfAssociates().get(i).getCodeName()  + "\n");
		}
		
		Collection<String> noDups = new HashSet<String>(posPartList); // Φτιάχνω ένα HashSet για να βγάλω τα διπλά και βάζω το TreeSet
		for(String ps : noDups)
		{
		    PartnersField.append(ps); // Προσθέτω στο πεδίο τα ονόματα
		}

		// Προσθήκη των συστατικών στοιχείων στο panel
		Partnerspanel.add(SuspLabel);
		Partnerspanel.add(PartnersField);
		// Χρωματισμός και μέγεθος panel
		Partnerspanel.setBorder(grey);
		PartnersField.setPreferredSize(new Dimension(200,150));
		
		
		//Panel προτεινόμενων πιθανών συνεργατών υπόπτου
		SuggestedPartpanel = new JPanel(); // Δημιουργία Panel
		SuggPartnersLabel = new JLabel("Suggested Partners ----->"); // Δημιουργία συστατικού ετικέτας
		SuggPartField = new JTextArea(); // Συστατικό για εμφάνιση των ονομάτων
		
		Collection<String> sugPosPartList = new TreeSet<String>(); // Φτιάχνω ένα TreeSet για να τους βάλω αλφαβητικά

		for(int i=0;i<registryC.getSuspects().get(pos).getSuggestedPossiblePartners().size();i++) {
			// Προσθέτω όλους τους πιθανούς αλφαβητικά
			posPartList.add(registryC.getSuspects().get(pos).getSuggestedPossiblePartners().get(i).getName()+"\n");
		}

		Collection<String> noSugDups = new HashSet<String>(sugPosPartList);// Φτιάχνω ένα HashSet για να βγάλω τα διπλά και βάζω το TreeSet
		for(String sps : noSugDups)
		{

			SuggPartField.append(sps); // Προσθέτω στο πεδίο τα ονόματα
		}

		// Προσθήκη των συστατικών στοιχείων στο panel
		SuggestedPartpanel.add(SuggPartnersLabel);
		SuggestedPartpanel.add(SuggPartField);
		
		// Χρωματισμός και μέγεθος panel
		SuggestedPartpanel.setBorder(grey);
		SuggPartField.setPreferredSize(new Dimension(200,150));
		
		//Προσθήκη όλων panels στο κεντρικό panel
		MegaPanel.add(SusInfopanel);
		MegaPanel.add(SMSpanel);
		MegaPanel.add(Partnerspanel);
		MegaPanel.add(SuggestedPartpanel);
		
		// Δημιουργία κουμπιού επιστροφής και προσθήκη του στο κεντρικό panel
		ReturntoMainB= new JButton("Back to Search Screen");
		MegaPanel.add(ReturntoMainB);
		
		// Δήλωση ButtonListener και προσθήκη του στο πλήκτρου επιστροφής στην οθόνη αναζήτησης
		ReturnButtonListener listener = new ReturnButtonListener();
		ReturntoMainB.addActionListener(listener);
		
		
		// Προσθήκη του κεντρικού panel (με όλα τα υπο-panel) στο παράθυρο
		this.setContentPane(MegaPanel);
		
		// Δημιουργία του παραθύρου
		this.setTitle("Suspect Page");
		this.setSize(440,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	// Δημιουργία κλάσης Ακροατή για το πλήκτρο ReturntoMainB για επιστροφή στην οθόνη αναζήτησης
	class ReturnButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				new SearchFrame(registryC);
				SuspectInfoFrame.this.dispose();
			
			}
		}
	
	// Δημιουργία κλάσης Ακροατή για το πλήκτρο findSMSButton για επιστροφή στην οθόνη αναζήτησης
	class FindSmsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String numberGiven = aNumberField.getText(); // Παίρνω τον αριθμό που εισήχθη
			ArrayList<SMS> messages = new ArrayList<SMS>(); // Φτιάχνω ένα αντικείμενο λιστας τύπου μυνημάτων SMS
			
			//Προσθέτω στην λίστα τα μηνύματα που ανταλλάξανε ο ύποπτος (και ότι αριθμούς έχει) με το συγκεκριμένο νούμερο.
			for(int i=0; i<registryC.getSuspects().get(position).getListOfNumbers().size(); i++){
				messages.addAll(registryC.getMessagesBetween(registryC.getSuspects().get(position).getListOfNumbers().get(i).toString(), numberGiven));
			 }
			
			// Δημιουργία ενός αντικεμένου String με όλα τα μηνύματα
			String allMess = "";
			for(int i=0; i<messages.size(); i++)
				allMess += messages.get(i).getSMS() + "\n";
			
			// Προσθήκη του αντικειμένου με τα μηνύματα στο panel
			SMSField.setText(allMess);
		
		}					
					
	}
}
