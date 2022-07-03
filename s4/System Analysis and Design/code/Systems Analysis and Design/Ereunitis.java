import java.util.ArrayList;
import java.util.Scanner;

public class Ereunitis {

	private String email;
	private String password;
	private ArrayList<Aitisi> Lista_Aitisewn_Tou;
	
	public Ereunitis(String email, String password) {
		this.email=email;
		this.password = password;
		Lista_Aitisewn_Tou = new ArrayList<Aitisi>();
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

	public ArrayList<Aitisi> getLista_Aitisewn_Tou() {
		return this.Lista_Aitisewn_Tou;
	}

	public void setLista_Aitisewn_Tou(ArrayList<Aitisi> Lista_Aitisewn_Tou) {
		this.Lista_Aitisewn_Tou = Lista_Aitisewn_Tou;
	}
	
	public void prostheseAitisiStinListaTou(Aitisi a) {
		this.Lista_Aitisewn_Tou.add(a);
	}

	public void ypevalleAitisi(Aitisi a) {
		//prepei na einai dikh tou h aitisi me gui den tha eixame thema
		if(a.getEreunitis().equals(this)) {
			
			a.setVisibilityPhase(PhasesOfAitisi.ELEGXOS);
			//twra mporei na thn dei h grammateia
		}else {
			System.out.println("this operation is prohibited");
		}
		
		
	}
	public void editAitisi(Aitisi aitisi) {
		//diagrafh kai ypovolh arxeiwn
		System.out.println("Αίτηση: " + aitisi);
		System.out.println("---------Επεξεργασία----------");
		System.out.println("Πατήστε 1 για διαγραφή αρχείων");
		System.out.println("Πατήστε 2 για προσθήκη αρχείων");
		System.out.println("Πατήστε 3 για έξοδο");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		while(choice != 3) {
			switch (choice){
			case 1:
				System.out.println("Διέγραψε το αρχείο πατώντας τον αριθμό δίπλα από το συγκεκριμένο αρχείο");
				int counter =0;
				for(String filename: aitisi.getFiles().getFileList()) {
					counter++;
					System.out.println(counter + ") " + filename);
				}
				int choiceToDelete = sc.nextInt();
				aitisi.getFiles().diagrapseArxeio(aitisi.getFiles().getFileList().get(choiceToDelete-1));
				aitisi.setVisibilityPhase(PhasesOfAitisi.PROETOIMASIA);
				break;
			case 2:
				int count =0;
				for(String filename: aitisi.getFiles().getFileList()) {
					count++;
					System.out.println(count + ") " + filename);
				}
				System.out.println("Δώσε όνομα νέου αρχείου");
				Scanner sc2 = new Scanner(System.in);
				String fileInput = sc2.nextLine();
				aitisi.getFiles().prostheseArxeio(fileInput);
				aitisi.setVisibilityPhase(PhasesOfAitisi.PROETOIMASIA);
				break;
			case 3:
				System.out.println("Επέλεξες έξοδο");
				break;
			default:
				System.out.println("wrong option");
				break;
				
		}
			System.out.println("---------Επεξεργασία----------");
			System.out.println("Πατήστε 1 για διαγραφή αρχείων");
			System.out.println("Πατήστε 2 για προσθήκη αρχείων");
			System.out.println("Πατήστε 3 για έξοδο");
			choice= sc.nextInt();
		}
		
	}

	public void printAitiseis() {
		System.out.println(this.email+ "  Αιτήσεις");
		String currentMsg = "";
		for(Aitisi a: this.Lista_Aitisewn_Tou) {
			switch (a.getVisibilityPhase()) {
				case PROETOIMASIA:
					currentMsg = "Δεν έχει γίνει ακόμα υποβολή";
					break;
				case ELEGXOS:
					currentMsg = "Η αίτηση έχει σταλεί στην γραμματεία, δεν έχει ελεγχθεί ακόμα";
				case APORRIPSH:
					currentMsg = "Η αίτηση κρίθηκε ανελλιπής και απορρίφθηκε από την γραμματεία";
					break;
				case ENHMERWSH_GIA_VELTIWSEIS:
					currentMsg = "Η αίτηση δεν έγινε αποδεκτή, ζητούνται βελτιώσεις, η απόφαση της επιτροπής:\n";
					currentMsg+= a.getApofasi().getText();
					break;
				case ENHMERWSH_GIA_APODOXH:
					currentMsg = "Η αίτηση έγινε αποδεκτή!!";
					break;
				default:
					currentMsg = "Η αίτηση βρίσκεται στην διαδικασία ελέγχου από την ΕΗΔΕ";
					break;
					
					
			}
			System.out.println("Η αίτηση:" + a);
			System.out.println("Κατάσταση: " + currentMsg);
		}
	}


	
	public void printData() {
		System.out.println("Ereunitis [email=" + email + ", password=" + password + ", Lista_Aitisewn_Tou=" + Lista_Aitisewn_Tou + "]");
	}
	
	

}