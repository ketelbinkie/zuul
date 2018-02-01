package nl.hanze.zuul;

public class Flashlight extends Item {
    private int batteryLife;

    public Flashlight(){
        super();
    }

    public Flashlight(String name, String description, int weight, int batteryLife){
        super(name, description, weight);
        this.batteryLife = batteryLife;

    }

    public int getBatteryLife() {
        return batteryLife;
    }

    private void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public String toString(){
        String text;
        text = super.getAllInfo();
        text += "Battery life: "+ getBatteryLife();
        return text;
    }

}