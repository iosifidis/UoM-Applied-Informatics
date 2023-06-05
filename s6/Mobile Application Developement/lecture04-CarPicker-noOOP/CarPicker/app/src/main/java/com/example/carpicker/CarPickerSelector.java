package com.example.carpicker;

import java.util.ArrayList;
import java.util.List;

public class CarPickerSelector {

    // Λίστα που παίρνει μια μάρκα (brand) και επιστρέφει μια λίστα από μοντέλα.
    List<String> getCars(String brand){

        // Φτιάχνω μια λίστα με τα μοντέλα (μάρκες)
        List<String> models = new ArrayList<String>();

        // Αν η μάρκα είναι Toyota, επέστρεψε
        if (brand.equals("Toyota")){
            models.add("Yaris");
            models.add("Auris");
        }

        // Αν η μάρκα είναι VW, επέστρεψε
        if (brand.equals("VW")){
            models.add("Golf");
            models.add("Polo");
        }

        // Αν η μάρκα είναι Nissan, επέστρεψε τιποτα

        // Επιστρέφω τα μοντέλα
        return models;
    }

}
