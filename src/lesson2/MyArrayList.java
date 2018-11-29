package lesson2;

/**
 * MyArrayList -
 *
 * @version 1.0.1
 * @package lesson1
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MyArrayList<Item extends Comparable<Item>> {

    /**
     * @access private
     * int size - размер массива
     */
    private int size = 0;

    /**
     * @access private
     * Object[] list - исходный массив
     */
    private Object[] list = new Object[1];

    /**
     * size - узнать размер массива (количество элементов)
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * insert - вставить значение в массив
     * @param item - значение которое необходимо добавить
     */
    public void insert( Item item ) {

        if ( this.size == this.list.length ) {
            resize(2 * this.list.length );
        }

        this.list[this.size++] = item;
    }

    /**
     * delete - удалить значение из массива
     * @param item - удаляемое значение
     * @return boolean
     */
    public boolean delete( Item item ) {

        int i = 0;
        while ( i < this.size && !this.list[i].equals( item ) ) {
            i++;
        }

        if ( i == this.size ) {
            return false;
        }

        for ( int j = i; j < this.size - 1; j++ ) {
            this.list[j] = this.list[j + 1];
        }

        this.list[this.size - 1] = null;
        this.size--;

        if ( this.size == this.list.length / 4 && this.size > 0 ) {
            resize(this.list.length / 2 );
        }

        return true;
    }

    /**
     * get - получить элемент массива по индексу
     * @param index - номер элемента массива
     * @return Item
     */
    public Item get( int index ) {

        if ( index < 0 || index > this.size - 1 ) {
            throw new IndexOutOfBoundsException();
        }

        return (Item) this.list[index];
    }

    /**
     * set - установить значения для элемента
     *       массива по индексу
     * @param index
     * @param item
     */
    public void set( int index, Item item ) {

        if ( index < 0 || index > this.size - 1 ) {
            throw new IndexOutOfBoundsException();
        }

        this.list[index] = item;
    }

    /**
     * find - найти элемент массива по значению
     * @param item - значения по которому производится посик
     * @return boolean
     */
    public boolean find( Item item ) {

        for ( int i = 0; i < this.size; i++ ) {

            if ( this.list[i].equals( item ) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for ( int i = 0; i < this.size; i++ ) {
            s = s + this.list[i] + ", ";
        }
        return s;
    }

    /**
     * selectionSort - сортировка массива методом выбора
     */
    public void selectionSort() {

        for ( int i = 0; i < this.size - 1; i++ ) {

            int min = i;
            for ( int j = i + 1; j < this.size; j++ ) {

                if ( less( (Item) this.list[j], (Item) this.list[min])) {
                    min = j;
                }
            }
            exch(i, min);
        }
    }

    /**
     * insertionSort -сортировка методом втавки
     */
    public void insertionSort() {

        for ( int i = 0; i < this.size; i++ ) {

            for ( int j = i; j > 0; j-- ) {

                if ( less( (Item) this.list[j], (Item) this.list[j - 1] ) ) {
                    exch(j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }

    /**
     * resize - изменить размер массива
     * @access private
     * @param capacity - величина для определения глубины изменения
     */
    private void resize( int capacity ) {

        Object[] temp = new Object[capacity];

        for ( int i = 0; i < this.size; i++ ) {
            temp[i] = this.list[i];
        }

        this.list = temp;
    }

    /**
     * less - сравнить кто меньше
     * @param item1 - первое сравниваемое значение
     * @param item2 - второе сравниваемое значение
     * @return boolean
     */
    private boolean less( Item item1, Item item2 ) {
        return item1.compareTo( item2 ) < 0;
    }

    /**
     * exch - обменять ...
     * @param i - первое обмениваемое значение
     * @param j - второе обмениваемое значение
     */
    private void exch( int i, int j ) {
        Item temp = (Item) this.list[i];
        this.list[i] = this.list[j];
        this.list[j] = temp;
    }
}