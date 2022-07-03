import java.util.ArrayList;

public class Proedros {
	private static Proedros single_instance = null;
	private String email;
	private ArrayList<String> ListaMelwn;
	private ArrayList<String> ListaAitiseon;
	private ArrayList<String> ListaEisigiseon;
	private String password;

	private Proedros(String email,String password) {
		this.email = email;
		this.password = password;
	}
	public static Proedros initialiseProedros(String email,String password) {
		if(single_instance == null) {
			single_instance = new Proedros(email,password);
		}
		return single_instance;
	}
	public static Proedros Proedros() {
		if(single_instance == null) {
			System.out.println("you must initialise the Proedros singleton");	
		}
		//eite null eite single instance which is single_instance
		return single_instance;
	}
	
	public String getEmail() {
		return this.email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void anetheseEisigisi(Melos eisigitis,Aitisi aitisi) {
		
		if (aitisi.getVisibilityPhase() == PhasesOfAitisi.ORISMOS_EISIGITI) {
			if (aitisi.getEisigisi().getListaMelwn().contains(eisigitis)) {

				aitisi.getEisigisi().setEisigitis(eisigitis);
				aitisi.getEisigisi().apomakryneMelos(eisigitis);
				aitisi.setVisibilityPhase(PhasesOfAitisi.EISIGISH);
			} else {
				System.out.println("Exei sygkroush symferontwn auto to atomo den mporei na mpei eisigitis edw");
			} 
		}else {
			System.out.println("Den exei ginei akoma elegxos symferontwn");
		}
		
	}

	/**
	 * 
	 * @param psifos
	 * @param eisigisi
	 */
	public void oloklhrwseElegxoSymferontwn(Aitisi aitisi) {
		aitisi.setVisibilityPhase(PhasesOfAitisi.ORISMOS_EISIGITI);
	}
	
	public void oloklhrwsePsifoforia(Aitisi aitisi) {
		aitisi.setVisibilityPhase(PhasesOfAitisi.APOFASH);
		aitisi.getEisigisi().calculateResult();
	}
	public void psifiseGiaEisigisi(int psifos, Eisigisi eisigisi) {

		eisigisi.registerVote(psifos);
	}

	/**
	 * 
	 * @param text
	 * @param apofasi
	 */
	public boolean grapseApofasi(String text, Apofasi apofasi) {
		apofasi.setText(text);
		return true;
	}

	/**
	 * 
	 * @param melos
	 */
	public boolean apokleismosMelous(Melos melos,Eisigisi e) {
		e.apomakryneMelos(melos);
		return true;
	}

	/**
	 * 
	 * @param apofasi
	 */
	public void ypograpseApofasiAitisis(Aitisi aitisi) {
		if(aitisi.getVisibilityPhase() != PhasesOfAitisi.APOFASH )return ;
		aitisi.getApofasi().setText(aitisi.getApofasi().getText().concat("\nO Ypografwn: \n " + this.getEmail()));
		aitisi.setVisibilityPhase(PhasesOfAitisi.ENHMERWSH_EREYNHTH);

	}
	
	public void printData() {
		System.out.println("PROEDROS: " + this.getEmail() + "password ");
	}

}