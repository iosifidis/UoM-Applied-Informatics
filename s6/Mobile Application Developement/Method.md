# Μέθοδος επίλυσης ασκήσεων εξετάσεων

Οι εξετάσεις αποτελούνται από 2 τύπους ασκήσεων. Η μια είναι απλή και πιάνει 2 μονάδες και η άλλη πιο σύνθετη που πιάνει 8 μονάδες. Εδώ θα δείτε την μέθοδο επίλυση ασκήσεων.

## Εύκολη άσκηση

Η απλή άσκηση ζητάει να φτιαχτεί ένα activity με ένα απλό EditText (το ονομάζει TextBox) που να δέχεται μια είσοδο από τον χρήστη και ένα κουμπί PRESS ME που να λαμβάνει τα δεδομένα, να τα επεξεργάζεται (αν ζητάει να γίνουν πράξεις) και στην συνέχεια να τα εμφανίζει στην οθόνη είτε στη θέση κάποιου TextView είτε σε Toast.

1. Φτιάχνω το **activity_main.xml** όπως μου το περιγράφουν στην εκφώνηση.   

Προσοχή δίνω:  

- Χρώμα background, θα έχω επιλεγμένο το background και αναζητώ την λέξη background ή στον κώδικα εισάγω 

```
android:background="#fff322"
```

πριν το **tools:context=".MainActivity"**

- Χρώμα για κουμπί, έχω επιλεγμένο το κουμπί και αναζητώ backgroundTint ή στον κώικα εισάγω

```
android:backgroundTint="#7777cb"
```

- Αλλάζω ΟΛΑ τα id των αντικειμένων που εισάγω σε κάτι που να δηλώνει τι κάνει το αντικείμενο. Αυτά θα τα χρησιμοποιήσω στον κώδικα java.

2. Στο αρχείο της **MainActivity.java**   

- Φτιάχνω τα αντικείμενα EditText και Button

```
private EditText editText;   
private Button button;
```

- Τα συνδέω με την διεπαφή

```
editText = findViewById(R.id.editText);   
button = findViewById(R.id.button);
```

- Βάζω ένα Listener στο button. Εκεί θα λάβω το κείμενο που έκανε εισαγωγή ο χρήστης καθώς και το μήνυμα που θα εμφανίζεται με το Toast.

```
button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();

                // Εμφάνιση του μηνύματος με Toast
                Toast.makeText(MainActivity.this, "Entered Text: " + enteredText, Toast.LENGTH_SHORT).show();
            }
        });
```

- Περίπτωση που εισάγει νούμερο και χρειαστεί πράξη, πρέπει να το μετατρέψετε σε Integer ή καλύτερα σε Double και μετά να κάνετε την πράξη.

```
button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                if (input.isEmpty()) {
                    number.setError("Please enter a number");
                } else {
                    double num = Double.parseDouble(input);
                    double sqrt = (double) Math.sqrt(num);

                    Toast.makeText(MainActivity.this, "SQRT(" + num + ") = " + sqrt, Toast.LENGTH_SHORT).show();
                }
            }
        });
```

- Υπάρχει περίπτωση να ζητηθεί να κάνει την εμφάνιση σε κάποιο TextView. Φροντίστε να το εισάγετε στο activity_main.xml να εισάγετε ένα TextView χωρίς κείμενο και στον κώδικα στο MainActivity.java στο button listener να εισάγετε κώδικα όπως ο παρακάτω

```
button.setOnClickListener(v -> message.setText("My name is: Stathis"));
```

## Δύσκολη άσκηση

Και η άσκηση αυτή δεν είναι ιδιαίτερα δύσκολη. Απλά έχει περισσότερα βήματα.
