import java.util.Date;

public class Aitisi {

	private int inqueueNumber;
	private String subject;
	private Date date;
	private Ereunitis ereunitis;
	private Apofasi apofasi;
	private ListaArxeion files;
	private String title;
	private PhasesOfAitisi visibilityPhase;
	private Eisigisi eisigisi;
	public Ereunitis getEreunitis() {
		return ereunitis;
	}

	public ListaArxeion getFiles() {
		return files;
	}
	public void setFiles(ListaArxeion files) {
		this.files = files;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setEreunitis(Ereunitis ereunitis) {
		this.ereunitis = ereunitis;
	}

	
	public Aitisi(Ereunitis e, String title,String subject,ListaArxeion arxeia) {
		this.ereunitis = e;
		this.title = title;
		this.subject = subject;
		this.files = arxeia;
		this.date = new Date();
		//Αρχικοποιούμε την αίτηση στην πρώτη φάση της διαδικασίας
		this.visibilityPhase = PhasesOfAitisi.PROETOIMASIA;
		this.eisigisi = new Eisigisi();
		this.ereunitis.prostheseAitisiStinListaTou(this);
		this.apofasi = new Apofasi();
		this.inqueueNumber = -1;
		ListaAitisewn lista = ListaAitisewn.ListaAitisewn();
		lista.prostheseAitisi(this);
	
	}
	public int getInqueueNumber() {
		return this.inqueueNumber;
	}

	public void setInqueueNumber(int inqueueNumber) {
		this.inqueueNumber = inqueueNumber;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Apofasi getApofasi() {
		return this.apofasi;
	}

	public void setApofasi(Apofasi apofasi) {
		this.apofasi = apofasi;
	}

	public PhasesOfAitisi getVisibilityPhase() {
		return this.visibilityPhase;
	}

	public void setVisibilityPhase(PhasesOfAitisi visibilityPhase) {
		this.visibilityPhase = visibilityPhase;
	}

	public Eisigisi getEisigisi() {
		return this.eisigisi;
	}

	public void setEisigisi(Eisigisi eisigisi) {
		this.eisigisi = eisigisi;
	}

	public void printData() {
		System.out.println( "Αίτηση [Αριθμός στην ουρά =" + inqueueNumber + ", Θέμα=" + subject + ", Ημ/νία Υποβολής=" + date + 
				", Ερευνητής="
				+ ereunitis + ", Απόφαση=" + apofasi + ", Αρχεία=" + files + ", Τίτλος=" + title + ", Φάση της αίτησης="
				+ visibilityPhase + ", Εισήγηση=" + eisigisi + "]");
	}
	@Override
	public String toString() {
		return this.title + " " + this.inqueueNumber + " " + this.files + " " + this.visibilityPhase;
	}

}