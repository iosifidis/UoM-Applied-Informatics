package gr.uom.animals;

public class Animal {
    // Ιδιότητες
    private String name;
    private String type;
    private String voice;
    private String image;

    // Κατασκευαστής
    public Animal(String name, String type, String voice, String image) {
        this.name = name;
        this.type = type;
        this.voice = voice;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getVoice() {
        return voice;
    }

    public String getImage() {
        return image;
    }

    public boolean hasName(Animal a) {
        return this.name.equals(a);
    }

}

