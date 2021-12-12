import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {

	public GUI(){
		
		Board board = new Board();
		
		// Προσθήκη του Board στο παράθυρο
		this.setContentPane(board);
		
		
		// Δημιουργία παραθύρου
		this.setVisible(true);
		this.setSize(500,500);
		this.setTitle("ChessBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	// Φτιάχνω μια κλάση για να επικαλύψω την paintComponent
	class Board extends JPanel{
		
		// Δηλώνω διαστάσεις
		private static final int ROWS = 8;
		private static final int COLUMNS = 8;
		
		public void paintComponent(Graphics g){
			
			//Για να προσθέσω μια ακόμα ιδιότητα στην paintComponent την καλώ με super
			super.paintComponent(g);
			
			// Φτιάχνω μια μεταβλητή για να κλιμακώνει το μέγεθος της σκακιέρας (responsive)
			int sqSize1 = this.getHeight() / ROWS;
			int sqSize2 = this.getWidth() / COLUMNS;
			int sqSize = sqSize1;
			if(sqSize2 < sqSize)
				sqSize = sqSize2;
			
			// Ζωγραφίζει ένα κουτάκι από το σημείο 0,0 και να έχει μέγεθος πλάτος 10 και ύψος 10
			//g.drawRect(0, 0, 10, 10);
			
//			//Ζωγραφίζω την σκακιέρα μου
//			for(int i=0; i<ROWS; i++){
//				for(int j=0; j<COLUMNS; j++){
//					int x,y;
//					x = j*10; // Για να ξεκινάει από το 0,10
//					y = i*10; // Για να ξεκινάει από 0,10
//					g.drawRect(x, y, 10, 10);
//				}
//			}
			

			//Ζωγραφίζω την σκακιέρα μου
			for(int i=0; i<ROWS; i++){
				for(int j=0; j<COLUMNS; j++){
					int x,y;
					x = j*sqSize; // Για να ξεκινάει από το 0,sqSize
					y = i*sqSize; // Για να ξεκινάει από 0,sqSize
					g.drawRect(x, y, sqSize, sqSize);
					
					// Ζωγραφίζω με διαφορετικό χρώμα ανάλογα αν είναι ζυγό ή μονό το τετραγωνάκι
					if((i+j)%2 ==0){
						g.setColor(Color.RED); // Αλλάζω τα χρώματα
						g.fillRect(x, y, sqSize, sqSize);
						
					}
					
					else{
						g.setColor(Color.BLUE);
						g.fillRect(x, y, sqSize, sqSize);
					}
						
						
				}
			}

			
			
		}
	}
	
	
}
