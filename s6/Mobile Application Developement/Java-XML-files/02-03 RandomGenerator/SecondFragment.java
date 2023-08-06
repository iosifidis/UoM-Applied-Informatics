package com.example.randomgenerator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.randomgenerator.SecondFragmentArgs;
import com.example.randomgenerator.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    // Μέθοδος όταν ανοίγει η δεύτερη οθόνη
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Παίρνω το count από προηγούμενη οθόνη
        Integer count = com.example.randomgenerator.SecondFragmentArgs.fromBundle(getArguments()).getUpperBound();

        // Φτιάχνω το νέο μήνυμα το οποίο θέλω να εμφανιστεί στην 2η οθόνη
        String message = "This is a random number between 0 and " + count.toString();

        // Αλλάζω το μήνυμα με το id messageTxt στο νέο μήνυμα που έτιαξα παραπάνω
        binding.messageTxt.setText(message);


        // Παίρνω την τιμή και
        Random rand = new Random();
        Integer result = rand.nextInt(count +1);

        // Θέτω την τιμή παραπάνω στο κείμενο στο κέντρο
        binding.randomTxt.setText(result.toString());

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}