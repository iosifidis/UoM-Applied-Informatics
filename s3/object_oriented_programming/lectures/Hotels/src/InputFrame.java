import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputFrame extends JFrame {
	
	private JPanel panel;
	private JPanel diamoniPanel;
	private JPanel allInclusivePanel;
	private JPanel buttonPanel;
	
	private JLabel diamoniLabel;
	private JLabel hotelLabel;
	private JLabel allInclusiveLabel;
	
	private JList<String> listView;
	private DefaultListModel model;
	
	private JTextField daysField;
	private JTextField mealsField;
	
	private JButton storeButton;
	private JButton calculateCostButton;
	
	private JTextField costField;
	private ArrayList<Hotel> hotels;
	
	public InputFrame() {
		
		panel = new JPanel();
		diamoniPanel = new JPanel();
		allInclusivePanel = new JPanel();
		buttonPanel = new JPanel();	
		
		listView = new JList<String>();
		model = new DefaultListModel<String>();
		
		//Ανάγνωση ξενοδοχείων από αρχείο
		File file = new File("hotels.ser");
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			hotels	= (ArrayList<Hotel>)in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Προσθήκη ξενοδοχείων
		Collections.sort(hotels);
		for(Hotel hotel: hotels)
			model.addElement(hotel.getName());

		
		listView.setModel(model);
		
		diamoniLabel = new JLabel("Stoixeia Diamonis");
		hotelLabel = new JLabel("Hotel");
		allInclusiveLabel = new JLabel("AllInclusive");
		
		daysField = new JTextField("Hmeres Diamonis");
		mealsField = new JTextField("Plithos Geumatwn (1,2,3)");
		costField = new JTextField("Synoliko Kostos");
		
		storeButton = new JButton("Apothikeusi Kratisis");
		calculateCostButton = new JButton("Ypologismos Kostous");
		
		diamoniPanel.setLayout(new BoxLayout(diamoniPanel, BoxLayout.Y_AXIS));
		diamoniLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(diamoniLabel);
		hotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(hotelLabel);
		diamoniPanel.add(listView);
		diamoniPanel.add(daysField);
		diamoniPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		allInclusivePanel.setLayout(new GridLayout(2,0));
		allInclusivePanel.add(allInclusiveLabel);
		allInclusivePanel.add(mealsField);
		allInclusivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		buttonPanel.setLayout(new GridLayout(2,0));
		buttonPanel.add(storeButton);
		buttonPanel.add(calculateCostButton);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		panel.add(diamoniPanel);
		panel.add(allInclusivePanel);
		panel.add(buttonPanel);
		panel.add(costField);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		storeButton.addActionListener(listener);
		calculateCostButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(200, 320);
		this.setLocation(200, 0);
		this.setTitle("Input");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String selectedHotelName = listView.getSelectedValue();
			Hotel selectedHotel = null;
			
			for(Hotel h : hotels){
				if(h.getName().equals(slectedHotelName)){
					selectedHotel = h;
					break;
				}
			}
			//Βρίσκω επιλεγμένο ξενοδοχείο και κάνω add την κράτηση			
			if(selectedHotel!=null){
			
				String daysText = daysField.getText();
				int days = Integer.parseInt(daysText);// Ρητή μετατροπή σε int
				Reservation r;
				if(mealsField.getText().equals("")){
					r = new Reservation(days);
				}
				else{

					int meals = Integer.parseInt(mealsField.getText()); // Ρητή μετατροπή
					r = new AllInclusiveReservation(days,meals);
					}
				selectedHotel.addReservation(r);
			}
			else{
				int total = selectedHotel.calculateTotalost();
				costField.setText(Integer.toString(total));
			}
			else{
				JOptionPane.showMessageDialog(null, "No hotel selected!");
				System.out.println("No hotel selected");
			}
		}
	}

}
