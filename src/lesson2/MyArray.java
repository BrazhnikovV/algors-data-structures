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
    private int[] arr = new int[100000];

    /**
     * @access private
     * int size - размер массива
     */
    private int size = 100000;

    /**
     * size -
     */
    public int size() {
        return this.size;
    }

    /**
     * fillArray - заполнить массив
     */
    public void fillArray() {
        for ( int i = 0; i < this.arr.length; i++ ) {
            this.arr[i] = Rnd.nextInt( 99 );
        }
    }

    /**
     * get - получить массив
     */
    public int[] get() {
        return this.arr;
    }

    /**
     * insert - вставить значение в массив
     * @param item - значение которое необходимо вставить
     */
    public void insert( int item ) {

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
    public boolean delete( int item ) {

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
    public boolean find( int item ) {

        for ( int i = 0; i < this.size; i++ ) {

            if ( this.arr[i] == item ) {
                return true;
            }
        }
        return false;
    }

    /**
     * sortBubble - сортировка массива методом пузырька
     */
    public void sortBubble() {

        int out, in;
        for ( out = this.size - 1; out >= 1; out-- ) {

            for( in=0; in < out; in++ ) {

                if ( this.arr[in] > this.arr[in+1] ) {
                    change( in, in + 1 );
                }
            }
        }
    }

    /**
     * sortBubble - сортировка массива методом выбора
     */
    public void sortSelect() {

        int out, in, mark;
        for( out=0; out < this.size; out++ ) {

            mark = out;
            for( in = out + 1; in < this.size; in++ ) {

                if ( this.arr[in] < this.arr[mark] ) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }

    /**
     * sortInsert - сортировка массива методом вставки
     */
    public void sortInsert () {

        int in, out;
        for( out = 1; out < this.size; out++ ) {

            int temp = this.arr[out];
            in = out;
            while( in > 0 && this.arr[in-1] >= temp ){
                this.arr[in] = this.arr[in-1];
                --in;
            }

            this.arr[in] = temp;
        }
    }

    /**
     * change - поменять значения местами в массиве
     * @param a - первое значение
     * @param b - второе значение
     */
    private void change( int a, int b ) {

        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
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

