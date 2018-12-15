package lesson6;

import java.util.NoSuchElementException;

/**
 * BST - абстрактный тип данных бинартное дерево поиска
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
         * @access private
         * int height -
         */
        private int height;

        /**
         * Node - конструктор
         * @param key   - ключ
         * @param value - значение
         * @param size  - размер
         */
        public Node ( Key key, Value value, int size, int height ) {
            this.key    = key;
            this.value  = value;
            this.size   = size;
            this.height = height;
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
     * isBalanced - проверить сбалансированность дерева
     * @return boolean
     */
    public boolean isBalanced () {
        return this.isBalanced( this.root );
    }

    /**
     * size - получить размер дерева
     * @return int
     */
    public int size () {
        return this.size( this.root );
    }

    /**
     * height - получить высоту дерева
     * @return int
     */
    public int height () {
        return this.height( this.root );
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
     * deleteMax - удалить максимальный узел
     * @return Node
     */
    public void deleteMax () {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        this.root = this.deleteMax( this.root );
    }

    /**
     * deleteMin - удалить минимальный узел
     * @return Node
     */
    public void deleteMin () {
        if ( this.isEmpty() ) {
            throw new NoSuchElementException();
        }

        this.root = this.deleteMin( this.root );
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

    /**
     * isBalanced - проверить сбалансированность дерева
     * @return boolean
     */
    private boolean isBalanced ( Node node ) {
        if ( node == null ) {
            return true;
        }
        else {
            int raznica = node.right.height - node.left.height;
            if ( raznica > 1 ) {
                return false;
            }
            else {
                return true;
            }
        }
    }

    /**
     * size - получить размер дерева
     * @param node - узел дерева
     * @return int
     */
    private int size ( Node node ) {
        if ( node == null ) {
            return 0;
        }
        else {
            return node.size;
        }
    }

    /**
     * height - получить высоту дерева
     * @param node - узел дерева
     * @return int
     */
    private int height ( Node node ) {
        if ( node == null ) {
            return 0;
        }
        else {
            return node.height;
        }
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
     * delete - удалить элемент
     * @param key - ключ
     */
    public void delete ( Key key ) {
        this.root = this.delete( this.root, key );
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
            return new Node( key, value, 1, 0 );
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
        node.height = this.height( node.left ) + this.height( node.right ) + 1;

        return node;
    }

    /**
     * min - найти минимальный узел
     * @param node - узел
     * @return Node
     */
    private Node min ( Node node ) {
        if ( node.left == null ) {
            return node;
        }
        else {
            return min( node.left );
        }
    }

    /**
     * max - найти максимальный узел
     * @param node - узел
     * @return Node
     */
    private Node max ( Node node ) {
        if ( node.right == null ) {
            return node;
        }
        else {
            return max( node.right );
        }
    }

    /**
     * deleteMin - удалить минимальный узел
     * @param node - узел
     * @return Node
     */
    private Node deleteMin ( Node node ) {
        if ( node.left == null ) {
            return node.right;
        }

        node.left = this.deleteMin( node.left );
        return node;
    }

    /**
     * deleteMax - удалить максимальный узел
     * @param node - узел
     * @return Node
     */
    private Node deleteMax ( Node node ) {
        if ( node.right == null ) {
            return node.right;
        }

        node.left = this.deleteMin( node.left );
        return node;
    }

    /**
     * delete - удалить элемент
     * @param node - узел
     * @param key  - ключ
     * @return
     */
    private Node delete ( Node node, Key key ) {
        if ( node == null ) {
            return null;
        }

        int cmp = key.compareTo( node.key );

        if ( cmp < 0 ) {
            node.left = delete( node.left, key );
        }
        else if ( cmp > 0 ) {
            node.right = delete( node.right, key );
        }
        else {
            if ( node.left == null ) {
                return node.right;
            }
            if ( node.right == null ) {
                return node.left;
            }

            Node tmp = node;

            node = max( node.left );
            node.left = deleteMax( tmp.left );
            node.right = tmp.right;
            tmp = null;
        }

        node.size = this.size( node.left ) + this.size( node.right ) + 1;
        node.height = this.height( node.left ) + this.height( node.right ) + 1;
        return node;
    }
}
