package gr.uom.teammatches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private OkHttpHandler ok;
    private final String myIP = "192.168.1.104";
    private Spinner fixtureSpinner;
    private Button selectButton;

    // δηλώνει μια σταθερά (constant) με την ονομασία matchesURL που περιέχει τη διεύθυνση URL για τη λήψη των στοιχείων των αγώνων (fixtures).
    private final String matchesURL = "http://"+myIP+"/matches/getFixtures.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // δημιουργεί ένα νέο αντικείμενο της κλάσης OkHttpHandler.
        // Αυτό το αντικείμενο χρησιμοποιείται για την επικοινωνία με έναν εξυπηρετητή HTTP μέσω της βιβλιοθήκης OkHttp.
        ok = new OkHttpHandler();

        /*
        Οι επόμενες γραμμές εκτελούν την κανονική ροή της μεθόδου onCreate για το Activity.
        Καλείται η μέθοδος super.onCreate(savedInstanceState) για την αρχικοποίηση της βασικής λειτουργίας
        του Activity και καθορίζεται το περιεχόμενο της διεπαφής χρήστη μέσω της μεθόδου
        setContentView(R.layout.activity_main).
        */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // εντοπίζει το Spinner (DropDown) με το αναγνωριστικό matchSelection
        // από το layout του Activity και το αντιστοιχεί στη μεταβλητή fixtureSpinner.
        fixtureSpinner = findViewById(R.id.matchSelection);

        // εντοπίζει το κουμπί με το αναγνωριστικό button
        // από το layout του Activity και το αντιστοιχεί στη μεταβλητή selectButton.
        selectButton = findViewById(R.id.button);

        // δημιουργεί έναν ArrayAdapter που χρησιμοποιείται για την εμφάνιση των αντικειμένων στο Spinner.
        // Ο ArrayAdapter λαμβάνει ως παραμέτρους το context του Activity (this),
        // το layout που ορίζει τον τρόπο εμφάνισης των αντικειμένων
        // (android.R.layout.simple_spinner_dropdown_item), και τα δεδομένα που θα εμφανίζονται στο Spinner.
        // Τα δεδομένα παρέχονται από τη μέθοδο populateMatches(matchesURL) της κλάσης ok.
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        ok.populateMatches(matchesURL));

        // ορίζει τον arrayAdapter ως αντάπτορα για το Spinner,
        // προκειμένου να εμφανίζεται η λίστα των δεδομένων στο Spinner.
        fixtureSpinner.setAdapter(arrayAdapter);



    }

    // αναφέρεται σε μια μέθοδο με την ονομασία gotoDetails,
    // η οποία εκτελείται όταν πατηθεί ένα κουμπί ή γίνει κλικ σε ένα στοιχείο της διεπαφής χρήστη.
    public void gotoDetails(View v){

        // δημιουργεί ένα νέο Intent, το οποίο χρησιμοποιείται για τη μετάβαση από το τρέχον Activity
        // στο Activity με την κλάση TeamDetails. Το this αναφέρεται στο τρέχον Activity.
        Intent intent = new Intent(this, TeamDetails.class);

        // προσθέτει μια επιπλέον πληροφορία στο Intent. Χρησιμοποιεί το κλειδί "match"
        // και την τιμή του επιλεγμένου στοιχείου του Spinner fixtureSpinner, το οποίο μετατρέπεται σε συμβολοσειρά.
        intent.putExtra("match", String.valueOf(fixtureSpinner.getSelectedItem()));

        // προσθέτει μια επιπλέον πληροφορία στο Intent. Χρησιμοποιεί το κλειδί "ip" και την τιμή της μεταβλητής myIP,
        // η οποία πιθανότατα περιέχει μια διεύθυνση IP.
        intent.putExtra("ip", myIP);

        // εκκινεί το Intent και ξεκινά τη μετάβαση στο Activity με την κλάση TeamDetails,
        // περνώντας τις πληροφορίες που έχουν προστεθεί με τα putExtra().
        startActivity(intent);
    }

}