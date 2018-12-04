package lesson4;

public class MyLinkedQueue<Item> {

    private MyLinkedList<Item> queue = new MyLinkedList<>();

    public void push ( Item item ) {
        this.queue.insertFirst( item );
    }

    public void enqueue ( Item item ) {
        this.queue.insertLast( item );
    }

    public Item dequeue () {
        return this.queue.deleteFirst();
    }

    public Item peek () {
        //return this.queue.deleteFirst();
        return null;
    }

    public int size () {
        return this.queue.siize();
    }

    public boolean isEmpty () {
        return this.queue.isEmpty();
    }
}
