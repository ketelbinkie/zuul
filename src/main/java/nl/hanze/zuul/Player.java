package nl.hanze.zuul;

public class Player {
    private String name;
    private BackPack backpack;

    public Player(String name){
        this.name = name;

        grapBackpack();
    }

    private void grapBackpack() {
        backpack = new BackPack("eastpak", 1500);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public BackPack getBackpack() {
        return backpack;
    }

    private void setEastpak(BackPack backpack) {
        this.backpack = backpack;
    }
}
