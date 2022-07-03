import java.util.ArrayList;

public class Apofasi {

	private String text;
	private ArrayList<String> sxolia;

	public Apofasi() {
		this.text = "";
		sxolia = new ArrayList<String>();
	}
	
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> getSxolia() {
		return this.sxolia;
	}

	public void setSxolia(ArrayList<String> sxolia) {
		this.sxolia = sxolia;
	}

	/**
	 * 
	 * @param periexomeno
	 */
	
	
	public void prostheseSxolio(String periexomeno) {
		
		this.sxolia.add(periexomeno);
	}

	
	public String toString() {
		return "Apofasi [Απόφαση=" + text + ", Σχόλια=" + sxolia + "]";
	}

}