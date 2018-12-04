package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item> {

    private class MyLinkedListIterator implements Iterator<Item> {

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

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkedListIterator();
    }

    private class Node {
        Item item;

        Node next;

        Node previous;

        public Node( Item item, Node next, Node previous ) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size = 0;

    private Node first = null;
    private Node last  = null;

    public int siize() {
        return this.size;
    }

    public boolean isEmpty () {
        return this.size == 0;
    }

    public void insertFirst( Item item ) {
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

    public Item deleteFirst () {
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


    public Item getFirst () {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        return this.first.item;
    }

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

    public Item getLast() {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        return this.last.item;
    }

    public Item deleteLast() {
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

    public void set ( int index, Item item) {

        if ( index < 0 || index > this.size - 1 ) {
            throw new NoSuchElementException();
        }

        int currentIndex = 0;

        Node current = this.first;

        while ( currentIndex    < index ) {
            current = current.next;
            currentIndex++;
        }

        current.item = item;
    }

    public boolean find ( Item item ) {
        Node current = this.first;

        while ( current != null && !current.item.equals(item)) {
            current = current.next;
        }

        return current == null;
    }

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

    public void insert( int index, Item item ) {
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
}
