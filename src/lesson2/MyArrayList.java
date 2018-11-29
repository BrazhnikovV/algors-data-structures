package lesson2;

public class MyArrayList<Item extends Comparable<Item>> {

    private int size = 0;

    private Object[] list = new Object[1];

    private void resize() {

    }

    public void insert( Item item ) {

    }

    public int size() {
        return this.size;
    }

    public void set ( int index, Item item ) {

    }

    public Item get ( int index ) {
        return (Item) list[index];
    }

    public boolean delete () {
        return true;
    }
}
