import java.util.ArrayList;

public class Grammateia {

	private String email;
	private String password;
	private static int current_queue_number = 0;
	public Grammateia(String email,String password) {
		this.email = email;
		this.password = password;
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

	/**
	 * 
	 * @param aitisi
	 */
	//mporei na einai kai string
	public void diavaseAitiseisGiaPrwtoElegxo() {
		ListaAitisewn listaAitisewn = ListaAitisewn.ListaAitisewn();
		listaAitisewn.emfaniseAitiseis(PhasesOfAitisi.ELEGXOS);
	}
	public boolean protokollisiAitisis(Aitisi aitisi) {
		
		if(aitisi.getVisibilityPhase() == PhasesOfAitisi.ELEGXOS) {
			//protokollhsh
			aitisi.setInqueueNumber(++current_queue_number);
			//thn stelnei gia elegxo symferontwn
			aitisi.setVisibilityPhase(PhasesOfAitisi.ELEGXOS_SYMFERONTWN);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param aitisi
	 */
	public boolean aporripsiAitisis(Aitisi aitisi) {
		if(aitisi.getVisibilityPhase() == PhasesOfAitisi.ELEGXOS) {
			
			aitisi.setVisibilityPhase(PhasesOfAitisi.APORRIPSH);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param aitisi
	 */
	public void diavaseAitisi(Aitisi aitisi) {
		aitisi.printData();
	}

	/**
	 * 
	 * @param aitisi
	 */
	public boolean enimerwseEreuniti(Aitisi aitisi) {
		if(aitisi.getEisigisi().getResult()) {
			aitisi.setVisibilityPhase(PhasesOfAitisi.ENHMERWSH_GIA_APODOXH);
		}else {
			aitisi.setVisibilityPhase(PhasesOfAitisi.ENHMERWSH_GIA_VELTIWSEIS);
		}
		return true;
	}
	
	public void printData() {
		 System.out.println("Grammateia [email=" + email + ", password=" + password + "]");
	}
	
	

}