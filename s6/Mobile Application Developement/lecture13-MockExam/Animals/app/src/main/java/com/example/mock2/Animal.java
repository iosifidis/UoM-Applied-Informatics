package com.example.mock2;

import java.util.HashMap;

public class Animal {
    private String type;
    private String voice;
    private String name;
    private String image;

    public Animal(String name, String type, String voice, String image){
        this.name = name;
        this.type = type;
        this.voice = voice;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public boolean hasName(String name){return this.name.equals(name); }
    public String getType(){
        return type;
    }

    public String getVoice(){
        return voice;
    }

    public String getImage(){
        return image;
    }
}
