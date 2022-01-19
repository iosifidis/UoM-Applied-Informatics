import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {

	private JPanel panel = new JPanel(); // Πάνελ
	private JButton openFileButton = new JButton("Open File"); // Κουμπί
	private JFileChooser fc = new JFileChooser(); // Γραφικό συστατικό επιλογής αρχείου
	
	public GUI(){
		
		panel.add(openFileButton);
		this.setContentPane(panel);
		
		//Δημιουργώ ανώνυμη κλάση και το interface που την υλοποιεί...
		openFileButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Ανοίγει το παράθυρο του FileChooser
				//Μητρικό παράθυρο panel
				//Επιστρεφόμενη ακέραια τιμή στο returnValue
				int returnValue = fc.showOpenDialog(panel);
				
				// Αν επέλεξε το open, τότε επέλεξα να ανοίξει το αρχείο
				if(returnValue == JFileChooser.OPEN_DIALOG){
					//κώδικας για ανάγνωση αρχείο κειμένου
					
					// Λήψη αρχείου
					File file = fc.getSelectedFile();

					//Περιτυλίγει το FileReader που περιτυλίγει το file
					//Αποδοτικό. Παίρνει μεγάλα κομμάτια από το αρχείο και η προσπέλαση στο δίσκο γίνεται πιο αραιά (γρήγορος)
					// Παράγεται εξαίρεση (διότι έχουμε αρχείο)
					try {
						BufferedReader reader = new BufferedReader(new FileReader(file));
						
						//Διαβάζω και μπορεί να εμφανίσει εξαίρεση. Προσθέτω ένα catch ακόμα
						String line = reader.readLine(); // Διαβάζει γραμμή ολόκληρη...
						while(line!=null){
							System.out.println(line);
							line = reader.readLine();
						}
						
						reader.close(); // κλείνω το ρεύμα
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
			
		});
		
		
		this.setVisible(true);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
