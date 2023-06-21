package gr.uom.teammatches;

import java.util.HashMap;

public class Team {
    private String name;
    private String image;
    private HashMap<String, String> members = new HashMap<>();

    public String getImage() {
        return image;
    }

    /*
    αναφέρεται σε έναν κατασκευαστή (constructor) της κλάσης Team.
    Ο κατασκευαστής δέχεται τέσσερα ορίσματα: brand, im, members και images.
    Οι τιμές αυτών των ορισμάτων χρησιμοποιούνται για την αρχικοποίηση των μελών της κλάσης.
     */

    public Team(String brand, String im, String members, String images) {
        image = im;
        name = brand;
        String[] memberArray = members.split(",");
        String[] imageArray = images.split(",");
        for(int i=0; i<memberArray.length;i++){
            this.members.put(memberArray[i], imageArray[i]);
        }
    }
/*
    public String getMedia(String key){
        return this.members.get(key);
    }*/

    // Η μέθοδος hasName δέχεται ένα αλφαριθμητικό b και ελέγχει αν το όνομα της ομάδας (name)
    // είναι ίσο με το αλφαριθμητικό b. Επιστρέφει true αν τα ονόματα ταιριάζουν και false διαφορετικά.
    public boolean hasName(String b) {
        return name.equals(b);
    }

    // Η μέθοδος getName απλά επιστρέφει το όνομα της ομάδας (name).
    public String getName() {return name; }
    //public List<String> getAllMembers() {return new ArrayList<String>(members.keySet());}

    // Η μέθοδος getMembers επιστρέφει το HashMap με όνομα members που περιέχει τα μέλη της ομάδας και τις αντίστοιχες εικόνες τους.
    public HashMap<String, String> getMembers() {
        return members;
    }
}
