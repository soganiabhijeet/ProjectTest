package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static HashMap<Integer, Boolean> visited = new HashMap();
    static Queue queue = new LinkedList();

    // Driver method to
    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFSUsingQueue(2);
    }

    public static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
                visited.put(i, false);
            }

        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public void BFS(int i) {
            if (!visited.get(i)) {
                System.out.println(i);
                visited.put(i, true);
                for (int size = 0; size < adj[i].size(); size++) {
                    BFS(adj[i].get(size));
                }
            }

        }

        public void BFSUsingQueue(int i) {
            queue.add(i);
            while (!queue.isEmpty()) {
                Integer head = (Integer) queue.peek();
                if (!visited.get(head)) {
                    System.out.println(head);
                    visited.put(head, true);
                    for (int size = 0; size < adj[head].size(); size++) {
                        queue.add(adj[head].get(size));
                    }
                    queue.remove();
                }
            }
        }
    }
}
