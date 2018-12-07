package lesson4;

/**
 * MyLinkedStack -
 *
 * @version 1.0.1
 * @package lesson4
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
class MyLinkedStack<Item> {

    /**
     * @access private
     * MyLinkedList<Item> stack - стек
     */
    private MyLinkedList<Item> stack = new MyLinkedList<>();

    /**
     * push -
     * @param item - вставляемый элемент
     */
    public void push ( Item item ) {
        this.stack.insertFirst( item );
    }

    /**
     * pop -
     * @return Item
     */
    public Item pop () {
        return this.stack.deleteFirst();
    }

    /**
     * peek -
     * @return Item
     */
    public Item peek () {
        return this.stack.getFirst();
    }

    /**
     * size -
     * @return
     */
    public int size () {
        return this.stack.size();
    }

    /**
     * isEmpty -
     * @return boolean
     */
    public boolean isEmpty () {
        return this.stack.isEmpty();
    }
}
