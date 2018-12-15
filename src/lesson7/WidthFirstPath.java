package lesson7;

import java.util.LinkedList;

public class WidthFirstPath {

    /**
     * @access private
     * boolean[] markers - массив для посещенных вершин
     */
    private boolean[] marked;

    /**
     * @access private
     * int[] edgeTo - массив возврада для нахождения путей
     */
    private int[] edgeTo;

    /**
     * @access private
     * int[] distTo - массив сод-й кратчайшее растояние от заданной вершины
     */
    private int[] distTo;

    /**
     * @access private
     * int source - вершина из которой
     */
    private int source;

    /**
     * @access private
     * int INF -
     */
    private static final int INF = Integer.MAX_VALUE;

    /**
     * WidthFirstPath - конструктор
     * @param g - исходный граф
     * @param source - вершина
     */
    public WidthFirstPath ( Graph g, int source ) {

        this.marked = new boolean[g.getVertexCount()];
        this.edgeTo = new int[g.getVertexCount()];
        this.distTo = new int[g.getVertexCount()];

        for (int i = 0; i < this.distTo.length; i++) {
            this.distTo[i] = INF;
        }

        this.wfs( g, source );
    }

    /**
     * wfs -
     * @param g - граф
     * @param source -
     */
    private void  wfs ( Graph g, int source ) {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast( source );

        this.marked[source] = true;

        this.distTo[source] = 0;

        while ( !queue.isEmpty() ) {

            int vertex = queue.removeFirst();
            for( int w: g.getAdjLists( vertex ) ) {

                if ( !this.marked[w] ) {

                    this.marked[w] = true;
                    this.edgeTo[w] = vertex;
                    this.distTo[w] = this.distTo[vertex] + 1;
                    queue.addLast(w);
                }
            }
        }
    }

    /**
     * hasPathTo -
     * @param dist
     * @return boolean
     */
    public boolean hasPathTo ( int dist ) {
        return this.marked[dist];
    }

    /**
     * pathTo -
     * @param dist -
     * @return LinkedList<Integer>
     */
    public LinkedList<Integer> pathTo ( int dist ) {

        if ( !this.hasPathTo( dist ) ) {
            return null;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        int vertex = dist;

        while ( vertex != this.source ) {
            stack.push( vertex );
            vertex = this.edgeTo[vertex];
        }

        return stack;
    }

    /**
     * distTo -
     * @param dist
     * @return int
     */
    public int distTo ( int dist ) {
        return this.distTo[dist];
    }
}
