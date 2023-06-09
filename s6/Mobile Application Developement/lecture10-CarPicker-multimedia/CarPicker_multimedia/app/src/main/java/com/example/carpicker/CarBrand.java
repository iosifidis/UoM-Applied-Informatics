package com.example.carpicker;

import java.util.*;

public class CarBrand {
    // Μεταβλητή Όνομα μάρκας
    private String name;

    // Μεταβλητή για αποθήκευση Λίστας με μοντέλα
    private List<String> models = new ArrayList<String>();

    // δηλώνει μια μεταβλητή media, η οποία είναι ένα αντικείμενο HashMap με ζεύγη κλειδιού-τιμής.
    private HashMap<String, Media> media = new HashMap<>();

    // Κατασκευαστής
    public CarBrand(String brand, String models, String images) {
        name = brand;
        this.models = Arrays.asList(models.split(","));
        String[] imageArray = images.split(",");
        for (int i=0; i<this.models.size(); i++) {
            media.put(this.models.get(i),new Media(imageArray[i]));
        }
    }

    // Λήψη του αντικειμένου Media με βάση το κλειδί key
    public Media getMedia(String key){
        return this.media.get(key);
    }

    // Συγκρίνει τη μεταβλητή name με την είσοδο b χρησιμοποιώντας τη μέθοδο equals και επιστρέφει το αποτέλεσμα.
    public boolean hasName(String b) {
        return name.equals(b);
    }
    // Λήψη του ονόματος (String) της μάρκας
    public String getName() {return name; }

    // Λήψη της λίστας με τα μοντέλα
    public List<String> getAllModels() {return models;}
}
