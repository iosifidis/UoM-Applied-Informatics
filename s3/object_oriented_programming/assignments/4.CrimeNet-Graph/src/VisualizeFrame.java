// Φοιτητής: Ευστάθιος Ιωσηφίδης
// ΑΜ: iis21027
// Άδεια χρήσης: GNU General Public License v3.0
// Use UTF-8 encoding to view the comments

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.shortestpath.DistanceStatistics;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;


public class VisualizeFrame extends JFrame {

	
	private Registry nuevaRegistry; // Εισάγω ένα αντικείμενο Registry για να λάβω το αντικείμενο που στέλνει από SearchFrame
	
	private JTextField diameterResult = new JTextField();;
	private Double networkDiameterValue;
	private VisualizationImageServer visual;
	
	private JFrame vnFrame = new JFrame();
	
	public VisualizeFrame(Registry r) {
		
		nuevaRegistry = r; // Έχω πρόσβαση στο αντικείμενο Registry που ήρθε από το SearchFrame
		
		// Δημιουργώ αντικείμενο γράφου
		Graph graph = new SparseGraph();
		
		// Διατρέχω την registry και προσθέτω κορυφές στον γράφο, τα κωδικά ονόματα των υπόπτων
		for(Suspect suspect : nuevaRegistry.getSuspects())
		{
			graph.addVertex(suspect.getCodeName());
		}
		
		
		int counter=0;
		for(Suspect suspect1 : nuevaRegistry.getSuspects()) 
			for(Suspect suspect2 : suspect1.getListOfAssociates())
			{	
				graph.addEdge(counter, suspect1.getCodeName(), suspect2.getCodeName());
				counter++;
			}
		
		// Σχεδιασμός γράφου
		visual = new VisualizationImageServer(new CircleLayout(graph), new Dimension(250,250));
		visual.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		
		// Υπολογισμός διαμέτρου γράφου
		networkDiameterValue = DistanceStatistics.diameter(graph);
		diameterResult.setText("Diameter = " + networkDiameterValue);
		
		//Προσθήκη γραφικών συστατικών στο Frame
		vnFrame.getContentPane().add(visual);
		vnFrame.add(diameterResult, BorderLayout.PAGE_END);
		vnFrame.pack();
	
		
		// Δημιουργώ το παράθυρο
		vnFrame.setVisible(true);
		vnFrame.setTitle("Suspects Network");
		vnFrame.setSize(340,330);
		vnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
}