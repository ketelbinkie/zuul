package nl.hanze.zuul;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BackPack extends Item {
    private int maxWeight;
    private List<Item> itemsInBackPack;

    {
        itemsInBackPack = new List<Item>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Item> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Item item) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Item> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Item> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Item get(int index) {
                return null;
            }

            @Override
            public Item set(int index, Item element) {
                return null;
            }

            @Override
            public void add(int index, Item element) {

            }

            @Override
            public Item remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Item> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Item> listIterator(int index) {
                return null;
            }

            @Override
            public List<Item> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }

    public BackPack(){
        super();
    }

    public BackPack(String name, String description, int weight, int maxWeight){
        super(name, description, weight);
        this.maxWeight = maxWeight;

    }

    public int getMaxWeight() {
        return maxWeight;
    }

    private void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addItemToBackPack(Item item){
        itemsInBackPack.add(item);
    }

    public Item getItemOfBackPack(String name){
        int index = itemsInBackPack.indexOf(name);
        return itemsInBackPack.get(index);
    }

    public void removeItemOutBackPack(Item item){
        itemsInBackPack.remove(item);
    }


    private String getItemsInBackPackString()
    {
        String returnString = "Items:";
        Iterator<Item> it = itemsInBackPack.iterator();
        while(it.hasNext()){
            returnString += " "+ it.next().toString();
        }
        return returnString;
    }

    public String toString(){
        String text;
        text = super.getAllInfo();
        text += "Maximum Weight: "+ getMaxWeight();
        return text;
    }

}