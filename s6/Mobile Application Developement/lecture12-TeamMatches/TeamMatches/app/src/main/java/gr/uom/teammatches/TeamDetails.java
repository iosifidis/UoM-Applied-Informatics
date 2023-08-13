package gr.uom.teammatches;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

/*
Αυτός ο κώδικας αποτελεί μέρος της δημιουργίας μιας δραστηριότητας (activity) σε μια εφαρμογή Android.
Η δραστηριότητα αυτή φαίνεται να εμφανίζει λεπτομέρειες για δύο ομάδες (σίγουρα σε κάποιο περιβάλλον αγώνων),
με σχετικές πληροφορίες και εικόνες.
 */
public class TeamDetails extends AppCompatActivity {
    private TeamList tl;
    private final int EMBLEMSIZE = 150;
    private final int ICONSIZE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Πρώτα, ανακτά τα δεδομένα που προήλθαν από την προηγούμενη δραστηριότητα
        // μέσω ενός αντικειμένου Intent. Είναι πολύ πιθανό ότι η δραστηριότητα παίρνει το όνομα
        // των δύο ομάδων και τη διεύθυνση IP μέσω του αντικειμένου Intent.
        Intent intent = getIntent();
        String teamNames[] = intent.getStringExtra("match").split("-");
        String myIp = intent.getStringExtra("ip");

        //Στη συνέχεια, δημιουργεί το αντικείμενο TeamList με την διεύθυνση IP που λήφθηκε από το Intent.
        tl = new TeamList(myIp);

        super.onCreate(savedInstanceState);
        // Συνεχίζει με την κανονική διαδικασία δημιουργίας της δραστηριότητας, καλώντας την μέθοδο setContentView()
        // για να φορτώσει το περιεχόμενο του layout από το αντίστοιχο XML αρχείο.
        setContentView(R.layout.activity_team_details);

        // Αλλάζει το κείμενο δύο TextViews στο layout με τα ονόματα των ομάδων που λήφθηκαν από το Intent.
        ((TextView)findViewById(R.id.textHome)).setText(teamNames[0]);
        ((TextView)findViewById(R.id.textAway)).setText(teamNames[1]);

        // Δημιουργεί δύο ImageView για την εμφάνιση των εμβλημάτων των ομάδων.
        ImageView imageHome = findViewById(R.id.imageHome);
        ImageView imageAway = findViewById(R.id.imageAway);

        // Χρησιμοποιεί τη βιβλιοθήκη Picasso για τη φόρτωση και εμφάνιση των εικόνων των ομάδων μέσα στις ImageView.
        // Η μέθοδος load() φορτώνει την εικόνα από το URL που προκύπτει από την μέθοδο getImageForTeam()
        // του αντικειμένου tl. Η μέθοδος resize() ρυθμίζει το μέγεθος της εικόνας.
        // Τέλος, η μέθοδος into() εφαρμόζει την εικόνα στο ImageView.
        Picasso.with(this).load(tl.getImageForTeam(teamNames[0])).resize(EMBLEMSIZE, 0).into(imageHome);
        Picasso.with(this).load(tl.getImageForTeam(teamNames[1])).resize(EMBLEMSIZE, 0).into(imageAway);

        // Δημιουργεί έναν πίνακα από LinearLayouts που αναπαριστούν τις δύο ομάδες και τους αναθέτει
        // τα αντίστοιχα IDs από το layout.
        LinearLayout layouts[] = new LinearLayout[2];

        layouts[0] = findViewById(R.id.homeLayout);
        layouts[1] = findViewById(R.id.awayLayout);
        int counter=0;

        // Ένα βρόχος επανάληψης προχωρά σε κάθε μία από τις δύο ομάδες
        for(int k = 0; k<2; k++) {
            // Ανακτά τη λίστα παικτών για τη συγκεκριμένη ομάδα χρησιμοποιώντας τη μέθοδο getAllPlayers() από το tl.
            HashMap<String,String> players = tl.getAllPlayers(teamNames[k]);
            for (String pname: players.keySet()){
                // Για κάθε παίκτη στη λίστα των παικτών, δημιουργεί ένα νέο LinearLayout και προσθέτει το όνομα και την εικόνα του παίκτη.
                LinearLayout row = new LinearLayout(this);
                row.setGravity(Gravity.CENTER_VERTICAL);
                row.setPadding(4,8,0,8);
                row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                TextView pText = new TextView(this);
                ImageView pImage = new ImageView(this);
                pImage.setLayoutParams(new LinearLayout.LayoutParams(ICONSIZE, ICONSIZE));

                Picasso.with(this).load(players.get(pname)).into(pImage);
                pImage.setId(1000+counter);

                // Προσθέτει το νέο LinearLayout με τα στοιχεία του παίκτη στο αντίστοιχο LinearLayout της ομάδας.
                pText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                pText.setText(pname);
                pText.setPadding(4,0,4,0);
                pText.setSingleLine(false);
                pText.setMaxLines(3);
                pText.setId(1000+counter);


                pImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

                row.addView(pImage);
                row.addView(pText);
                counter++;

                layouts[k].addView(row);
            }

        }
   }
}