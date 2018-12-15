package lesson7;

import java.util.LinkedList;

/**
 * Graph -
 *
 * @version 1.0.1
 * @package lesson7
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class Graph {

    /**
     * @access private
     * int vertexCount - количество вершин
     */
    private int vertexCount;

    /**
     * @access private
     * int edgeCount - количество ребер
     */
    private int edgeCount;

    /**
     * @access private
     * LinkedList<Integer>[] -
     */
    private LinkedList<Integer>[] adjLists;

    /**
     * Graph - конструктор
     * @param vertexCount
     */
    public Graph ( int vertexCount ) {
        if ( vertexCount < 0 ) {
            throw new IllegalArgumentException();
        }

        this.vertexCount = vertexCount;

        this.adjLists = new LinkedList[vertexCount];

        for ( int i = 0; i < vertexCount; i++ ) {
            this.adjLists[i] = new LinkedList<>();
        }
    }

    /**
     * getVertexCount -
     * @return
     */
    public int getVertexCount () {
        return this.vertexCount;
    }

    /**
     * getEdgeCount -
     * @return int
     */
    public int getEdgeCount () {
        return this.edgeCount;
    }

    /**
     * addEdge -
     * @param v1 -
     * @param v2 -
     */
    public void addEdge ( int v1, int v2 ) {
        if ( v1 < 0 || v2 < 0 ) {
            throw new IllegalArgumentException();
        }

        this.adjLists[v1].add(v2);
        this.adjLists[v2].add(v1);
    }

    /**
     * getAdjLists -
     * @param vertex
     * @return LinkedList<Integer>
     */
    public LinkedList<Integer> getAdjLists ( int vertex) {
        return this.adjLists[vertex];
    }
}
