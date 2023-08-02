package com.example.randomgenerator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.randomgenerator.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    /* Δημιουργείται μια μεταβλητή binding τύπου FragmentFirstBinding, η οποία είναι μια αναφορά (reference)
    στο δεσμευμένο (bound) layout του Fragment. Η κλάση FragmentFirstBinding δημιουργείται αυτόματα από τον Compiler
    του Android, βάσει του layout αρχείου XML που συσχετίζεται με το Fragment (συνήθως με το ίδιο όνομα με το Fragment
    και κατάληξη "Binding"). */
    private FragmentFirstBinding binding;

    // Η μέθοδος onCreateView() εκτελείται κατά τη δημιουργία του layout του Fragment και επιστρέφει την View (προβολή) που περιέχει το layout.
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        /* Εδώ δημιουργείται ένα νέο αντικείμενο FragmentFirstBinding με βάση το layout του Fragment.
        Η μέθοδος inflate() παίρνει τρία ορίσματα:
         - inflater: Το αντικείμενο LayoutInflater, που χρησιμοποιείται για να μετατραπεί το XML layout αρχείο
         σε αντικείμενο View.
         - container: Ο παραγωγικός κοντέινερ (ViewGroup) όπου το Fragment θα προσαρτηθεί στο UI.
         - false: Ένδειξη αν το fragment πρέπει να προσαρτηθεί στο ViewGroup κατά τη διάρκεια της δημιουργίας του.
         Εδώ χρησιμοποιείται ως false, καθώς το fragment θα προσαρτηθεί μέσω της επιστρεφόμενης View.*/
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Παίρνω το κείμενο και το βάζω σε μια μεταβλητή count
                Integer count = Integer.parseInt(binding.numberTxt.getText().toString());

                // To actionFirstFragmentToSecondFragment έκανε μετάβαση από το FragmentFist στο FragmentSecond.
                // Η μετάβαση αυτή παίρνει ένα argument

                // Ορίζω μια νέα ενέργεια (action) να περάσω την παράμετρο count στην κλάση FirstFragmentDirections
                // στη μέθοδο actionFirstFragmentToSecondFragment
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(count);


                // Στην μετάβαση πρέπει να περάσω μια παράμετρο
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(action);
            }
        });
        // Προσθέτω τα 2 παρακάτω binding.
        // Η υλοποίηση αυτού, εμφανίζει ένα μήνυμα στην οθόνη
        binding.toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(),
                        "Μπρό! Welcome to the Random Generator", // Κείμενο να εμφανίσει
                        Toast.LENGTH_LONG); // Μεγάλο κείμενο
                myToast.show(); // Εμφάνιση μηνύματος
            }
        });

        // Η υλοποίηση αυτού, δίνει λειτουργία στο κουμπί που πατιέται.
        binding.countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseCounter(); // Φτιάχνω μια μέθοδο που υλοποιώ παρακάτω
            }
        });

    }

    // Υλοποιώ μια μέθοδο που χρησιμοποιείται με το πάτημα του κουμπιού.
    // Ουσιαστικά αυξάνει το νούμερο που εμφανίζεται στο κέντρο της οθόνης.
    private void increaseCounter() {
        // Παίρνω το κείμενο με το id numberTxt, το κάνω Int και το αποθηκεύω σε μια μεταβλητή int
        Integer count = Integer.parseInt(binding.numberTxt.getText().toString());
        count++; // Αυξάνω κατά ένα
        binding.numberTxt.setText(count.toString()); // προσθέτω το νέο count αφού το κάνω string στο id numberTxt
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}