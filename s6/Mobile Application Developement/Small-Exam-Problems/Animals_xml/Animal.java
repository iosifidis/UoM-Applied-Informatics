package gr.uom.animals_xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {
    private String species;
    private List<String> names = new ArrayList<String>();

    public Animal(String s, String n) {
        species = s;
        names = Arrays.asList(n.split(","));

    }

    public boolean hasName(String n) {
        return species.equals(n);

    }

    public String getAllNamesAstring() {
        return names.toString();
    }

    public String getSpecies() {
        return species;
    }

    public List<String> getAllNames() {
        return names;
    }
}
