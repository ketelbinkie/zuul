package nl.hanze.zuul;

import java.util.*;

public class BackPack {
    private String brand;
    private int maxWeight;
    private HashMap<String, Item> itemsInBackPack;

    public BackPack(String brand, int maxWeight){
        this.brand = brand;
        this.maxWeight = maxWeight;
        itemsInBackPack = new HashMap<>();
    }


    private String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    private int getMaxWeight() {
        return maxWeight;
    }

    private void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Define an item from this backpack.
     * @param itemName The name of the item.
     * @param item The item added to the backpack.
     */
    public void addItemToBackPack(String itemName, Item item)
    {
        itemsInBackPack.put(itemName, item);
    }

    public Item getItemOfBackPack(String itemName)
    {
        return itemsInBackPack.get(itemName);
    }

    /**
     * Removes the item with the given item name of the backpack's
     * @param itemName of the backpack's items.
     */

    public void removeItemOutBackPack(String itemName){
        itemsInBackPack.remove(itemName);
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *     Items: book phone
     * @return A long description of this room
     */
    public String getDescriptionOfItemInTheBackpack() {
        if (itemsInBackPack.size() != 0) {
            //return "In your backpack '"+toString()+"':\n"+ getAllItemsInBackPackString();
            return "In your backpack '" + getBrand() + "':\n" + getAllItemsInBackPackString();
        }
        else{
            return "Your backpack is empty!";
        }
    }

    /**
     * Return a string describing the backpack's items, for example
     * "Items: book, phone".
     * @return Details of the backpack's items.
     */
    private StringBuilder getAllItemsInBackPackString(){
        StringBuilder returnString = new StringBuilder("Items:");
        Set<String> keys = itemsInBackPack.keySet();
        for(String item : keys) {
            returnString.append(" ").append(item);
        }
        return returnString;
    }

    public String toString(){
        String text;
        text = "Brand: "+ getBrand()+", Maximum Weight: "+ getMaxWeight();
        return text;
    }

}