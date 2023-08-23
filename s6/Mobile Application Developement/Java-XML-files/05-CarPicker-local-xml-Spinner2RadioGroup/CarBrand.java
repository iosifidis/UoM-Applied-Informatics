package gr.uom.carpicker_xml_spiner2radio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarBrand {

    private String name;
    private List<String> models = new ArrayList<String>();

    public CarBrand(String b, String m) {
        name = b;
        models = Arrays.asList(m.split(","));
    }

    public boolean hasName(String b) {
        return name.equals(b);
    }

    public String getAllModelsAsString() {
        return models.toString();
    }


    public String getName() {
        return name;
    }


    public List<String> getAllModels() {
        return models;
    }

}
