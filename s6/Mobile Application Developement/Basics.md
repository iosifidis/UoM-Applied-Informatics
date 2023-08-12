# Βασικές γνώσεις Android σε μορφή ερωτοαπαντήσεων

## Τι είναι ένα activity και τι είναι ένα fragment

Στο πλαίσιο της ανάπτυξης εφαρμογών για το Android με τη χρήση του Android Studio, τα "activity" και "fragment" είναι δύο βασικά στοιχεία που χρησιμοποιούνται για την δομή και την παρουσίαση της διεπαφής των εφαρμογών.

**Activity:**  
Ένα "activity" αντιπροσωπεύει μια μονάδα εργασίας μιας εφαρμογής. Σε απλά λόγια, είναι μια οθόνη με την οποία ο χρήστης αλληλεπιδρά. Κάθε φορά που ο χρήστης εκτελεί μια ενέργεια που απαιτεί να αλλάξει την οθόνη ή την κατάσταση της εφαρμογής, δημιουργείται μια νέα activity. Οι activities μπορούν να περιέχουν τον κώδικα για τη λογική της εφαρμογής, την παρουσίαση των δεδομένων και την αλληλεπίδραση με τον χρήστη.

**Fragment:**  
Ένα "fragment" είναι ένα μικρό κομμάτι της διεπαφής χρήστη που μπορεί να είναι μέρος μιας activity. Η χρήση των fragments επιτρέπει τη δημιουργία ευέλικτων διεπαφών που μπορούν να προσαρμοστούν σε διάφορα μεγέθη οθονών και συσκευών. Τα fragments μπορούν να αντικατασταθούν ή να συνδυαστούν για να δημιουργήσουν πολύπλοκες διεπαφές. Μια activity μπορεί να περιέχει ένα ή περισσότερα fragments και να τα εναλλάσσει ανάλογα με την αλληλεπίδραση του χρήστη.

Συνολικά, τα activities και τα fragments αποτελούν τα βασικά στοιχεία της διαμόρφωσης της διεπαφής του χρήστη σε μια εφαρμογή Android, επιτρέποντας την οργάνωση του κώδικα και την αποτελεσματική αλληλεπίδραση με τον χρήστη.

## Πως εισάγω νέα activity και πως νέα fragment;

* Εισαγωγή νέου Activity:

1. Ανοίξτε το Android Studio και το έργο (project) σας.   
2. Κάντε δεξί κλικ πάνω στον φάκελο "app" στο "Project" παράθυρο.  
3. Επιλέξτε "New" και στη συνέχεια "Activity".  
4. Επιλέξτε τον τύπο της activity που θέλετε να δημιουργήσετε (π.χ. Empty Activity, Basic Activity, etc.).   
5. Δώστε ένα όνομα στο νέο activity και πατήστε "Finish".  
6. Θα δημιουργηθεί το νέο activity και τα απαραίτητα αρχεία κώδικα και διεπαφής θα προστεθούν στο έργο σας.

* Εισαγωγή νέου Fragment στο Android Studio:

1. Ακολουθήστε τα βήματα 1 και 2 όπως παραπάνω.  
2. Επιλέξτε "New" και στη συνέχεια "Fragment".  
3. Επιλέξτε τον τύπο του fragment που θέλετε να δημιουργήσετε (π.χ. Fragment (Blank), Fragment (List), etc.).  
4. Δώστε ένα όνομα στο νέο fragment και πατήστε "Finish".  
5. Θα δημιουργηθούν τα απαραίτητα αρχεία κώδικα και διεπαφής για το νέο fragment στο έργο σας.  

## Πως ενώνω το fragment στο activity;

Για να ενώσετε ένα Fragment σε ένα Activity στο Android, πρέπει να ακολουθήσετε τα εξής βήματα:

1. Δημιουργία Fragment:   
Πρώτα, πρέπει να έχετε δημιουργήσει το Fragment στο Android Studio όπως περιγράφηκε στις προηγούμενες απαντήσεις.

2. Σύνδεση Fragment στο Layout του Activity:   
Πηγαίνετε στο XML layout αρχείο του Activity (συνήθως βρίσκεται στον φάκελο res/layout). Εκεί μπορείτε να προσθέσετε το <fragment> στοιχείο και να χρησιμοποιήσετε το attribute android:name για να ορίσετε το πλήρες όνομα της κλάσης του Fragment που θέλετε να ενσωματώσετε. Το layout αρχείο μπορεί να μοιάζει κάπως έτσι:

```
<fragment
    android:id="@+id/fragment_container"
    android:name="com.example.myapp.MyFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

3. Εμφάνιση Fragment μέσω κώδικα:   
Στην Java κλάση του Activity, μπορείτε να χρησιμοποιήσετε το FragmentManager για να εμφανίσετε το Fragment στο container που ορίσατε στο layout. Ένα παράδειγμα κώδικα σε Java μπορεί να είναι:

```
FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

MyFragment myFragment = new MyFragment(); // Αντικαταστήστε το MyFragment με το όνομα της κλάσης του Fragment που δημιουργήσατε
fragmentTransaction.replace(R.id.fragment_container, myFragment);
fragmentTransaction.commit();
```

Αυτό θα ενσωματώσει το Fragment στο Activity και θα το εμφανίσει στον καθορισμένο χώρο στο layout του Activity. Είναι σημαντικό να προσέξετε ότι πρέπει να χρησιμοποιήσετε το σωστό όνομα πακέτου και τη σωστή κλάση για το Fragment στον κώδικά σας.

## Τι είναι ένα Bundle και τι Intent;

Τόσο το Bundle όσο και το Intent είναι δύο βασικά στοιχεία στην πλατφόρμα Android που χρησιμοποιούνται για την μεταφορά δεδομένων μεταξύ συνιστωσών μιας εφαρμογής, όπως μεταξύ διαφορετικών activities ή services.

**Bundle:**  
Το Bundle είναι ένας τύπος δεδομένων που χρησιμοποιείται για τη συσκευασία και μεταφορά δεδομένων μεταξύ συνιστωσών της ίδιας εφαρμογής. Συνήθως χρησιμοποιείται για την παράδοση παραμέτρων και δεδομένων από ένα activity σε ένα άλλο. Τα δεδομένα μέσα σε ένα Bundle οργανώνονται με τη μορφή "key-value" ζευγαριών, όπου κάθε κλειδί (key) αντιστοιχεί σε ένα τύπο δεδομένων (π.χ. String, Integer, Parcelable κλπ.). Τα Bundle συνήθως χρησιμοποιούνται για τη μεταφορά περιορισμένων ποσοτήτων δεδομένων μεταξύ συνιστωσών.

**Intent:**  
Το Intent αναπαριστά μια προτροπή για μια ενέργεια που πρόκειται να εκτελεστεί. Χρησιμοποιείται για την εκκίνηση δραστηριοτήτων (activities), υπηρεσιών (services), εκδηλώσεων (broadcasts), και άλλων συνιστωσών της εφαρμογής. Μέσω των Intent, μπορείτε να περάσετε δεδομένα και να εκτελέσετε διάφορες ενέργειες. Τα Intent μπορούν να περιέχουν επιπλέον πληροφορίες, όπως κατηγορία, ενέργεια, δεδομένα και παραμέτρους. Στην ουσία, το Intent περιγράφει το τι θέλετε να κάνει η εφαρμογή σας.

Συνολικά, τόσο το Bundle όσο και το Intent είναι βασικά εργαλεία για την μεταφορά δεδομένων και τη διαχείριση της αλληλεπίδρασης μεταξύ διάφορων συνιστωσών μιας εφαρμογής Android.

## Ένα μικρό παράδειγμα κώδικα Bundle

Εδώ έχετε ένα απλό παράδειγμα κώδικα που δείχνει πώς να χρησιμοποιήσετε ένα Bundle για να μεταφέρετε ένα ακέραιο αριθμό από ένα Activity σε ένα άλλο:

```
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        int numberToPass = 42;

        // Δημιουργία ενός Bundle και προσθήκη ενός ακέραιου αριθμού
        Bundle bundle = new Bundle();
        bundle.putInt("number_key", numberToPass);

        // Δημιουργία ενός Intent για το δεύτερο Activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtras(bundle);

        // Εκκίνηση του δεύτερου Activity με το Intent
        startActivity(intent);
    }
}
```

Στο παράδειγμα αυτό, ο ακέραιος αριθμός 42 προστίθεται στο Bundle με το κλειδί "number_key". Στη συνέχεια, το Bundle περνάται στο Intent και το δεύτερο Activity εκκινείται με το Intent. Στο δεύτερο Activity, μπορείτε να ανακτήσετε τον ακέραιο αριθμό από το Bundle.

Αυτό είναι ένα απλό παράδειγμα για να δείτε πώς λειτουργεί η χρήση ενός Bundle για τη μεταφορά δεδομένων μεταξύ διαφορετικών συνιστωσών ενός Android εφαρμογής.

## Ένα μικρό παράδειγμα για Intenet

Εδώ έχετε ένα απλό παράδειγμα κώδικα που δείχνει πώς να χρησιμοποιήσετε ένα Intent για να μεταφέρετε δεδομένα από ένα Activity σε ένα άλλο:

1. Πρώτο Activity (FirstActivity.java):

```
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button sendDataButton = findViewById(R.id.sendDataButton);
        sendDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataToSend = "Hello from FirstActivity!";

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("data_key", dataToSend);
                startActivity(intent);
            }
        });
    }
}

```

2. Δεύτερο Activity (SecondActivity.java):

```
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if (intent != null) {
            String receivedData = intent.getStringExtra("data_key");

            TextView receivedDataTextView = findViewById(R.id.receivedDataTextView);
            receivedDataTextView.setText(receivedData);
        }
    }
}

```

Σε αυτό το παράδειγμα, το πρώτο Activity περιέχει ένα κουμπί. Όταν πατηθεί το κουμπί, δημιουργείται ένα Intent που έχει ως στόχο το δεύτερο Activity. Επίσης, μεταφέρει ένα String δεδομένο με το κλειδί "data_key". Στο δεύτερο Activity, το String δεδομένο ανακτάται από το Intent και εμφανίζεται σε ένα TextView.

Αυτό το παράδειγμα δείχνει πώς μπορείτε να χρησιμοποιήσετε το Intent για τη μεταφορά δεδομένων και την εναλλαγή μεταξύ διαφορετικών συνιστωσών ενός Android εφαρμογής.

## Ένα παράδειγμα πως παίρνω τιμή από ένα πεδίο.

Αν υποθέσουμε ότι έχετε ένα EditText πεδίο στο layout του Activity και θέλετε να πάρετε την τιμή που έχει εισαχθεί σε αυτό, μπορείτε να το πετύχετε ως εξής:

1. Layout (activity_main.xml):   
Στο XML layout αρχείο του Activity, θα πρέπει να έχετε ένα EditText πεδίο στο οποίο ο χρήστης μπορεί να εισάγει δεδομένα.

```
<EditText
    android:id="@+id/editText"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter something" />
```

2. Java Code (MainActivity.java):   
Στην κλάση του Activity, μπορείτε να ανακτήσετε την τιμή που έχει εισαχθεί στο πεδίο με τη χρήση της μεθόδου getText() του EditText.

```
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        // Παράδειγμα: Πάρτε την τιμή από το πεδίο όταν πατηθεί ένα κουμπί
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();
                // Κάντε κάτι με την enteredText, όπως εμφανίστε τη σε ένα TextView
            }
        });
    }
}
```

Στο παράδειγμα αυτό, το **editText.getText().toString()** χρησιμοποιείται για να ανακτήσει το κείμενο που έχει εισαχθεί στο EditText πεδίο. Αυτό το κείμενο στη συνέχεια μετατρέπεται σε String με τη χρήση της μεθόδου toString(), και μπορείτε να το χρησιμοποιήσετε όπως επιθυμείτε (π.χ. εμφανίστε το σε ένα TextView ή εκτελέστε άλλες ενέργειες με αυτό).

## Πως εμφανίζω το μήνυμα που πήρα παραπάνω σε ένα Toast μήνυμα;

Εδώ είναι ο κώδικας για να εμφανίσετε το κείμενο που πήρατε από το πεδίο εισαγωγής σε ένα Toast μήνυμα:

```
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();

                // Εμφάνιση του μηνύματος με Toast
                Toast.makeText(MainActivity.this, "Entered Text: " + enteredText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

Στον κώδικα αυτό, η μέθοδος **makeText()** του Toast χρησιμοποιείται για να δημιουργήσει και να εμφανίσει ένα Toast μήνυμα. Ο πρώτος παράμετρος είναι η κλάση που καλεί το Toast (συνήθως το τρέχον Activity), η δεύτερη παράμετρος είναι το κείμενο που θέλετε να εμφανίσετε, και η τρίτη παράμετρος είναι η διάρκεια εμφάνισης του Toast (μπορεί να είναι **Toast.LENGTH_SHORT** ή **Toast.LENGTH_LONG**).

Όταν πατηθεί το κουμπί, το κείμενο που έχει εισαχθεί στο πεδίο εισαγωγής θα εμφανίζεται σε ένα Toast μήνυμα.

## Ένα παράδειγμα κώδικα για το πως παίρνω την εισαγωγή του χρήστη από ένα πεδίο και μετά το υψώνω στην 3 και το εμφανίζω στην οθόνη.

Εδώ έχετε ένα παράδειγμα κώδικα που δείχνει πώς να πάρετε την είσοδο του χρήστη από ένα πεδίο, να την υψώσετε στην τρίτη δύναμη και να την εμφανίσετε στην οθόνη:

```
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Πάρτε την είσοδο του χρήστη από το πεδίο
                String userInput = inputEditText.getText().toString();

                if (!userInput.isEmpty()) {
                    // Μετατροπή της εισόδου σε αριθμό
                    double number = Double.parseDouble(userInput);

                    // Υψώστε τον αριθμό στην τρίτη δύναμη
                    double result = Math.pow(number, 3);

                    // Εμφανίστε το αποτέλεσμα στην οθόνη
                    resultTextView.setText("Result: " + result);
                }
            }
        });
    }
}
```

Στο παραπάνω παράδειγμα, το πεδίο εισαγωγής (EditText) χρησιμοποιείται για την είσοδο του χρήστη, και το αποτέλεσμα εμφανίζεται σε ένα TextView μετά τον υπολογισμό. Ο κώδικας επιβεβαιώνει εάν η είσοδος δεν είναι κενή πριν προσπαθήσει να τη μετατρέψει σε αριθμό. Εάν η μετατροπή είναι επιτυχής, υπολογίζεται η τρίτη δύναμη του αριθμού και το αποτέλεσμα εμφανίζεται στην οθόνη.
