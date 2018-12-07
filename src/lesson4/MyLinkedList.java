package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MyLinkedList -
 *
 * @version 1.0.1
 * @package lesson4
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MyLinkedList<Item> implements Iterable<Item> {

    /**
     * @access private
     * int size
     */
    private int size = 0;

    /**
     * @access private
     * Node first
     */
    private Node first = null;

    /**
     * @access private
     * Node дфые
     */
    private Node last = null;

    /**
     * size -
     * @return int
     */
    public int size () {
        return this.size;
    }

    /**
     * isEmpty -
     * @return boolean
     */
    public boolean isEmpty () {
        return this.size == 0;
    }

    /**
     * insertFirst - вставить элемент в начало
     * @param item - вставляемый элемент
     */
    public void insertFirst ( Item item ) {
        Node oldFirst = this.first;
        this.first = new Node( item, oldFirst, null );

        if ( this.isEmpty() ) {
            this.last = this.first;
        }
        else {
            oldFirst.previous = this.first;
        }
        this.size++;
    }

    /**
     * deleteFirst - удалить первый элемент
     * @return Item
     */
    public Item deleteFirst () {
        // массив не должен быть пустой
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        Item item = this.first.item;

        this.first = this.first.next;
        this.first.previous = null;
        this.size--;

        if ( this.isEmpty() ) {
            this.last = null;
        }
        return item;
    }

    /**
     * getFirst - получить первый элемент
     * @return Item
     */
    public Item getFirst () {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        return this.first.item;
    }

    /**
     * insertLast - вставить в конец
     * @param item - вставляемый элемент
     */
    public void insertLast ( Item item ) {
        Node oldLast = this.last;

        this.last = new Node( item, null, oldLast );

        if ( this.isEmpty() ) {
            this.first = this.last;
        }
        else {
            oldLast.next = this.last;
        }

        this.size++;
    }

    /**
     * getLast - получить последний элемент
     * @return Item
     */
    public Item getLast () {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        return this.last.item;
    }

    /**
     * deleteLast - удалить элемент
     * @return Item - удаленный элемент
     */
    public Item deleteLast () {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        Item item = this.last.item;

        Node previous = this.last.previous;

        this.last.previous = null;

        this.last = previous;
        this.size--;

        if ( this.isEmpty() ) {
            this.first = null;
        }
        else {
            this.last.next = null;
        }

        return item;
    }

    /**
     * get - получить элемент по индексу
     * @param index - индекс элемента
     * @return Item
     */
    public Item get ( int index ) {
        if ( index < 0 || index > this.size - 1 ) {
            throw new NoSuchElementException();
        }

        int currentIndex = 0;

        Node current = this.first;

        while ( currentIndex    < index ) {
            current = current.next;
            currentIndex++;
        }

        return current.item;
    }

    /**
     * set - установить элемент по индексу
     * @param index - индекс элемента
     * @param item - вставляемый элемент
     */
    public void set ( int index, Item item) {

        if ( index < 0 || index > this.size - 1 ) {
            throw new NoSuchElementException();
        }

        int currentIndex = 0;

        Node current = this.first;

        while ( currentIndex < index ) {
            current = current.next;
            currentIndex++;
        }

        current.item = item;
    }

    /**
     * find - найти элемент по индексу
     * @param item - добавляемый элемент
     * @return boolean
     */
    public boolean find ( Item item ) {
        Node current = this.first;

        while ( current != null && !current.item.equals(item)) {
            current = current.next;
        }

        return current == null;
    }

    /**
     * delete - удалить элемент по значению
     * @param item - удаляемый элемент
     * @return Item
     */
    public Item delete ( Item item ) {
        Node current = this.first;

        while ( current != null || !current.item.equals(item) ) {
            current= current.next;
        }

        if ( current == null ) {
            return null;
        }

        if ( current == this.first ) {
            return deleteFirst();
        }
        else if ( current == this.last ) {
            return deleteLast();
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
        this.size--;
        current.next = null;
        current.previous = null;

        return current.item;
    }

    /**
     * insert - вставить элемент по индексу
     * @param index - индекс элемента
     * @param item - вставляемый элемент
     */
    public void insert ( int index, Item item ) {
        if ( index < 0 || index > this.size ) {
            throw new NoSuchElementException();
        }

        if ( index == 0 ) {
            this.insertFirst( item );
            return;
        }
        else if ( index == this.size ) {
            this.insertLast( item );
            return;
        }

        int currentIndex = 0;

        Node current = this.first;

        while ( currentIndex < index ) {
            current = current.next;
            currentIndex++;
        }

        Node newNode = new Node( item, current, current.previous);
        current.previous.next = newNode;
        current.previous = newNode;

        this.size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkedListIterator();
    }

    /**
     *  MyLinkedListIterator
     */
    private class MyLinkedListIterator implements Iterator<Item> {

        /**
         * @access private
         * Node current
         */
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {

            if ( !hasNext() ) {
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Node -
     */
    private class Node {

        /**
         * @access public
         * Item item
         */
        public Item item;

        /**
         * @access public
         * Node next
         */
        public Node next;

        /**
         * @access public
         * Node previous
         */
        public Node previous;

        /**
         * Node - конструктор
         * @param item -
         * @param next - следующий узел
         * @param previous - предыдущий узел
         */
        public Node ( Item item, Node next, Node previous ) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }
}
