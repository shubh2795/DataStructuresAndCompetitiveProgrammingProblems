package graphs;

import java.util.*;

// Adjacency list and matrix representation of a graph
public class Graphs {
    private int numNodes;
    private int[][] matrix;
    private List<List<Integer>> list;


    public Graphs(int n) {
        this.numNodes = n;
        this.matrix = new int[this.numNodes][this.numNodes];
        list = new ArrayList<>();
        for (int i = 0; i < this.numNodes; i++) {
            list.add(new ArrayList<Integer>());
        }
    }

    public void addEdgeMatrix(int i, int j) {
        if (i < 0 || i >= this.numNodes || j < 0 || j >= this.numNodes) {
            System.out.println("Invalid nodes provided for adding edges");
            return;
        }
        this.matrix[i][j] = 1;
        this.matrix[j][i] = 1;
    }

    public void removeEdgeMatrix(int i, int j) {
        if (i < 0 || i >= this.numNodes || j < 0 || j >= this.numNodes) {
            System.out.println("Invalid nodes provided for removing edges");
            return;
        }
        this.matrix[i][j] = 0;
        this.matrix[j][i] = 0;

    }


    public void toMatrixString() {
        for (int i = 0; i < this.matrix.length; i++) {
            System.out.println(Arrays.toString(this.matrix[i]));
        }
    }


    public void addEdgeList(int i, int j) {
        this.list.get(i).add(j);
        this.list.get(j).add(i);
    }

    public void removeEdgeList(int i, int j) {
        List<Integer> temp = this.list.get(i);
        for (int k = 0; k < temp.size(); k++) {
            if (temp.get(k) == j) {
                temp.remove(k);
                break;
            }
        }
        temp = this.list.get(j);
        for (int k = 0; k < temp.size(); k++) {
            if (temp.get(k) == i) {
                temp.remove(k);
                break;
            }
        }
    }


    public void toListString() {
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println("head: " + i);
            for (int x : this.list.get(i))
                System.out.print(x + " -> ");
            System.out.print("null\n");
        }
    }

    public void addEdge(int i, int j) {
        addEdgeList(i, j);
        addEdgeMatrix(i, j);
    }

    public void removeEdge(int i, int j) {
        removeEdgeMatrix(i, j);
        removeEdgeList(i, j);
    }


    public static void main(String[] args) {
        Graphs graph = new Graphs(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Printing List");
        graph.toListString();
        System.out.println("Printing Matrix");
        graph.toMatrixString();
        graph.removeEdge(1, 4);

        System.out.println("Printing List");
        graph.toListString();
        System.out.println("Printing Matrix");
        graph.toMatrixString();
    }

}
