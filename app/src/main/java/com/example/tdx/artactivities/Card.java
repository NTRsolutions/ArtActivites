package com.example.tdx.artactivities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tdx on 9/17/15.
 */
public class Card implements Serializable {

    private int id;
    private String name;
    private String month;
    private String description;
    private List<String> materials;
    private List<String> directions;

    public Card() {
        materials = new ArrayList<String>();
        directions = new ArrayList<String>();
    }

    public int getId() { return id;}

    public String getCardImageName() {
        String rtnString = String.format("%03d", id);
        return "card_" + rtnString;

    }

    public void setMonth(String month) { this.month = month; }

    public String getMonth() { return month; }


    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMaterials_List() {
        return materials;
    }

    public String getMaterials() {
        String rtnString = "";
        for (String element : materials ) {
            rtnString = rtnString + "\n * "  + element;
        }
        return rtnString;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public List<String> getDirections_List() {
        return directions;
    }

    public String getDirections() {

        String rtnString = "";
        int count = 1;
        for (String element : directions ) {
            rtnString = rtnString + "\n" + count + ".  " + element + "\n";
            ++count;
        }
        return rtnString;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public void addDirection(String step) {
        directions.add(step);

    }

    public void addMaterial(String item) {
        materials.add(item);
    }

    @Override
    public String toString() {
        return "-- " + name + " --\n" + description;
    }
}
