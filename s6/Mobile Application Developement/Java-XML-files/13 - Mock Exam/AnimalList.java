package gr.uom.animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalList {

    private ArrayList<Animal> aList;

    public AnimalList(String ip){
        String url = "http://" + ip + "/animals/getMedia.php";
        try {
            aList = new OkHttpHandler().populateDropDown(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllNames(){
        List<String> names = new ArrayList<>();
        for (Animal a : aList) {
            names.add(a.getName());
        }
        return names;
    }

    public String getAnimalType(String name){
        for (Animal a : aList) {
            if (a.getName().equals(name)) {
                return a.getType();
            }
        }
        return null;
    }

    public String getAnimalVoice(String name){
        for (Animal a : aList) {
            if (a.getName().equals(name)) {
                return a.getVoice();
            }
        }
        return null;
    }

    public String getAnimalImage(String name){
        for (Animal a : aList) {
            if (a.getName().equals(name)) {
                return a.getImage();
            }
        }
        return null;
    }

}
