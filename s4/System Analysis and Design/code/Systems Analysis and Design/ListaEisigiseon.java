import java.util.ArrayList;

public class ListaEisigiseon {
	private static ListaEisigiseon  single_instance = null;
	private ArrayList<Eisigisi> eisigiseis;

	/**
	 * 
	 * @param eisigisi
	 */
	
	public static ListaEisigiseon listaEisigiseon() {
		if(single_instance == null) {
			single_instance = new ListaEisigiseon();
			
		}
		return single_instance;
	}
	
	private ListaEisigiseon() {
		eisigiseis = new ArrayList<Eisigisi>();
	}
	public void prostheseEisigisi(Eisigisi eisigisi) {
		eisigiseis.add(eisigisi);
	}
	
	public void printData() {
		for(Eisigisi e: eisigiseis) {
			e.printData();
		}
	}

}