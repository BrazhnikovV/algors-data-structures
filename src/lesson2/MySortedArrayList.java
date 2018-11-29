package lesson2;

public class MySortedArrayList<Item extends Comparable<Item>> extends MyArrayList<Item> {
    @Override
    public void insert(Item item) {
        super.insert(item);

        int i = this.size() - 1;

        while ( i > 0 && this.get( i ).compareTo( this.get( i - 1 ) ) < 0 ) {
            Item temp = this.get(i);
            this.set( i, this.get(i - 1));
            this.set(i-1, temp);
        }
    }
}
