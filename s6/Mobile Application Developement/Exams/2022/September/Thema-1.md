# Επίλυση θέματος 1 Σεπτέμβριος 2022

## Δημιουργούμε το XML στο activity_main.xml όπως το ζητάει στην εκφώνηση (ερώτημα 1 και 2)

Ένα τυπικό xml αρχείο είναι το 

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#0d1d21"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/enterText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="text"
        android:text="Name"
        android:textColor="@color/white"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="128dp"
        android:backgroundTint="#50b2cb"
        android:text="OK"
        android:textColor="@color/black"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## Τώρα πρέπει να γράψουμε τον κώδικα στο MainActivity.java

Ξεκινάμε με την δήλωση του EditText και του Button.

```
    private EditText text;
    private Button button;
```

Συνδέουμε την γραφική διεπαφή με τον κώδικα.
```
        text = findViewById(R.id.enterText);
        button = findViewById(R.id.button);
```

Βάζουμε την ενέργεια που θα κάνει το κουμπί όταν πατηθεί.
```
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Θα πάρει αυτά που έγραψε ο χρήστης
                String name = text.getText().toString();

                // Εμφάνιση του μηνύματος με Toast
                Toast.makeText(MainActivity.this, "WELCOME " + name, Toast.LENGTH_LONG).show();
            }
        });
```

Θα πάρει αυτά που έγραψε ο χρήστης
```
String name = text.getText().toString();
```

Και θα τα εμφανίσει με μήνυμα Toast
```
Toast.makeText(MainActivity.this, "WELCOME " + name, Toast.LENGTH_LONG).show();
```
