package lesson5;

/**
 * MySortedArrayList -
 *
 * @version 1.0.1
 * @package lesson5
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MySortedArrayList<Item extends Comparable<Item>> extends MyArrayList<Item> {

    /**
     * insert -
     * @param item - значение которое необходимо вставить
     */
    public void insert ( Item item ) {
        super.insert(item);
        int i = this.size() - 1;
        while (i > 0 && this.get(i).compareTo(this.get(i - 1)) < 0) {
            Item temp = this.get(i);
            this.set(i, this.get(i - 1));
            this.set(i - 1, temp);
            i--;
        }
    }

    /**
     * find -
     * @param item - значения по которому производится посик
     * @return
     */
    public boolean find ( Item item ) {
        /*int low = 0;
        int hi = this.size() - 1;
        while (low <= hi) {
            int mid = low + (hi - low) / 2; //mid = (low + hi) / 2;
            if (item.compareTo(this.get(mid)) < 0) {
                hi = mid - 1;
            }
            else if (item.compareTo(this.get(mid)) > 0) {
                low = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;*/
        return recBinaryFind(item, 0, this.size() - 1);
    }

    /**
     * recBinaryFind -
     * @param item - значения по которому производится поиск
     * @param low  - нижнее
     * @param hi   - верхнее
     * @return boolean
     */
    private boolean recBinaryFind ( Item item, int low, int hi ) {
        if ( low > hi ) {
            return false;
        }

        // вычисляем серединный элемент
        int mid = mid = low + (hi - low) / 2;

        // тривиальный случай
        if ( item.compareTo( this.get( mid ) )  == 0 ) {
            return true;
        }
        // определяем направление перемещения по дереву
        else if ( item.compareTo( this.get( mid ) ) < 0 ) {
            return recBinaryFind( item, low, mid - 1 );
        }
        else {
            return recBinaryFind( item, mid + 1, hi );
        }
    }
}
