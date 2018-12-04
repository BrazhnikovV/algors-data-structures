package lesson4;

class MyLinkedStack<Item> {

    private MyLinkedList<Item> stack = new MyLinkedList<>();

    public void push ( Item item ) {
        this.stack.insertFirst( item );
    }

    public Item pop () {
        return this.stack.deleteFirst();
    }

    public Item peek () {
        return this.stack.getFirst();
    }

    public int size () {
        return this.stack.siize();
    }

    public boolean isEmpty () {
        return this.stack.isEmpty();
    }
}
