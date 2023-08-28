# Διαδικασία επίλυσης άσκησης ανάγνωσης από xml αρχείο (2 activities. RadioGroup σε Spinner)

Εδώ θα δούμε μια παραλλαγή της άσκησης. Θα γίνει χρήση τοπικά του xml αρχείου. Όμως θα έχουμε 2 Activies. Η κύρια οθόνη θα έχει 2 elements (RadioGroup και Button). Επιλέγουμε κάτι στο RadioGroup και με το πάτημα του κουμπιού, οδηγούμαστε σε δεύτερη οθόνη, όπου δημιουργείται ένα Spinner. Εκεί επιλέγουμε και με το πάτημα ενός κουμπιού εμφανίζεται ένα Toast μήνυμα. Με πλήκτρο BACK επιστρέφουμε στην αρχική οθόνη. Εδώ θα χρησιμοποιήσουμε Listener.

## Δημιουργία του activity_main.xml

Τοποθετούμε ένα RadioGroup και ένα Button.

Ένας τυπικός κώδικας για το **activity_main.xml** είναι ο παρακάτω:
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <RadioGroup
        android:id="@+id/car_radio"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toTopOf="@+id/pick_car"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/pick_car"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="160dp"
        android:text="Pick a brand"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## Πως θα γεμίσουμε τα δεδομένα μας.

Στην περίπτωσή μας θα γίνει μέσω ενός εξωτερικού αρχείου xml που είτε θα μας το δώσουν είτε θα το δημιουργήσουμε μόνοι μας.   

Δημιουργούμε τον φάκελο assets. **File > New > Folder > Assets Folder** και τον βάζουμε στον κατάλογο root (προεπιλογή). Έτσι οι φάκελοι που θα έχουμε θα είναι οι **manifests, java, assets, res, Gradle Scripts**.   

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

## Αφού έχουμε τα δεδομένα μας, πρέπει να υλοποιήσουμε τις κλάσεις CarBrand και CarBrandList

### Υλοποίηση CarBrand

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

### Υλοποίηση CarBrandList

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
            

            // Εισάγουμε το αρχείο records.xml από τον φάκελο assets, δημιουργούμε ένα 
            // αντικείμενο InputStream
            InputStream is = assets.open("records.xml");

            // Δημιουργούμε ένα νέο DocumentBuilderFactory και DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Φορτώνουμε το αρχείο XML στο αντικείμενο dBuilder χρησιμοποιώντας τη 
            // μέθοδο parse(), περνώντας το InputStream με όνομα is.
            Document doc = dBuilder.parse(is);

            // Αποθηκεύει τα αρχικά στοιχεία του αρχείου XML με το όνομα ετικέτας 
            // "carBrand" (περιλαμβάνει την μάρκα και τα μοντέλα) σε ένα 
            // NodeList που ονομάζεται nList.
            NodeList nList = doc.getElementsByTagName("carBrand");

            // Επαναλαμβάνεται πάνω από κάθε στοιχείο στο NodeList nList.
            for (int i=0; i< nList.getLength(); i++) {
                // Μέσα στον βρόχο, ανακτά το τρέχον στοιχείο ως αντικείμενο Node 
                // με το όνομα node
                Node node = nList.item(i);

                // Ελέγχει αν ο κόμβος είναι τύπου Element.
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Εάν ο κόμβος είναι Element, προχωρά στην εξαγωγή της επωνυμίας 
                    // και των μοντέλων της μάρκας αυτοκινήτου.

                    // Ανακτά τους θυγατρικούς κόμβους του στοιχείου "όνομα" και τους 
                    // αποθηκεύει σε ένα NodeList με το όνομα nameNode.
                    NodeList nameNode = ((Element) node).
                            getElementsByTagName("name").item(0).getChildNodes();

                    // Εξάγει το όνομα της επωνυμίας από τον πρώτο θυγατρικό κόμβο 
                    // του nameNode και το αποθηκεύει σε μια μεταβλητή String που 
                    // ονομάζεται brand.
                    String brand = nameNode.item(0).getNodeValue();

                    // Ανακτά τους θυγατρικούς κόμβους του στοιχείου "models" και 
                    // τους αποθηκεύει σε μια NodeList που ονομάζεται modelsNode
                    NodeList modelsNode = ((Element) node).
                            getElementsByTagName("models").item(0).getChildNodes();
                    
                    // Εξάγει τα μοντέλα της μάρκας αυτοκινήτου από τον πρώτο
                    // θυγατρικό κόμβο του modelsNode και τα αποθηκεύει σε μια
                    // μεταβλητή String με το όνομα models.
                    String models = modelsNode.item(0).getNodeValue();

                    // Δημιουργεί ένα νέο αντικείμενο CarBrand χρησιμοποιώντας την 
                    // επωνυμία και τις τιμές μοντέλων και το προσθέτει σε μια 
                    // λίστα με το όνομα cbList
                    cbList.add(new CarBrand(brand, models));
                }

                // Ο βρόχος συνεχίζεται μέχρι να υποβληθούν σε επεξεργασία όλα 
                // τα στοιχεία στο nList NodeList.
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
            // Ελέγχει εάν το τρέχον αντικείμενο CarBrand (cbList.get(i)) έχει το ίδιο 
            // όνομα με την παράμετρο εισόδου b καλώντας τη μέθοδο hasName της 
            // κλάσης CarBrand.
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
            // καλώντας τη μέθοδο getName της κλάσης CarBrand και την προσθέτει 
            // στην temp.
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
            // Ελέγχει εάν το τρέχον αντικείμενο CarBrand (cbList.get(i)) έχει το 
            // ίδιο όνομα με την παράμετρο εισόδου b καλώντας τη μέθοδο hasName της 
            // κλάσης CarBrand. Εάν το τρέχον αντικείμενο CarBrand έχει το 
            // καθορισμένο όνομα, ενημερώνει τη μεταβλητή temp καλώντας τη μέθοδο 
            // getAllModels της κλάσης CarBrand για να ανακτήσει τα μοντέλα που 
            // σχετίζονται με αυτήν την επωνυμία ως λίστα συμβολοσειρών.
            if (cbList.get(i).hasName(b)) {
                temp = cbList.get(i).getAllModels();
            }
        }
        return temp;
    }
```

## Αφού υλοποιήσαμε τις δυο κλάσεις, πάμε να ολοκληρώσουμε με την MainActivity.java.

Δηλώνουμε τα elements.

```
    private Button button;
    private RadioGroup rg;
    private CarBrandList cbl;
    private String selectedBrand;
```

Η onCreate είναι αλλάζει ελαφρώς, αφού θα βάλω ένα listener για το RadioGroup για να λάβω την επιλογή. Στο τέλος θα πρέπει να βάλουμε το button listener.

```
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ένωση με την γραφική διεπαφή
        rg = (RadioGroup) findViewById(R.id.car_radio);
        button = (Button) findViewById(R.id.pick_car);

        // Στο αντικείμενο cbl περνάω το αρχείο με τα brands με την getAssets()
        cbl = new CarBrandList(getAssets());

        // Σύνδεση του GUI με την κλάση. Πρέπει να λάβω όλες τις μάρκες σε λίστα 
        // από το αρχείο xml
        List<String> allBrands = cbl.getAllBrands();

        // Πρέπει να περάσουμε τα μοντέλα στο GUI στο radiogroup
        rg.removeAllViews(); // το αδειάζουμε

        // Κατασκευή του radiobutton
        for(int i=0;i<allBrands.size();i++) {
            // Φτιάχνω ένα radio button ανάλογα με τι μέγεθος θα έχει η λίστα
            RadioButton rb = new RadioButton(this); 
            // Προσθέτων το κείμενο που πήρα από την λίστα ως κείμενο σε radiobutton
            rb.setText(allBrands.get(i)); 
            rb.setId(100+i); // Βάζω ένα id γιατί πιθανό να το ψάξω με το id
            rg.addView(rb); // Το προσθέτω στο radiogroup
        }

        // Φτιάχνω έναν Listener που θα τον υλοποιήσω εδώ μέσα
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Φτιάχνω ένα αντικείμενο Radio button για να βρεί τι επέλεξα
                RadioButton rb = (RadioButton) findViewById(checkedId);
                // Assign the value to the selectedBrand variable
                selectedBrand = (String) rb.getText();
            }
        });

        // Ένα listener για το κουμπί για μετακίνηση στην επόμενη οθόνη
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });
    }
```

Και δημιουργώ το Intent (εκτός onCreate) για να στείλω την επιλογή στο Spinner στην επόμενη οθόνη.

```
    public void sendSecondActivity(View view){

        // Φτιάχνουμε το Intent και τα στέλνουμε στο δεύτερο activity.
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("BRAND", selectedBrand);
        startActivity(intent);
    }
```

## Υλοποιούμε την SecondActivity.java και μαζί το activity_second.xml.

Επιλέγουμε **New > Activity > Empty views Activity** και δίνουμε το όνομα SecondActivity (θα δημιουργηθεί και ένα xml με όνομα activity_second).   

- Ας ξεκινήσουμε από το xml. Από την εκφώνηση θα ζητηθούν 2 elements. Ένα RadioGroup που θα δείχνει τα μοντέλα της μάρκας αυτοκινήτων, και από κάτω ένα κουμπί BACK για να επιστρέψει στην προηγούμενη οθόνη (activity).   

Ας γεμίσουμε το xml πρώτα. Ένας τυπικός κώδικας είναι ο παρακάτω:  

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SecondActivity">

    <Spinner
        android:id="@+id/cars"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:minHeight="48dp"
        app:layout_constraintBottom_toTopOf="@+id/backButton"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.184"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.37" />

    <Button
        android:id="@+id/backButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="160dp"
        android:text="BACK"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent" />

    <Button
        android:id="@+id/pickButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pick a model"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.577"
        app:layout_constraintStart_toEndOf="@+id/cars"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.257" />

    <TextView
        android:id="@+id/selectedBrand"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        app:layout_constraintBottom_toTopOf="@+id/cars"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

- Ας γεμίσουμε το SecondActibity.java.

Καταρχήν τις ιδιότητες.
```
    private Button button;
    private Button pickModel;
    private Spinner dropdown;
    private CarBrandList cbl;
    private TextView selectedBrand; // Αυτό δεν χρειάζεται. Θέμα ομορφιάς
```

Στην συνέχεια ας τις ενώσουμε στην onCreate με την γραφική διεπαφή.
```
        button = (Button) findViewById(R.id.backButton);
        pickModel = (Button) findViewById(R.id.pickButton);
        dropdown = (Spinner) findViewById(R.id.cars);
        
        // Αυτό δεν χρειάζεται. Θέμα ομορφιάς
        selectedBrand = findViewById(R.id.selectedBrand);
```

Στην συνέχεια λαμβάνουμε το Intent και το αποθηκεύουμε.
```
        // Στην συνέχεια λαμβάνουμε το Intent και το αποθηκεύουμε.
        Intent intent = getIntent();
        String a_brand = intent.getStringExtra("BRAND");
//        List<String> a_brands = getIntent().getStringArrayListExtra("BRANDS");
        cbl = new CarBrandList(getAssets());

	// Αυτό είναι θέμα ομορφιάς για να φαίνεται στον τίτλο τι επέλεξε.
        selectedBrand.setText("The selected brand is " + a_brand + ".");
```

Στην συνέχεια αντιγράφουμε τον κώδικα όπως ήταν και στην αρχική άσκηση. Δηλαδή πρέπει να γεμίσω το Spinner και με την επιλογή να μου δείχνει ένα μήμυμα Toast.   
Μετά την πρώτη δοκιμή, παρατήρησα ότι όταν άνοιγε η οθόνη, έδειχνε την προεπιλεγμένη τιμή (που είναι λάθος). Γι'αυτό έβαλα κουμπί που θα εμφανίζει το μήνημα Toast, μετά την επιλογή. Τον αρχικό κώδικα, θα τον παραθέσω με σχόλια. 
```
        // Δημιουργεί έναν ArrayAdapter που θα χρησιμοποιηθεί για τη συμπλήρωση 
        // του Spinner με δεδομένα. Ο ArrayAdapter αρχικοποιείται με την τρέχουσα 
        // δραστηριότητα (this), τον πόρο διάταξης για κάθε στοιχείο Spinner και τη 
        // λίστα των brands που ελήφθησαν από το CarBrandList cbl χρησιμοποιώντας 
        // τη μέθοδο getAllBrands.
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        cbl.getAllModels(a_brand));
        dropdown.setAdapter(arrayAdapter);
```

Ενέργεια επιλογής αντικειμένου από τον Spinner. Ο κώδικας είναι με σχόλια γιατί δεν το χρησιμοποίησα. Όταν βλέπαμε την 2η οθόνη, έδειχνε στο μήνυμα Toast ΠΑΝΤΑ την πρώτη επιλογή. Μετά που επέλεγα από το Spinner τότε έδειχνε αυτό που επέλεγα. Οπότε "γενικά" αυτό είναι λάθος. Για το λόγο αυτό, πρόσθεσα και ένα κουμπί.
```
// dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, 
int position, long id) {
//       String selectedOption = dropdown.getSelectedItem().toString();
//       Toast.makeText(getApplicationContext(),
//           "The selected model is " + a_brand + ": " + selectedOption
//           , Toast.LENGTH_SHORT).show();
//       }
//
//       @Override
//       public void onNothingSelected(AdapterView<?> adapterView) {
//           // Τίποτα εδώ
//       }
//  });     
```

Εδώ έχουμε την υλοποίηση των Listener. Ο πρώτος είναι για το Spinner και ο δεύτερος είναι για το κουμπί επιστροφής.       
```
	// Ένας listener στο Spinner. Με την επιλογή του, δείχνει στην οθόνη 
	// την επιλεγμένη τιμή.
        pickModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedOption = dropdown.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),
                        "The selected model is " + a_brand + ": " + selectedOption,
                        Toast.LENGTH_SHORT).show();
            }
        });
                
        // Κουμπί επιστροφής
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
```

Και η άσκηση τελειώνει.

