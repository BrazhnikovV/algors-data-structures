package lesson3;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {

    /**
     * @access private
     * int Object[] queue -
     */
    private Object[] queue = new Object[2];

    /**
     * @access private
     * int size -
     */
    private int size = 0;

    /**
     * @access private
     * int start - первый элемент очереди
     */
    private int start = 0;

    /**
     * @access private
     * int end - место для вставки последнего элемента
     */
    private int end = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize( int capacity ) {
        Object[] temp = new Object[capacity];

        for ( int i = 0; i < this.size; i++ ) {
            temp[i] = this.queue[(this.start + i) % this.size];
        }

        this.queue = temp;
        this.start = 0;
        this.end = this.size;

    }

    public void enqueue ( Item item ) {
        if ( this.size == this.queue.length ) {
            resize( 2 * this.queue.length );
        }

        this.queue[this.end++] = item;
        this.end %= this.queue.length;
        this.size++;

        //if ( this.end == this.queue.length ) {
        //    this.end = 0;
        //}
    }

    public Item dequeue () {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        Item item = ( Item ) this.queue[this.start];
        this.queue[this.start] = null;
        this.size--;
        this.start++;
        this.start %= this.queue.length;

        if ( this.size > 0 && this.size == this.queue.length ) {
            this.resize( this.queue.length / 2 );
        }

        return item;
    }

    public Item peekFront () {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        return (Item) this.queue[this.start];
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < this.size; i++) {
            s = s + this.queue[(this.start + i) % this.queue.length] + ", ";
        }

        return s;
    }
}
