package com.example.carpicker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.squareup.picasso.Picasso;

public class CarDetails extends AppCompatActivity {
    ImageView myImage;
    Button returnButton;
    TextView fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        // Αρχικοποιεί τη μεταβλητή myImage βρίσκοντας την προβολή ImageView με το αναγνωριστικό
        // myImage στη διάταξη της δραστηριότητας.
        myImage = (ImageView) findViewById(R.id.myImage);

        // Αρχικοποιεί τη μεταβλητή returnButton βρίσκοντας την προβολή με το αναγνωριστικό backBtn
        // στη διάταξη της δραστηριότητας.
        returnButton = findViewById(R.id.backBtn);

        // Αρχικοποιεί τη μεταβλητή fname βρίσκοντας την προβολή με το αναγνωριστικό fullNameTXT
        // στη διάταξη της δραστηριότητας.
        fname = findViewById(R.id.fullNameTXT);

        // Ορίζει την ορατότητα του myImage ImageView σε VISIBLE, καθιστώντας το ορατό στην οθόνη.
        myImage.setVisibility(View.VISIBLE);

        // Ανακτά την πρόθεση που ξεκίνησε αυτή τη δραστηριότητα.
        Intent intent = getIntent();

        // Ανακτά τη συμβολοσειρά επιπλέον με το κλειδί "IMAGE" από την πρόθεση, που είναι το URI εικόνας.
        String imageUri = intent.getStringExtra("IMAGE");

        // ανακτά τη συμβολοσειρά επιπλέον με το κλειδί "FULL_NAME" από την πρόθεση, που είναι το πλήρες όνομα.
        String full_name = intent.getStringExtra("FULL_NAME");

        // Ορίζει το κείμενο του fname TextView στην τιμή της συμβολοσειράς full_name.
        fname.setText(full_name);

        // Χρησιμοποιεί τη βιβλιοθήκη Picasso για να φορτώσει την εικόνα από το καθορισμένο imageUri στο myImage ImageView,
        // αλλάζοντας το μέγεθός της σε πλάτος 300 pixel.
        Picasso.with(getApplicationContext()).load(Uri.parse(imageUri)).resize(300, 0).into(myImage);

        // Ορίζει ένα OnClickListener για την προβολή κουμπιού επιστροφής.
        // Όταν κάνετε κλικ στο κουμπί, θα κληθεί η μέθοδος onClick που ορίζεται στο OnClickListener.
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            // Ολοκληρώνει την τρέχουσα δραστηριότητα και επιστρέφει στην προηγούμενη δραστηριότητα
            // στην πίσω στοίβα όταν κάνετε κλικ στο κουμπί επιστροφής.
            public void onClick(View view) {
                finish();
            }
        });

    }
}