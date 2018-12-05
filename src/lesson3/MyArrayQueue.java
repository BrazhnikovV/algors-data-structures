package lesson3;

import java.util.NoSuchElementException;

/**
 * MyArrayQueue - класс очередь (очередь - абстрактный тип данных)
 *
 * @version 1.0.1
 * @package lesson3
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MyArrayQueue<Item> {

    /**
     * @access private
     * int Object[] queue - исходный массив
     */
    private Object[] queue = new Object[2];

    /**
     * @access private
     * int size - размер очереди
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

    /**
     * size - получить размер очереди
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * isEmpty - проверить пуста ли очередь
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * resize - изменить размер массива
     * @param capacity - глубина изменения
     */
    private void resize( int capacity ) {
        // создаем временный массив для копирования
        Object[] temp = new Object[capacity];

        for ( int i = 0; i < this.size; i++ ) {
            temp[i] = this.queue[(this.start + i) % this.size];
        }

        this.queue = temp;

        // перемещаем указатель на первый элемент очереди
        // и указатель на место для вставки
        this.start = 0;
        this.end   = this.size;

    }

    /**
     * enqueue - добавить элемент к очереди
     * @param item - добавляемый элемент
     */
    public void enqueue ( Item item ) {
        // проверяем не нужно ли изменить размер массива
        if ( this.size == this.queue.length ) {
            resize( 2 * this.queue.length );
        }

        this.queue[this.end++] = item;
        // если остаток от деления ноль, то перемещаем указатель
        // на место для вставки нового элемента в начало
        this.end %= this.queue.length;

        // альтернативный способ => this.end %= this.queue.length;
        // ======================================================
        // if ( this.end == this.queue.length ) {
        //    this.end = 0;
        // }

        this.size++;
    }

    /**
     * dequeue - удалить элемент из очереди
     * @return Item
     */
    public Item dequeue () {
        // очередь не должен быть пустой
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

    /**
     * peekFront - получить элемент первый в очереди
     * @return Item
     */
    public Item peekFront () {
        // очередь не должен быть пустой
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
