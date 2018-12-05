package lesson3;

/**
 * MyArrayDeque - класс двусторонняя очередь
 *
 * @version 1.0.1
 * @package lesson3
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MyArrayDeque {

    /**
     * @access private
     * int size
     */
    private int size;

    /**
     * @access private
     * int head
     */
    private int head;

    /**
     * @access private
     * int tail
     */
    private int tail;

    /**
     * @access private
     * int[] data
     */
    private int[] data;

    /**
     * Deque - конструктор
     * @param size - размер очереди
     */
    public MyArrayDeque ( int size ) {
        this.data = new int[this.size = size];
    }

    /**
     * pushBack - вставить в конец очереди
     * @param value - вставляемое значение
     */
    public void pushBack( int value ) {
        if ( ++this.tail == this.size ) {
            this.tail = 0;
        }

        this.data[this.tail] = value;
    }

    /**
     * popBack - последний элемент
     * @return int
     */
    public int popBack() {
        int ret = this.data[this.tail];

        if ( --this.tail < 0 ) {
            this.tail = this.size - 1;
        }

        return ret;
    }

    /**
     * pushFront - вставить значение в начало очереди
     * @param value - вставляемое значение
     */
    public void pushFront( int value ) {

        this.data[this.head] = value;
        if ( --this.head < 0 ) {
            this.head = this.size - 1;
        }
    }

    /**
     * popFront - первый элемент
     * @return int
     */
    public int popFront () {
        if ( ++this.head == this.size ) {
            this.head = 0;
        }

        return this.data[this.head];
    }

    /**
     * isEmpty - проверить пуста ли очередь
     * @return
     */
    public boolean isEmpty () {
        return head == tail;
    }
}
