package nl.hanze.zuul;

public class Item {
    private String name;
    private String description;
    private int weight;
    private boolean canBePickedUp;

    public Item(){
        name = "Item";
        description = "Een item is het hoogste nivo";
        weight = 1000;
    }

    public Item(String name, String description, int weight){
        this.name = name;
        this.description=description;
        this.weight=weight;
        setCanBePickedUp(true);
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

    public boolean getCanBePickedUp() {
        return canBePickedUp;
    }

    public void setCanBePickedUp(Boolean canBePickedUp) {
        this.canBePickedUp = canBePickedUp;
    }

    public String getAllInfo(){
        String text;
        text = "Name: "+getName()+", Description: "+getDescription()+", Weight: "+getWeight();

        return text;
    }
}
