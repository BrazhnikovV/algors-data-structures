package lesson2;


/**
 * MyArray -
 *
 * @version 1.0.1
 * @package lesson2
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MyArray {

    /**
     * @access private
     * int[] arr - исходный массив
     */
    private int[] arr = new int[1000000];

    /**
     * @access private
     * int size - размер массива
     */
    private int size = 999999;

    /**
     * run - здесь выполняются основные операции
     */
    public void run() {
        // заполняем массив случайными числами
        for ( int i = 0; i < this.arr.length; i++ ) {
            this.arr[i] = Rnd.nextInt( 99999 );
        }
    }

    /**
     * get -
     */
    public int[] get() {
        return this.arr;
    }

    /**
     * insert - вставить значение в массив
     * @param item - значение которое необходимо вставить
     */
    private void insert( int item ) {

        if ( this.size == this.arr.length ) {
            resize(2 * this.arr.length );
        }

        this.arr[this.size++] = item;
    }

    /**
     * delete - удалить значение из массива
     * @param item - удаляемое значение
     * @return boolean
     */
    private boolean delete( int item ) {

        int i = 0;
        while ( i < this.size && this.arr[i] != item ) {
            i++;
        }

        if ( i == this.size ) {
            return false;
        }

        for ( int j = i; j < this.size - 1; j++ ) {
            this.arr[j] = this.arr[j + 1];
        }

        this.arr[this.size - 1] = 0;
        this.size--;

        if ( this.size == this.arr.length / 4 && this.size > 0 ) {
            resize(this.arr.length / 2 );
        }

        return true;
    }

    /**
     * find - найти элемент массива по значению
     * @param item - значения по которому производится посик
     * @return boolean
     */
    private boolean find( int item ) {

        for ( int i = 0; i < this.size; i++ ) {

            if ( this.arr[i] == item ) {
                return true;
            }
        }
        return false;
    }

    /**
     * resize - изменить размер массива
     * @access private
     * @param capacity - величина для определения глубины изменения
     */
    private void resize( int capacity ) {

        int[] temp = new int[capacity];

        for ( int i = 0; i < this.size; i++ ) {
            temp[i] = this.arr[i];
        }

        this.arr = temp;
    }
}

