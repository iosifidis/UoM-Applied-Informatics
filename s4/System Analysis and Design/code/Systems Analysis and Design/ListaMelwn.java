import java.util.ArrayList;

public class ListaMelwn {
	private static ListaMelwn single_instance = null;
	private ArrayList<Melos> Meli_EHDE;
	
	
	private ListaMelwn() {
		Meli_EHDE = new ArrayList<Melos>();
	}
	
	public static ListaMelwn ListaMelwn() {
		if(single_instance == null) {
			single_instance = new ListaMelwn();
		}
		
		return single_instance;
	}
	public ArrayList<Melos> getMeli_EHDE() {
		return this.Meli_EHDE;
	}

	public void setMeli_EHDE(ArrayList<Melos> Meli_EHDE) {
		this.Meli_EHDE = Meli_EHDE;
	}

	/**
	 * 
	 * @param melos
	 */
	public boolean prostheseMelos(Melos melos) {
		if(melos !=null) {
			this.Meli_EHDE.add(melos);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param melos
	 */
	public void diagrapseMelos(Melos melos) {
		this.Meli_EHDE.remove(melos);
	}
	
	public void printData() {
		for(Melos m: Meli_EHDE) {
			m.printData();
		}
	}
	
	
	

}