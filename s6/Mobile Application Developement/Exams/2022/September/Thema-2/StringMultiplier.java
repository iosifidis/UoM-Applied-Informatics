package gr.uom.thema_2;

public class StringMultiplier {

    // Φτιάχνουμε 2 αντικείμενα (αυτά που θα κάνουμε τις πράξεις)
    private String num1;
    private String num2;

    // Κατασκευαστής
    public StringMultiplier(String inputString) {
        // Φτιάχνουμε έναν πίνακα με τα δυο αντικείμενα που χωρίζεται με \\*
        String[] parts = inputString.split("\\*");
        // Περιττό. Αν δεν έχει η λίστα 2 αντικείμενα τότε εμφανίζει ένα μήνυμα λάθους
        if (parts.length != 2) {
            throw new IllegalArgumentException("Input string must contain exactly two parts separated by '*'.");
        }

        // Θέτει τον πρώτο αριθμό στο αντικείμενο 1 και τον δεύτερο στο αντικείμενο 2
        this.num1 = parts[0];
        this.num2 = parts[1];
    }

    // Η μέθοδος multi που πολλαπλασιάζει τους δυο αριθμούς
    public double multi() {
        try {
            // Αφού τους μετατρέχει σε double τους πολλαπλασιάζει και επιστρέφει το αποτέλεσμα.
            double result = Double.parseDouble(num1) * Double.parseDouble(num2);
            return result;
        } catch (NumberFormatException e) {
            return -1; // Or any other error indicator you prefer
        }
    }
}
