# Επίλυση θέματος 2 Σεπτέμβριος 2022

## Δημιουργούμε το xml με ένα EditText και ένα Κουμπί. Το activity_main.xml θα είναι της μορφής:

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/number"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="text"
        android:text="Enter numbers (eg 1*2)"
        app:layout_constraintBottom_toTopOf="@+id/calc"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/calc"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="296dp"
        android:text="CALCULATE"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## Στην MainActivity.java εισάγουμε ως αντικείμενο το κουμπί και το EditText.

```
   // Φτιάχνουμε 2 αντικείμενα (κείμενο και κουμπί)
    private EditText number;
    private Button button;
```

Συνδέουμε την γραφική διεπαφή με τον κώδικα

```
number = findViewById(R.id.number);
button = findViewById(R.id.calc);
```

Παίρνουμε το κείμενο που έχει δωθεί από τον χρήστη
```
String num = number.getText().toString();
```

Κάνουμε το κουμπί να μεταφερθεί στην επόμενη οθόνη
```
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });
```

Εκτός της OnCreate στέλνουμε το κείμενο στην επόμενη οθόνη.
```
    public void sendSecondActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("NUMBER", number.getText().toString());
        startActivity(intent);
    }
```

## Φτιάχνουμε το SecondActivity.java το οποίο θα μας δημιουργήσει και ένα activity_second.xml. Αυτό το αρχείο θα έχει την μορφή.
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SecondActivity">

    <TextView
        android:id="@+id/result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Result"
        android:textSize="34sp"
        app:layout_constraintBottom_toTopOf="@+id/backbtn"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/backbtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="248dp"
        android:text="BACK"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.493"
        app:layout_constraintStart_toStartOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## Ξεκινάμε το SecondActivity.java.  

Bάζουμε ένα κείμενο και ένα κουμπί ως αντικείμενα
```
    private TextView result;
    private Button backbtn;
```

Συνδέουμε την γραφική διεπαφή με τον κώδικα
```
        result = findViewById(R.id.result);
        backbtn = findViewById(R.id.backbtn);
```

Παίρνουμε το κείμενο που έχει δοθεί από τον χρήστη από την πρώτη οθόνη
```
        Intent intent = getIntent();
        String a_num = intent.getStringExtra("NUMBER");
```

Φτιάχνουμε ένα αντικείμενο της κλάσης StringMultiplier (θα την δούμε στο τέλος) για να κόψει το κείμενο στην μέση
```
        StringMultiplier sm = new StringMultiplier(a_num);
```

Χρησιμοποιούμε την μέθοδο που θα πολλαπλασιάσει τους δυο αριθμούς
```
        double res = sm.multi();
```

Μετατρέπουμε το αποτέλεσμα σε String
```
        String finalres = String.valueOf(res);
```

Το παρουσιάζουμε στην οθόνη
```
        result.setText(a_num + " = " + finalres);
```

Βάζουμε το κουμπί να γυρνάει στην αρχική οθόνη (δεν το ζητάει)
```
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
```

## Θα υλοποιήσουμε την StringMultiplier

Φτιάχνουμε 2 αντικείμενα (αυτά που θα κάνουμε τις πράξεις)
```
    private String num1;
    private String num2;
```

Στον κατασκευαστή εισάγουμε το αλφαριθμιτικό και πρέπει να το χωρίσουμε
```
    public StringMultiplier(String inputString) {
        // Φτιάχνουμε έναν πίνακα με τα δυο αντικείμενα που χωρίζεται με \\*
        String[] parts = inputString.split("\\*");

        // Θέτει τον πρώτο αριθμό στο αντικείμενο 1 και τον δεύτερο στο αντικείμενο 2
        this.num1 = parts[0];
        this.num2 = parts[1];
    }
```

Η μέθοδος multi που πολλαπλασιάζει τους δυο αριθμούς
```
    public double multi() {
        try {
            // Αφού τους μετατρέχει σε double τους πολλαπλασιάζει και επιστρέφει το αποτέλεσμα.
            double result = Double.parseDouble(num1) * Double.parseDouble(num2);
            return result;
        } catch (NumberFormatException e) {
            return -1; // Or any other error indicator you prefer
        }
    }
```
