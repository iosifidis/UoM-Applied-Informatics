import java.util.ArrayList;

public class ListaAitisewn {

	private static ListaAitisewn onlyInstance = null;
	private ArrayList<Aitisi> aitiseis;

	public ArrayList<Aitisi> getAitiseis() {
		return aitiseis;
	}

	public void setAitiseis(ArrayList<Aitisi> aitiseis) {
		this.aitiseis = aitiseis;
	}

	private ListaAitisewn() {
		this.aitiseis = new ArrayList<Aitisi>();
	}
	
	public static ListaAitisewn ListaAitisewn() {
		if(onlyInstance == null) {
			onlyInstance = new ListaAitisewn();
		}
		return onlyInstance;
	}
	/**
	 * 
	 * @param aitisi
	 */
	public boolean prostheseAitisi(Aitisi aitisi) {
		if(aitisi!=null) {			
			this.aitiseis.add(aitisi);
			return true;
		}else {
			System.out.println("aitisi was null");
			return false;
		}
	}
	public ArrayList<Aitisi> emfaniseAitiseis(PhasesOfAitisi p){
		ArrayList<Aitisi> result = new ArrayList<Aitisi>();
		for(Aitisi a:this.aitiseis) {
			if(a.getVisibilityPhase().equals(p)) {
				result.add(a);
				System.out.println(a);
			}
		}
		return result;
	}

	public void printData() {
		for(Aitisi a:aitiseis) {
			System.out.println("\n");
			a.printData();
		}
	}

}