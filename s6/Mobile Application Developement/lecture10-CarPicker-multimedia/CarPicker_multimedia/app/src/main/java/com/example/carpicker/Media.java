package com.example.carpicker;

class Media{
    // Δηλώνει μια ιδιωτική εικόνα μεταβλητής εμφάνισης τύπου String
    // για να αποθηκεύσει τις πληροφορίες της εικόνας.
    private String image;

    // Κατασκευαστής
    public Media(String image) {
        this.image = image;
    }

    // Λήψη της εικόνας
    public String getImage() {
        return image;
    }

}

