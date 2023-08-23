# Διαδικασία επίλυσης ανάγνωσης από xml αρχείο

Η άσκηση μπορεί να μετατραπεί σε κομμάτια. Θα λυθεί πρώτα σύμφωνα με την εκφώνηση και μετά θα δούμε τις παραλλαγές.

## Δημιουργία του activity_main.xml

Τοποθετούμε ένα Spinner, ένα RadioGroup και ένα Button.

Δημιουργία αλυσίδων και ορισμός περιορισμών
Από το component tree με το πλήκτρο shift πατημένο επιλέγουμε και το pick_car και το cars Στη συνέχεια κάνουμε δεξί κλικ στα επιλεγμένα και επιλέγουμε **Chains-→ Create Horizontal Chain**. Κάνουμε δεξί κλικ έχοντας επιλεγμένα και τα δύο Views και επιλέγουμε **Allign-→ Baselines** ώστε να τα ευθυγραμμίσουμε.   

Στο mainActivity.java (εντός της κλάσης) δημιουργούμε μία μέθοδο ως εξής:

```
public void myOnClickPickBrand(View v){
}
```

Είναι σημαντικό η μέθοδος να είναι public void και να έχει ως παράμετρο ένα view ώστε να μπορέσει να χρησιμοποιηθεί από το ide. Εδώ βλέπουμε έναν άλλον τρόπο να προσθέσουμε λειτουργικότητα σε ένα κουμπί. Φυσικά, μπορούμε να το υλοποιήσουμε και προγραμμτιστικά, χρησιμοποιώντας findViewByID και υλοποιώντας έναν listener. Eπιλέγουμε το κουμπί και αλλάζουμε το attribute onClick, το οποίο πλέον, όπως μπορούμε να παρατηρήσουμε έχει μία επιλογή. Τη μέθοδο myOnClickPickBrand, την οποία και υλοποιήσαμε πριν λίγο. Την ορίζουμε στο onClick.   

Ένας τυπικός κώδικας για το **activity_main.xml** είναι ο παρακάτω:
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Spinner
        android:id="@+id/cars"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:minHeight="48dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/pick_car"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.652" />

    <Button
        android:id="@+id/pick_car"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:onClick="myOnClickPickBrand"
        android:text="Pick a brand"
        app:layout_constraintBaseline_toBaselineOf="@+id/cars"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/cars" />

    <RadioGroup
        android:id="@+id/car_radio"
        android:layout_width="68dp"
        android:layout_height="69dp"
        app:layout_constraintBottom_toTopOf="@+id/cars"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## Πως θα γεμίσουμε τα δεδομένα μας.

Υπάρχει η περίπτωση να είναι στο strings.xml με την μορφή:

```
<string-array name="brands">
    <item>Tomota</item>
    <item>WW</item>
    <item>Fissan</item>
</string-array>
```

και να γίνει η υλοποίηση μεθόδου μέσα στην κλάση CarPicker για να προστεθούν δεδομένα στην λίστα, του τύπου:
```
List<String> getCars(String s){
    List<String> models = new ArrayList<String>();
    switch (s){
        case "Tomota":
            models.add("Kauris");
            models.add("Yamis");
            models.add("Gav14");
            break;
        case "WW":
            models.add("Molf");
            models.add("Solo");
        break;
        default:
            break;
        }
        return models;
}
```
Στην περίπτωσή μας θα γίνει μέσω ενός εξωτερικού αρχείου xml που είτε θα μας το δώσουν είτε θα το δημιουργήσουμε μόνοι μας.   

Δημιουργούμε τον φάκελο assets. **File > New > Folder > Assets Folder** και τον βάζουμε στον κατάλογο root (προεπιλογή). Έτσι οι φάκελοι που θα έχουμε θα είναι manifests, java, assets, res, Gradle Scripts.   

Στη συνέχεια πατώ δεξί πλήκτρο στον φάκελο **assets** και επιλέγω **New > File** και το ονομάζω records.xml. Το αρχείο θα είναι άδειο. Εκεί θα δημιουργήσω τις εγγραφές ως εξής (παράδειγμα).

```
<?xml version="1.0"?>

<records>
    <carBrand>
        <name> Toyota</name>
        <models> Yaris, Auris, Corolla, Augo </models>
    </carBrand>

    <carBrand>
        <name>VW </name>
        <models> Golf, Polo </models>
    </carBrand>

    <carBrand>
        <name>Nissan</name>
        <models> Sunny </models>
    </carBrand>

</records>
```

## Αφού έχουμε τα δεδομένα μας, πρέπει να υλοποιήσουμε τις μεθόδους onCreate και myOnClickPickBrand στην κλάση MainActivity. 

Στην onCreate θα γεμίσουμε το Spinner και στην myOnClickPickBrand θα λάβουμε την επιλογή από το Spinner και θα δημιουργήσουμε δυναμικά ένα RadioGroup όπου θα βάλουμε ένα Listener όπου με το πάτημα ενός RadioButton να δείχνει ένα Toast μήνυμα. Για την υλοποίησή τους, θα πρέπει να υλοποιήσουμε μια κλάση **CarBrand** και μια **CarBrandList** (πιθανό να τις δίνει η εκφώνηση). Ας ξεκινήσουμε την υλοποίησή τους και μετά θα τις χρησιμοποιήσουμε στην MainActivity.

## Υλοποίηση CarBrand

Εδώ είναι μια απλή υλοποίηση της μάρκας του αυτοκινήτου καθώς και τα μοντέλα που έχει.   

Ιδιότητες όνομα της μάρκας και λίστα με τα μοντέλα που διαθέτει η μάρκα αυτή.
```    
    private String name;
    private List<String> models = new ArrayList<String>();
```

Ακολουθεί ο κατασκευαστής. Εδώ διαχωρίζουμε τα μοντέλα με το ενδιάμεσο **,** που υπάρχει. Ίσως να το δίνει και στην εκφώνηση.
```
    public CarBrand(String b, String m) {
        name = b;
        models = Arrays.asList(m.split(","));
    }
```

Συγκρίνει τη μεταβλητή name με την είσοδο b χρησιμοποιώντας τη μέθοδο equals και επιστρέφει true ή false.
```
    public boolean hasName(String b) {
        return name.equals(b);
    }
```

Οι υπόλοιπες μέθοδοι είναι get 
```
    public String getAllModelsAsString() {
        return models.toString();
    }


    public String getName() {
    	return name; 
    }


    public List<String> getAllModels() {
    	return models;
    }
```

## Υλοποίηση CarBrandList

Εδώ είναι λίγο πιο περίπλοκα αλλά όχι κάτι ιδιαίτερο.  

Δημιουργούμε την λίστα με τις μάρκες (αυτή που της ζητείται να επιστρέψει)
```
    ArrayList<CarBrand> cbList = new ArrayList<CarBrand>();
```

Ξεκινάει η υλοποίηση μιας μεθόδου όπου θα σχηματίσει την λίστα.

```
    public CarBrandList(AssetManager assets) {
```

Θα ξεκινήσουμε. Ο κώδικας διαβάζει ένα XML αρχείο με όνομα "records.xml" από τον φάκελο assets και κάνει parse το περιεχόμενό του για να εξάγει τις πληροφορίες του CarBrand. Ως σχόλια στον κώδικα, βλέπουμε τι κάνει η κάθε εντολή.

```
        try {
            

            // Εισάγουμε το αρχείο records.xml από τον φάκελο assets, δημιουργούμε ένα αντικείμενο InputStream
            InputStream is = assets.open("records.xml");

            // Δημιουργούμε ένα νέο DocumentBuilderFactory και DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Φορτώνουμε το αρχείο XML στο αντικείμενο dBuilder χρησιμοποιώντας τη μέθοδο parse(),
            // περνώντας το InputStream με όνομα is.
            Document doc = dBuilder.parse(is);

            // Αποθηκεύει τα αρχικά στοιχεία του αρχείου XML με το όνομα ετικέτας "carBrand" (περιλαμβάνει την μάρκα και τα μοντέλα) 
            // σε ένα NodeList που ονομάζεται nList.
            NodeList nList = doc.getElementsByTagName("carBrand");

            // Επαναλαμβάνεται πάνω από κάθε στοιχείο στο NodeList nList.
            for (int i=0; i< nList.getLength(); i++) {
                // Μέσα στον βρόχο, ανακτά το τρέχον στοιχείο ως αντικείμενο Node με το όνομα node
                Node node = nList.item(i);

                // Ελέγχει αν ο κόμβος είναι τύπου Element.
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Εάν ο κόμβος είναι Element, προχωρά στην εξαγωγή της επωνυμίας και των μοντέλων της μάρκας αυτοκινήτου.

                    // Ανακτά τους θυγατρικούς κόμβους του στοιχείου "όνομα" και τους αποθηκεύει σε ένα NodeList με το όνομα nameNode.
                    NodeList nameNode = ((Element) node).
                            getElementsByTagName("name").item(0).getChildNodes();

                    // Εξάγει το όνομα της επωνυμίας από τον πρώτο θυγατρικό κόμβο του nameNode και το αποθηκεύει σε μια μεταβλητή String που ονομάζεται brand.
                    String brand = nameNode.item(0).getNodeValue();

                    // Ανακτά τους θυγατρικούς κόμβους του στοιχείου "models" και τους αποθηκεύει σε μια NodeList που ονομάζεται modelsNode
                    NodeList modelsNode = ((Element) node).
                            getElementsByTagName("models").item(0).getChildNodes();
                    // Εξάγει τα μοντέλα της μάρκας αυτοκινήτου από τον πρώτο θυγατρικό κόμβο του modelsNode και τα αποθηκεύει σε μια μεταβλητή String με το όνομα models.
                    String models = modelsNode.item(0).getNodeValue();

                    // Δημιουργεί ένα νέο αντικείμενο CarBrand χρησιμοποιώντας την επωνυμία και τις τιμές μοντέλων και το προσθέτει σε μια λίστα με το όνομα cbList
                    cbList.add(new CarBrand(brand, models));
                }

                // Ο βρόχος συνεχίζεται μέχρι να υποβληθούν σε επεξεργασία όλα τα στοιχεία στο nList NodeList.
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```


Η μέθοδος getAllModelsAsString αναζητά μια συγκεκριμένη μάρκα αυτοκινήτου στη λίστα cbList και ανακτά τα μοντέλα που σχετίζονται με αυτήν τη μάρκα ως συμβολοσειρά. Δείτε τα σχόλια τι κάνει η κάθε εντολή.

```
    public String getAllModelsAsString(String b) {
        String s = "";
        for (int i=0; i<cbList.size(); i++) {
            // Ελέγχει εάν το τρέχον αντικείμενο CarBrand (cbList.get(i)) έχει το ίδιο όνομα
            // με την παράμετρο εισόδου b καλώντας τη μέθοδο hasName της κλάσης CarBrand.
            if (cbList.get(i).hasName(b)) {
                // Εάν το τρέχον αντικείμενο CarBrand έχει το καθορισμένο όνομα,
                // ενημερώνει τη μεταβλητή s καλώντας τη μέθοδο getAllModelsAsString
                // της κλάσης CarBrand για να ανακτήσει τα μοντέλα που σχετίζονται
                // με αυτήν την επωνυμία ως συμβολοσειρά.
                s = cbList.get(i).getAllModelsAsString();
            }
        }
        return s;
    }
```

Η μέθοδος getAllBrands εξάγει τα ονόματα όλων των επωνυμιών αυτοκινήτων από τη λίστα cbList και τα επιστρέφει ως ξεχωριστή λίστα συμβολοσειρών.
```
    public List<String> getAllBrands() {
        List<String> temp = new ArrayList<String>();
        for (int i=0; i<cbList.size(); i++) {
            // ανακτά το όνομα του τρέχοντος αντικειμένου CarBrand (cbList.get(i))
            // καλώντας τη μέθοδο getName της κλάσης CarBrand και την προσθέτει στην temp.
            temp.add(cbList.get(i).getName());
        }
        return temp;
    }
```

H μέθοδος getAllModels αναζητά μια συγκεκριμένη μάρκα αυτοκινήτου στη λίστα cbList και ανακτά τα μοντέλα που σχετίζονται με αυτήν τη μάρκα ως λίστα συμβολοσειρών
```
    public List<String> getAllModels(String b) {
        List<String> temp = new ArrayList<String>();
        for (int i=0; i<cbList.size(); i++) {
            // Ελέγχει εάν το τρέχον αντικείμενο CarBrand (cbList.get(i)) έχει το ίδιο όνομα
            // με την παράμετρο εισόδου b καλώντας τη μέθοδο hasName της κλάσης CarBrand.
            // Εάν το τρέχον αντικείμενο CarBrand έχει το καθορισμένο όνομα,
            // ενημερώνει τη μεταβλητή temp καλώντας τη μέθοδο getAllModels της κλάσης CarBrand
            // για να ανακτήσει τα μοντέλα που σχετίζονται με αυτήν την επωνυμία ως λίστα συμβολοσειρών.
            if (cbList.get(i).hasName(b)) {
                temp = cbList.get(i).getAllModels();
            }
        }
        return temp;
    }
```

## Αφού υλοποιήσαμε τις δυο κλάσεις, πάμε να ολοκληρώσουμε με την MainActivity.java.

Στην αρχή δημιουργώ αντικείμενο CarBrandList που θα το χρησιμοποιήσω σε κάποια μέθοδο και ορίζουμε το RadioGroup εδώ για να το δούν όλες οι μέθοδοι.
```
    private CarBrandList cbl; 
    private RadioGroup rg;
```

Στην **onCreate**, ο κώδικας αρχικοποιεί μια CarBrandList, ορίζει την προβολή περιεχομένου της δραστηριότητας, δημιουργεί ένα Spinner, το συμπληρώνει με επωνυμίες χρησιμοποιώντας έναν ArrayAdapter και προετοιμάζει μια RadioGroup. Αυτό ρυθμίζει τα στοιχεία διεπαφής χρήστη για τη δραστηριότητα, επιτρέποντας στον χρήστη να επιλέξει μια μάρκα αυτοκινήτου από το Spinner και να αλληλεπιδράσει με το RadioGroup.

```
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Στο αντικείμενο cbl περνάω το αρχείο με τα brands με την getAssets()
        cbl = new CarBrandList(getAssets());

        //Δημιουργούμε το Spinner και το γεμίζουμε με τα brands (xml)
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

        // Αρχικοποιεί ένα γραφικό στοιχείο RadioGroup που ονομάζεται car_radio
        // βρίσκοντας την προβολή με το αναγνωριστικό car_radio από τη διάταξη xml της δραστηριότητας
        rg = (RadioGroup) findViewById(R.id.car_radio);
    }
```

Τώρα πρέπει να υλοποιήσουμε την myOnClickPickBrand. Εναλλακτικά μπορώ να την βάλω μέσα στην OnCreate με έναν Listener. Δείτε τις παραλλαγές.

```
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
            RadioButton rb = new RadioButton(this); // Φτιάχνω ένα radio button ανάλογα με τι μέγεθος θα έχει η λίστα
            rb.setText(allModels.get(i)); // Προσθέτων το κείμενο που πήρα από την λίστα ως κείμενο σε radiobutton
            rb.setId(100+i); // Βάζω ένα id γιατί πιθανό να το ψάξω με το id
            rg.addView(rb); // Το προσθέτω στο radiogroup
        }

        // Φτιάχνω έναν Listener που θα τον υλοποιήσω εδώ μέσα
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Φτιάχνω ένα αντικείμενο Radio button για να βρεί τι επέλεξα
                RadioButton rb = (RadioButton) findViewById(checkedId);
                //  εμφανίζει ένα toast με το μοντέλο που επιλέχθηκε
                Toast.makeText(getApplicationContext(),
                        "The selected model is " + brand + ": " + rb.getText()
                        , Toast.LENGTH_SHORT).show();
            }
        });

    }
```

Και εδώ τελειώνει η άσκηση.
