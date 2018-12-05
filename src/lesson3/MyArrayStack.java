package lesson3;

import java.util.NoSuchElementException;

/**
 * MyArrayStack - класс стэк (стэк - абстрактный тип данных)
 *
 * @version 1.0.1
 * @package lesson3
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MyArrayStack<Item> {

    /**
     * @access private
     * Object[] stack - исходный массив
     */
    private Object[] stack = new Object[1];

    /**
     * @access private
     * int size - размер массива
     */
    private int size = 0;

    /**
     * size - получить размер массива
     * @return int
     */
    public int size () {
        return this.size;
    }

    /**
     * push - вставить элемент в стэк
     * @param item - добавляемый элемент
     */
    public void push ( Item item ) {
        // проверяем не нужно ли увеличить массив
        if ( this.size == this.stack.length ) {
            this.resize( 2 * this.stack.length );
        }

        // вставляем эелент в конец массива и
        // увеличиывем размер массива
        this.stack[this.size++] = item;
    }

    /**
     * pop - выкинуть элемент из стэка
     * @return Item
     */
    public Item pop () {
        // стэк не должен быть пустым
        if ( this.isEmpty() ) {
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

    /**
     * peek - получить последний элемент массива
     * @return Item
     */
    public Item peek () {
        // стэк не должен быть пустым
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        // возвращаем последний элемент массива и
        // выполняем приведение типа
        return (Item) this.stack[this.size - 1];
    }

    /**
     * isEmpty - проверить пуст ли массив
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for ( int i = 0; i < this.size; i++ ) {
            s.append(this.stack[i]).append(", ");
        }

        return s.toString();
    }

    /**
     * resize - изменить размер массива
     * @param capacity - глубина изменения
     */
    private void resize ( int capacity ) {
        // создаем временный массив для копирования
        Object[] temp = new Object[capacity];

        for ( int i = 0; i < this.size; i++ ) {
            temp[i] = this.stack[i];
        }

        this.stack = temp;
    }
}
