package gr.uom.animals_xml;

import android.content.res.AssetManager;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;

public class AnimalList {

    ArrayList<Animal> anList = new ArrayList<Animal>();

    public AnimalList(AssetManager assets){
        try {
            InputStream is = assets.open("records.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            NodeList nList = doc.getElementsByTagName("animal");

            for (int i=0 ; i < nList.getLength(); i++){
                Node node = nList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList spicesNode = ((Element) node).getElementsByTagName("species").item(0).getChildNodes();
                    String animal = spicesNode.item(0).getNodeValue();
                    NodeList namesNode = ((Element) node).getElementsByTagName("name").item(0).getChildNodes();
                    String animalName = namesNode.item(0).getNodeValue();
                    anList.add(new Animal(animal, animalName));

                    // Debugging output
                    Log.d("AnimalList", "Parsed animal: " + animal + ", Name: " + animalName);
                }

            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getAllNamesAsString(String n){
        String names = "";
        for (int i=0 ; i<anList.size(); i++){
            if (anList.get(i).hasName(n)){
                names += anList.get(i).getAllNamesAstring();
            }
        }
        return names;
    }

    public List<String> getAllAnimals(){
        List<String> temp = new ArrayList<String>();
        for(int i=0; i<anList.size(); i++){
            temp.add(anList.get(i).getSpecies());
        }
        return temp;
    }

    public List<String> getAllNames(String n){
        List<String> temp = new ArrayList<String>();
        for(int i=0; i<anList.size(); i++){
            if(anList.get(i).hasName(n)){
                temp = anList.get(i).getAllNames();
                //temp.addAll(anList.get(i).getAllNames());
            }
        }
        return temp;
    }

}
