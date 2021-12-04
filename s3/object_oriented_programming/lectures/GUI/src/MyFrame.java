import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	
	// Έχω κάνει ιδιότητα ένα γραφικό συστατικό (το κείμενο) 
	//ώστε να είναι ορατό σε όλη την κλάση
	private JTextField textField;
	private JTextField outputTextField = new JTextField(20);
	
	//Κατασκευαστής κλάσης
	public MyFrame(){
		
		//Βήμα 1. Δημηουργία υποδοχέα
		//Ότι ξεκινάει από J είναι αντικείμενο της swing
		JPanel panel = new JPanel();
		//Θέτουμε χρώμα background
		panel.setBackground(Color.DARK_GRAY);
		//Προσθήκη εικόνας
		ImageIcon icon = new ImageIcon("xmas_holidays.jpg");
		JLabel label = new JLabel(icon);
		
		//Βήμα 2. Δημιουργία γραφικών συστατικών
		textField = new JTextField(10);
		JButton button = new JButton("Press Me!");
		
		//Βήμα 3. Τοποθέτηση γραφικών συστατικών στον υποδοχέα
		panel.add(textField);
		panel.add(button);
		
		//Προσθήκη για να εμφανίζεται στην γραφική διεπαφή
		panel.add(outputTextField);
		
		//Προσθήκη εικόνας
		panel.add(label);
		
		//Βήμα 4. Προσαρμογή υποδοχέα στο παράθυρο
		this.setContentPane(panel);
		
		//EH. Βήμα 3. Προσαρμογή υποδοχέα στο παράθυρο
		ButtonListener listener = new ButtonListener();
		
		//ΕΗ. Βήμα 4. Σύνδεση ακροατή με πηγή συμβάντων
		button.addActionListener(listener);
	}
	
	// EH. Βήμα 1. Φτιάχνω μια εσωτερική κλάση. Δημιουργία κλάσης ακροατή
	// Εκτελεί μια ενέργεια με το πάτημα ενός πλήκτρου
	// Την μέθοδο την καλεί η Java. ActionListener είναι μια διασύνδεση (έχει μια μέθοδο)
	// Πρόσθέτω την μέθοδο της ActionListener πατώντας πάνω στο ButtonListener
	class ButtonListener implements ActionListener{

		//ΕΗ. Βήμα 2. Συγγραφή του εκτελούμενου κώδικα
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String userName = textField.getText();
			//System.out.println("Hello my friend " + userName);
			outputTextField.setText("Hello " + userName);
		}
		
	}
	
	
	

}
