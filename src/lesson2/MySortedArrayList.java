package lesson2;

/**
 * MySortedArrayList -
 *
 * @version 1.0.1
 * @package lesson2
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MySortedArrayList<Item extends Comparable<Item>> extends MyArrayList<Item> {

    /**
     * insert - вставить значение в массив
     * @param item - значение которое необходимо вставить
     */
    public void insert( Item item ) {
        super.insert( item );

        int i = this.size() - 1;
        while ( i > 0 && this.get(i).compareTo( this.get( i - 1 ) ) < 0 ) {

            Item temp = this.get( i );
            this.set( i, this.get( i - 1 ) );
            this.set( i - 1, temp );
            i--;
        }
    }

    /**
     * find - найти элемент в массиве по значению
     * @param item - значения по которому производится посик
     * @return boolean
     */
    public boolean find( Item item ) {

        int low = 0;
        int hi = this.size() - 1;
        while ( low <= hi ) {

            int mid = low + ( hi - low ) / 2; //mid = (low + hi) / 2;
            if ( item.compareTo( this.get( mid ) ) < 0) {
                hi = mid - 1;
            }
            else if ( item.compareTo( this.get( mid ) ) > 0 ) {
                low = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
