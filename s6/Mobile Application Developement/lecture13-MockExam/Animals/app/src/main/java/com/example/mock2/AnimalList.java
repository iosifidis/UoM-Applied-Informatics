package com.example.mock2;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class AnimalList {
    ArrayList<Animal> aList;

    public AnimalList(String ip){
        String url = "http://"+ip+"/animals/getMedia.php";

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            aList = okHttpHandler.populateDropDown(url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<String> getAllNames(){
        List<String> temp = new ArrayList<>();
        for(int i=0;i<aList.size();i++){
            temp.add(aList.get(i).getName());
        }
        return temp;
    }

    public String getAnimalType(String name){
        for(int i=0;i<aList.size();i++){
            if(aList.get(i).hasName(name)){
                return aList.get(i).getType();
            }
        }
        return "nop name";
    }
    public String getAnimalVoice(String name){
        for(int i=0;i<aList.size();i++){
            if(aList.get(i).hasName(name)){
                return aList.get(i).getVoice();
            }
        }
        return "nop voice";
    }
    public String getAnimalImage(String name){
        for(int i=0;i<aList.size();i++){
            if(aList.get(i).hasName(name)){
                return aList.get(i).getImage();
            }
        }
        return "nop Image";
    }
}
