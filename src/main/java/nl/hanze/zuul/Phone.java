package nl.hanze.zuul;

public class Phone extends Item {
    private String color;
    private int gbAmount;

    public Phone(){
        super();
    }

    public Phone(String name, String description, int weight, String color, int gbAmount){
        super(name, description, weight);
        this.color = color;
        this.gbAmount = gbAmount;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public int getGbAmount() { return gbAmount; }

    public void setGbAmount(int gbAmount) { this.gbAmount = gbAmount; }

    public String toString(){
        String text;
        text = super.getAllInfo();
        text += "Color: "+ getColor()+", Amount of GB's: "+getGbAmount();
        return text;
    }

}