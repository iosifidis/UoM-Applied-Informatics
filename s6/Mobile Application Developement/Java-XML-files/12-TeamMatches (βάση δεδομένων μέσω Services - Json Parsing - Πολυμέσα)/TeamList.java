package gr.uom.teammatches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamList {
    private ArrayList<Team> teamList = new ArrayList<Team>();

    /*
    Ο constructor της κλάσης TeamList παίρνει ένα όρισμα ip (ισως αναπαριστά τη διεύθυνση IP)
    και δημιουργεί ένα URL χρησιμοποιώντας το ip. Στη συνέχεια, προσπαθεί να καλέσει τη μέθοδο
    populatePlayers() από ένα αντικείμενο της κλάσης OkHttpHandler για να αναπληρώσει τη λίστα
    teamList με παίκτες από το δοθέν URL. Ενδέχεται να προκύψουν εξαιρέσεις κατά την εκτέλεση
    του κώδικα, οι οποίες εκτυπώνονται στην κονσόλα.
     */
    public TeamList(String ip) {
        String url= "http://"+ip+"/matches/getMembers.php";

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            teamList = okHttpHandler.populatePlayers(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Αυτή η μέθοδος επιστρέφει μια λίστα συμβολοσειρών που αντιπροσωπεύουν τα ονόματα των ομάδων
    στη λίστα teamList. Διατρέχει τη λίστα teamList και για κάθε ομάδα προσθέτει το όνομα της
    στην προσωρινή λίστα temp.
     */
    public List<String> getAllBrands() {
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i< teamList.size(); i++) {
            temp.add(teamList.get(i).getName());
        }
        return temp;
    }

    /*
    Αυτή η μέθοδος παίρνει ένα όρισμα b (πιθανότατα αναπαριστά το όνομα μιας ομάδας)
    και επιστρέφει ένα HashMap που περιέχει τους παίκτες για τη συγκεκριμένη ομάδα.
    Διατρέχει τη λίστα teamList και αν βρει μια ομάδα με το όνομα που ταιριάζει με το b,
    τότε επιστρέφει το HashMap με τα μέλη της ομάδας.
     */
    public HashMap<String,String> getAllPlayers(String b) {
        for (int i = 0; i< teamList.size(); i++) {
            if (teamList.get(i).hasName(b)) {
                return teamList.get(i).getMembers();
            }
        }
        return null;
    }

    /*
    Αυτή η μέθοδος παίρνει ένα όρισμα team (πιθανότατα αναπαριστά το όνομα μιας ομάδας) και επιστρέφει
    μια συμβολοσειρά που αντιπροσωπεύει τη διαδρομή της εικόνας για τη συγκεκριμένη ομάδα.
    Διατρέχει τη λίστα teamList και αν βρει μια ομάδα με το όνομα που ταιριάζει με το team,
    τότε επιστρέφει τη διαδρομή της εικόνας της ομάδας.
     */
    public String getImageForTeam(String team) {
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).hasName(team)) {
                return teamList.get(i).getImage();
            }
        }
        return null;
    }


}
