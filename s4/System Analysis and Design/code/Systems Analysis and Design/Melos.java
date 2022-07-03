import java.util.Objects;

public class Melos {

	private String email;
	private String password;

	public Melos(String email,String password) {
		this.email = email;
		this.password = password;
		ListaMelwn listaMelwn = ListaMelwn.ListaMelwn();
		listaMelwn.prostheseMelos(this);
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
	 * @param eisigisi
	 * @param psifos
	 */
	public boolean psifiseGiaEisigisiAitisis(Aitisi a, int psifos) {
		// TODO - implement Μέλος.psifiseGiaEisigisi
		//den exw lavei ypopsh kapoios na paei na psifisei duo fores
		if(a.getVisibilityPhase()!= PhasesOfAitisi.PSHFOFORIA)return false;
		if(!a.getEisigisi().getListaMelwn().contains(this))return false;
		if(a.getEisigisi().getEisigitis().equals(this))return false;
		a.getEisigisi().registerVote(psifos);
		return true;
	}

	/**
	 * 
	 * @param periexomeno
	 * @param apofasi
	 */
	
	public boolean ypovalleSxolio(String periexomeno, Apofasi apofasi) {
		// TODO - implement Μέλος.ypovalleSxolio
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Melos other = (Melos) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	public void printData() {
		System.out.println("Melos: " + this.getEmail() + " password " + this.getPassword());
	}
	
	public String toString() {
		return "Melos: " + this.getEmail();
	}
	public void dimiourgiseEisigisi(Aitisi a,String text) {
		// TODO - implement Εισηγητής.dimiourgiseEisigisi
		//elegxoume logw elleipshs gui
		if(a.getEisigisi().getEisigitis()!= this) {
			System.out.println("sth went wrong");
			return;
		}
		a.getEisigisi().setEisigisiText(text);
		a.setVisibilityPhase(PhasesOfAitisi.PSHFOFORIA);
		
	}

}