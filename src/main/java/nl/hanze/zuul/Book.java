package nl.hanze.zuul;

public class Book extends Item {
    private int amountPages;

    public Book(){
        super();
    }

    public Book(String name, String description, int weight, int amountPages){
        super(name, description, weight);
        this.amountPages = amountPages;

    }

    public int getAmountPages() {
        return amountPages;
    }

    private void setAmountPages(int amountPages) {
        this.amountPages = amountPages;
    }

    public String toString(){
        String text;
        text = super.getAllInfo();
        text += "Pages: "+getAmountPages();
        return text;
    }

}