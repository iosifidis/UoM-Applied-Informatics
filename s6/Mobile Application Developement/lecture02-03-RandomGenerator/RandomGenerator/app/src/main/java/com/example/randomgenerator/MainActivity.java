package com.example.randomgenerator;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.randomgenerator.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Εδώ δημιουργείται ένα αντικείμενο ActivityMainBinding που συνδέεται με το layout της δραστηριότητας.
        Αυτό γίνεται με τη βοήθεια της κλάσης ActivityMainBinding, η οποία δημιουργείται από τον Compiler του
        Android ανάλογα με το layout αρχείο XML που ορίζει τη διάταξη της δραστηριότητας.*/
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        /* Καθορίζει το περιεχόμενο της δραστηριότητας ώστε να εμφανίζεται το layout που δημιουργήθηκε μέσω του
        ActivityMainBinding. Το getRoot() επιστρέφει την κεντρική ρίζα του layout, δηλαδή τον παραπάνω-αναφερθέντα
        ριζικό (root) της ιεραρχίας του layout. */
        setContentView(binding.getRoot());

        /* Θέτει το Toolbar που έχει οριστεί στο layout ως τη γραμμή ενεργειών της δραστηριότητας, για να πετύχει
        την προσαρμογή της επικεφαλίδας με τη γραμμή ενεργειών. */
        setSupportActionBar(binding.toolbar);

        /* Βρίσκει τον NavController που χρησιμοποιείται για τον χειρισμό της πλοήγησης (navigation)
        στον περιεχόμενο του Fragment που ορίζεται με το ID nav_host_fragment_content_main στο layout. */
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        /* Δημιουργεί μια διαμόρφωση (configuration) της γραμμής ενεργειών (app bar) χρησιμοποιώντας τον NavController που βρέθηκε προηγουμένως. */
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        // Διαμορφώνει τη γραμμή ενεργειών (app bar) ώστε να ανταποκρίνεται στις ενέργειες πλοήγησης που γίνονται μέσω του NavController.
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        /* Η επόμενη περιοχή του κώδικα είναι υπεύθυνη για τον χειρισμό της ενέργειας κλικ στο FloatingActionButton (FAB).
        Όταν γίνει κλικ στο FAB, θα εμφανιστεί ένα Snackbar με το μήνυμα "Replace with your own action" και θα εμφανιστεί
        μια ενέργεια "Action". Αυτό θα είναι κενό, καθώς η παράμετρος null περνιέται στη μέθοδο setAction(),
        οπότε δεν θα εκτελεστεί κάποια επιπλέον ενέργεια όταν κάνετε κλικ στο "Action". */
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}