package lesson4;

/**
 * MyLinkedQueue - класс очередь на базе делегата LinkedList
 *
 * @version 1.0.1
 * @package lesson4
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MyLinkedQueue<Item> {

    /**
     * @access private
     * MyLinkedList<Item> queue - очередь
     */
    private MyLinkedList<Item> queue = new MyLinkedList<>();

    /**
     * push - вставить элемент
     * @param item - вставляемый элемент
     */
    public void push ( Item item ) {
        this.queue.insertFirst( item );
    }

    /**
     * enqueue -
     * @param item
     */
    public void enqueue ( Item item ) {
        this.queue.insertLast( item );
    }

    /**
     * dequeue -
     * @return
     */
    public Item dequeue () {
        return this.queue.deleteFirst();
    }

    /**
     * peek -
     * @return Item
     */
    public Item peek () {
        //return this.queue.deleteFirst();
        return null;
    }

    /**
     * size - получить размер очереди
     * @return int
     */
    public int size () {
        return this.queue.size();
    }

    /**
     * isEmpty - узнать пустая ли очередь
     * @return boolean
     */
    public boolean isEmpty () {
        return this.queue.isEmpty();
    }
}
