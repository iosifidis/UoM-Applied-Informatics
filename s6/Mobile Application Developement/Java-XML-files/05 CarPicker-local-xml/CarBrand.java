package com.example.carpicker;

import java.util.*;

public class CarBrand {
    // Μεταβλητή Όνομα μάρκας
    private String name;
    // Μεταβλητή για αποθήκευση Λίστας με μοντέλα
    private List<String> models = new ArrayList<String>();

    // Κατασκευαστής
    public CarBrand(String b, String m) {
        name = b;
        models = Arrays.asList(m.split(","));
    }

    // Συγκρίνει τη μεταβλητή name με την είσοδο b χρησιμοποιώντας τη μέθοδο equals και επιστρέφει το αποτέλεσμα.
    public boolean hasName(String b) {
        return name.equals(b);
    }

    // Μέθοδος που επιστρέφει τη λίστα των μοντέλων που σχετίζονται με τη μάρκα αυτοκινήτου ως String
    public String getAllModelsAsString() {
        return models.toString();
    }

    // Λήψη του ονόματος (String) της μάρκας
    public String getName() {
    	return name; 
    }

    // Λήψη της λίστας με τα μοντέλα
    public List<String> getAllModels() {
    	return models;
    }
}
