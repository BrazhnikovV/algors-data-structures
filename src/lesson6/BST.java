package lesson6;

/**
 * MyArrayList -
 *
 * @version 1.0.1
 * @package lesson5
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class BST<Key extends Comparable<Key>, Value> {
    private class Node {

        /**
         * @access private
         * Key key -
         */
        private Key key;

        /**
         * @access private
         * Value value -
         */
        private Value value;

        /**
         * @access private
         * Node left -
         */
        private Node left;

        /**
         * @access private
         * Node right -
         */
        private Node right;

        /**
         * @access private
         * int size -
         */
        private int size;

        /**
         * Node - конструктор
         * @param key   - ключ
         * @param value - значение
         * @param size  - размер
         */
        public Node ( Key key, Value value, int size ) {
            this.key   = key;
            this.value = value;
            this.size  = size;
        }
    }

    /**
     * @access private
     * Node root -
     */
    private Node root = null;

    /**
     * isEmpty - проверить пустое ли дерево
     * @return boolean
     */
    public boolean isEmpty () {
        return this.root == null;
    }

    /**
     * size - получить размер дерева
     * @return int
     */
    public int size () {
        return this.size( this.root );
    }

    /**
     * size - получить размер дерева
     * @param node - узел дерева
     * @return int
     */
    public int size ( Node node ) {
        if ( node == null ) {
            return 0;
        }
        else {
            return node.size;
        }
    }

    /**
     * get - получить значение по ключу
     * @param key
     * @return Value
     */
    public Value get ( Key key ) {
        return this.get( this.root, key );
    }

    /**
     * get - получить значение по ключу
     * @param key
     * @return Value
     */
    private Value get ( Node node, Key key ) {
        if ( key == null ) {
            throw new IllegalArgumentException( "Not null" );
        }

        if ( node == null ) {
            return null;
        }

        int cmp = key.compareTo( node.key );

        if ( cmp == 0 ) {
            return node.value;
        }
        else if ( cmp < 0 ) {
            return this.get( node.left, key );
        }
        else {
            return this.get( node.right, key );
        }
    }

    /**
     * contains - проверить содержится ли ключ
     * @param key - проверяемый ключ
     * @return boolean
     */
    public boolean contains ( Key key ) {
        return this.get( this.root, key ) != null;
    }

    /**
     * put - вставить значение
     * @param node  - узел
     * @param key   - ключ вставляемого значения
     * @param value - вставляемое значение
     * @return Node
     */
    private Node put ( Node node, Key key, Value value ) {
        if ( node == null ) {
            return new Node( key, value, 1 );
        }

        int cmp = key.compareTo( node.key );

        if ( cmp == 0 ) {
            node.value = value;
        }
        else if ( cmp < 0 ) {
            node.left = put( node.left, key, value );
        }
        else {
            node.right = put( node.right, key, value );
        }

        node.size = this.size( node.left ) + this.size( node.right ) + 1;

        return node;
    }

    /**
     * put - вставить значение
     * @param key   - ключ вставляемого значения
     * @param value - вставляемое значение
     */
    public void put ( Key key, Value value ) {
        if ( key == null ) {
            throw new IllegalArgumentException( "Not null" );
        }

        this.root = this.put( this.root, key, value );
    }
}
