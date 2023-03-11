package com.example.randomgenerator2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.randomgenerator2.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    // Προσθέτω τα 2 παρακάτω binding.
    // Η υλοποίηση αυτού, εμφανίζει ένα μήνυμα στην οθόνη
        binding.toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(),
                        "Welcome to the Random Generator", // Κείμενο να εμφανίσει
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