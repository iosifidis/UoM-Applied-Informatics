package com.example.carpicker;

import androidx.appcompat.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    // Δημιουργώ αντικείμενο CarBrandList που θα το χρησιμοποιήσω σε κάποια μέθοδο
    private CarBrandList cbl;

    // ορίζουμε το RadioGroup εδώ για να το δούν όλες οι μέθοδοι.
    private RadioGroup rg;

    // Ορίζω την IP μου για να μην την γράφω σε κάθε μέθοδο
    private final String myIP = "192.168.1.104";

    // Γράφουμε την μέθοδο για το τι θα κάνει το κουμπί όταν πατηθεί.
    public void PickCarOnClick(View v) {
        // Φτιάχνω ένα αντικείμενο spinner. Επιλεγμένο αντικείμενο από την λίστα
        Spinner dropDown = (Spinner) findViewById(R.id.cars);

        // Από το spinner παίρνω το επιλεγμένο αντικείμενο και το αποθηκεύω στο brand
        String brand = String.valueOf(dropDown.getSelectedItem());

        // Σύνδεση του GUI με την κλάση πρέπει να γίνει μέσα στην παρένθεση
        List<String> allModels = cbl.getAllModels(brand);

        // Πρέπει να περάσουμε τα μοντέλα στο GUI στο radiogroup
        rg.removeAllViews(); // το αδειάζουμε

        // Κατασκευή του radiobutton
        for(int i=0;i<allModels.size();i++) {
            RadioButton rb = new RadioButton(this);// Φτιάχνω ένα radio button ανάλογα με τι μέγεθος θα έχει η λίστα
            rb.setText(allModels.get(i)); // Προσθέτων το κείμενο που πήρα από την λίστα ως κείμενο σε radiobutton
            rb.setId(100+i); // Βάζω ένα id γιατί πιθανό να το ψάξω με το id
            rg.addView(rb); // Το προσθέτω στο radiogroup
        }

        // Φτιάχνω έναν Listener που θα τον υλοποιήσω εδώ μέσα
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /*
            αυτός ο κώδικα χειρίζεται το συμβάν όταν επιλέγεται ένα κουμπί επιλογής σε ένα radiogroup.
            Ανακτά το επιλεγμένο κουμπί επιλογής, κατασκευάζει μια συμβολοσειρά URL με την επιλεγμένη επωνυμία,
            μοντέλο και χρονική σήμανση, καλεί ένα αίτημα HTTP για να καταγράψει την επιλογή χρησιμοποιώντας
            το OkHttp και εμφανίζει ένα μήνυμα toast για να ειδοποιήσει τον χρήστη για την επιτυχή καταγραφή.
             */
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Ανακτά το επιλεγμένο RadioButton από το RadioGroup με βάση την παράμετρο checkedId,
                // η οποία αντιπροσωπεύει το αναγνωριστικό του επιλεγμένου κουμπιού επιλογής.
                RadioButton rb = (RadioButton) findViewById(checkedId);

                // κατασκευάζει μια συμβολοσειρά URL για ένα τελικό σημείο υπηρεσίας ιστού,
                // το οποίο περιλαμβάνει παραμέτρους για την επωνυμία, το μοντέλο και τη χρονική σήμανση.
                // Η τιμή της επωνυμίας θεωρείται ότι ορίζεται αλλού και η rb.getText().toString() ανακτά το κείμενο
                // του επιλεγμένου κουμπιού επιλογής, που αντιπροσωπεύει το μοντέλο.
                // Η χρονική σήμανση δημιουργείται χρησιμοποιώντας τη νέα Date(System.currentTimeMillis())
                // και μετατρέπεται σε συμβολοσειρά.
                String url= "http://"+myIP+"/carsDBServices/logHistory.php?brand=" + brand + "&model=" + rb.getText().toString() + "&timestamp=" + new Date(System.currentTimeMillis()).toString();
                try {
                    // Δημιουργεί αντικείμενο μιας προσαρμοσμένης κλάσης OkHttpHandler,
                    // η οποία φαίνεται να χειρίζεται αιτήματα HTTP χρησιμοποιώντας τη βιβλιοθήκη OkHttp.
                    OkHttpHandler okHttpHandler = new OkHttpHandler();

                    // Επικαλείται τη μέθοδο logHistory της παρουσίας OkHttpHandler,
                    // περνώντας τη συμβολοσειρά URL που δημιουργήθηκε ως παράμετρο.
                    // Αυτό υποδηλώνει ότι η μέθοδος logHistory είναι υπεύθυνη για την αποστολή ενός αιτήματος
                    // HTTP στην καθορισμένη διεύθυνση URL, πιθανόν για την καταγραφή της επιλεγμένης
                    // επωνυμίας, μοντέλου και χρονικής σφραγίδας.
                    okHttpHandler.logHistory(url);

                    // Εμφανίζει ένα μήνυμα toast μικρής διάρκειας που υποδεικνύει ότι η επιλογή καταγράφηκε
                    // με επιτυχία.
                    Toast.makeText(getApplicationContext(), "Selection Logged", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /*
   Παρακάτω ο κώδικας αρχικοποιεί μια CarBrandList, ορίζει την προβολή περιεχομένου της δραστηριότητας,
   δημιουργεί ένα Spinner, το συμπληρώνει με επωνυμίες χρησιμοποιώντας έναν ArrayAdapter και προετοιμάζει
   μια RadioGroup. Αυτό ρυθμίζει τα στοιχεία διεπαφής χρήστη για τη δραστηριότητα, επιτρέποντας στον χρήστη
   να επιλέξει μια μάρκα αυτοκινήτου από το Spinner και να αλληλεπιδράσει με το RadioGroup.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Στο αντικείμενο cbl περνάω το αρχείο με τα brands με την getAssets()
        cbl = new CarBrandList(myIP);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Δημιουργούμε το Spinner και το γεμίζουμε με τα brands
        Spinner dropDown = (Spinner) findViewById(R.id.cars);
        // Δημιουργεί έναν ArrayAdapter που θα χρησιμοποιηθεί για τη συμπλήρωση του Spinner με δεδομένα.
        // Ο ArrayAdapter αρχικοποιείται με την τρέχουσα δραστηριότητα (this), τον πόρο διάταξης
        // για κάθε στοιχείο Spinner και τη λίστα των brands που ελήφθησαν
        // από το CarBrandList cbl χρησιμοποιώντας τη μέθοδο getAllBrands.
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        cbl.getAllBrands());
        dropDown.setAdapter(arrayAdapter);

        // Αρχικοποιεί ένα γραφικό στοιχείο RadioGroup που ονομάζεται rg
        // βρίσκοντας την προβολή με το αναγνωριστικό rg από τη διάταξη της δραστηριότητας
        rg = (RadioGroup) findViewById(R.id.rg);
    }
}