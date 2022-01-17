import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class MyFrame extends JFrame {
	
	public MyFrame() {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();// Κλάση της βιβλιοθήκης που βάλαμε
		// Προσθέτω τιμές (το Classes είναι η σειρά δεδομένων που ανήκουν. Μπορεί πχ να έχω και άλλη "γραμμή")
		dataset.addValue(212, "Classes", "JDK 1.0");
		dataset.addValue(504, "Classes", "JDK 1.1");
		dataset.addValue(1520, "Classes", "JDK 1.2");
		dataset.addValue(1842, "Classes", "JDK 1.3");
		dataset.addValue(2991, "Classes", "JDK 1.4");
		
		// Μέθοδος για να παράγω το διάγραμμα
		//JFreeChart chart = ChartFactory.createLineChart("Java Evolution", "Release", "Number of classes", dataset); // Διάγραμμα Γραμμή
		//JFreeChart chart = ChartFactory.createBarChart("Java Evolution", "Release", "Number of classes", dataset); // Διάγραμμα μπάρας
		//JFreeChart chart = ChartFactory.createBarChart3D("Java Evolution", "Release", "Number of classes", dataset); // Διάγραμμα μπάρας 3d
		
		//Γυρνάω οριζόντια και βάζω το true για να μου δείχνει δεδομένα όταν αφήνω πάνω σε μια μπάρα το ποντίκι
		JFreeChart chart = ChartFactory.createBarChart3D("Java Evolution", "Release", "Number of classes", dataset, PlotOrientation.HORIZONTAL, false, true, false);
		
		// Φτιάχνω το panel ως ChartPanel
		ChartPanel chartPanel = new ChartPanel(chart);
		
		// Προσθήκη του panel στο παράθυρο
		this.setContentPane(chartPanel);
		
		// Παράθυρο
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Charts");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
