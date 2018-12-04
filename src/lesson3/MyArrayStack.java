package lesson3;

import java.util.NoSuchElementException;

public class MyArrayStack<Item> {

    private Object[] stack = new Object[1];

    public int size = 0;

    public int size() {
        return this.size;
    }

    public void push ( Item item ) {
        if ( this.size == this.stack.length ) {
            this.resize( 2 * this.stack.length );
        }

        this.stack[this.size++] = item;
    }

    public Item pop () {
        if ( isEmpty() ) {
            throw new NoSuchElementException();
        }

        Item item = (Item) this.stack[this.size - 1];

        this.stack[this.size - 1] = null;
        this.size--;

        if ( this.size > 0 && this.size == this.stack.length ) {
            this.resize( this.stack.length );
        }

        return item;
    }

    public Item peek () {
        if ( isEmpty() ) {
            throw new NoSuchElementException();
        }

        return (Item) this.stack[this.size - 1];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize( int capacity ) {
        Object[] temp = new Object[capacity];

        for (int i = 0; i < this.size; i++) {
            temp[i] = this.stack[i];
        }

        this.stack = temp;
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < this.size; i++) {
            s = s + this.stack[i] + ", ";
        }

        return s;
    }
}
