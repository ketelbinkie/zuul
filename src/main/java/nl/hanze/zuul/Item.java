package nl.hanze.zuul;

import java.util.HashMap;

public class Item {
    private String name;
    private String description;
    private int weight;

    public Item(String name, String description, int weight){
        this.name = name;
        this.description=description;
        this.weight=weight;

    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeigth(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

}
