package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    static HashMap<Integer, Boolean> visited = new HashMap();
    static Stack<Integer> stack = new Stack();

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(2);
    }

    static class Graph {
        private int V;   // No. of vertices 

        // Array  of lists for Adjacency List Representation 
        private LinkedList<Integer> adj[];

        // Constructor 
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
                visited.put(i, false);
            }

        }

        //Function to add an edge into the graph 
        void addEdge(int v, int w) {
            adj[v].add(w);  // Add w to v's list. 
        }

        public void DFS(int i) {
            stack.push(i);
            while (!stack.empty()) {
                Integer element = stack.pop();
                if (!visited.get(element)) {
                    System.out.println(element);
                    visited.put(element, true);
                    for (int size = 0; size < adj[element].size(); size++) {
                        stack.push(adj[element].get(size));
                    }
                }
            }
        }
    }
}
