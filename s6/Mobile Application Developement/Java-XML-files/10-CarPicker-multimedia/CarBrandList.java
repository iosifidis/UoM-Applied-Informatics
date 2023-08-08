package com.example.carpicker;

import java.util.*;

public class CarBrandList {
    // Δημιουργούμε την λίστα με τις μάρκες
    ArrayList<CarBrand> cbList = new ArrayList<CarBrand>();

    // ο κατασκευαστής της κλάσης CarBrandList αρχικοποιεί μια παρουσία της κλάσης
    // ανακτώντας δεδομένα από ένα τελικό σημείο υπηρεσίας Ιστού.
    // Η κλάση OkHttpHandler χρησιμοποιείται για τον χειρισμό του αιτήματος HTTP
    // και τα ανακτημένα δεδομένα αποθηκεύονται στη μεταβλητή cbList,
    // η οποία πιθανώς περιέχει μια λίστα αντικειμένων CarBrand.
    public CarBrandList(String ip) {

        // Κατασκευάζει μια συμβολοσειρά URL συνενώνοντας την παράμετρο ip με μια συγκεκριμένη διαδρομή
        // (/carsDBServices/populateDropDown.php). Αυτό υποδηλώνει ότι η διεύθυνση URL οδηγεί σε ένα
        // τελικό σημείο υπηρεσίας ιστού που είναι υπεύθυνο για τη συμπλήρωση μιας αναπτυσσόμενης λίστας.
        String url= "http://"+ip+"/multimediaDBServices/getMedia.php";

        try {
            // Δημιουργεί αντικείμενο μιας προσαρμοσμένης κλάσης OkHttpHandler,
            // το οποίο φαίνεται να χειρίζεται αιτήματα HTTP χρησιμοποιώντας τη βιβλιοθήκη OkHttp.
            OkHttpHandler okHttpHandler = new OkHttpHandler();

            // Επικαλείται τη μέθοδο populateDropDown του αντικειμένου OkHttpHandler,
            // περνώντας τη συμβολοσειρά URL που δημιουργήθηκε ως παράμετρο.
            // Αυτό υποδηλώνει ότι η μέθοδος populateDropDown είναι υπεύθυνη για την αποστολή ενός αιτήματος
            // HTTP στην καθορισμένη διεύθυνση URL για την ανάκτηση δεδομένων για τη συμπλήρωση της αναπτυσσόμενης λίστας.
            cbList = okHttpHandler.populateDropDown(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // η μέθοδος getAllBrands εξάγει τα ονόματα όλων των επωνυμιών αυτοκινήτων
    // από τη λίστα cbList και τα επιστρέφει ως ξεχωριστή λίστα συμβολοσειρών.
    public List<String> getAllBrands() {
        List<String> temp = new ArrayList<String>();
        for (int i=0; i<cbList.size(); i++) {
            // ανακτά το όνομα του τρέχοντος αντικειμένου CarBrand (cbList.get(i))
            // καλώντας τη μέθοδο getName της κλάσης CarBrand και την προσθέτει στην temp.
            temp.add(cbList.get(i).getName());
        }
        return temp;
    }

    // η μέθοδος getAllModels αναζητά μια συγκεκριμένη μάρκα αυτοκινήτου στη λίστα cbList
    // και ανακτά τα μοντέλα που σχετίζονται με αυτήν τη μάρκα ως λίστα συμβολοσειρών
    public List<String> getAllModels(String b) {
        List<String> temp = new ArrayList<String>();
        for (int i=0; i<cbList.size(); i++) {
            // Ελέγχει εάν το τρέχον αντικείμενο CarBrand (cbList.get(i)) έχει το ίδιο όνομα
            // με την παράμετρο εισόδου b καλώντας τη μέθοδο hasName της κλάσης CarBrand.
            // Εάν το τρέχον αντικείμενο CarBrand έχει το καθορισμένο όνομα,
            // ενημερώνει τη μεταβλητή temp καλώντας τη μέθοδο getAllModels της κλάσης CarBrand
            // για να ανακτήσει τα μοντέλα που σχετίζονται με αυτήν την επωνυμία ως λίστα συμβολοσειρών.
            if (cbList.get(i).hasName(b)) {
                temp = cbList.get(i).getAllModels();
            }
        }
        return temp;
    }

    /**
     * Method added to return CarBrand.Media object when model is provided
     * η μέθοδος lookup αναζητά ένα συγκεκριμένο αντικείμενο CarBrand στη cbList με βάση την παράμετρο
     * επωνυμίας και στη συνέχεια ανακτά το συσχετισμένο αντικείμενο Media για το συγκεκριμένο μοντέλο.
     * Επιστρέφει το αντικείμενο Media εάν βρεθεί ή null εάν δεν βρεθεί.
     * */
    public Media lookup(String brand, String model) {

        for (int i = 0; i < cbList.size(); i++) {
            // Εάν βρεθεί ένα αντικείμενο CarBrand με αντίστοιχο όνομα, καλεί τη μέθοδο getMedia
            // σε αυτό το αντικείμενο CarBrand, μεταβιβάζοντας την παράμετρο μοντέλου.
            // Επιστρέφει το αντικείμενο Media που σχετίζεται με το καθορισμένο μοντέλο στο CarBrand.
            if (cbList.get(i).hasName(brand)) {
                return cbList.get(i).getMedia(model);
            }

        }
        return null;
    }

}
