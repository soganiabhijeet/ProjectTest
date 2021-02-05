package graph;

import java.util.HashMap;

/**
 * @author tusroy
 * Date 06/20/2015
 * <p>
 * Video link - https://youtu.be/ID00PMy0-vE
 * <p>
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 * <p>
 * For m operations and total n elements time complexity is O(m*f(n)) where f(n) is
 * very slowly growing function. For most cases f(n) <= 4 so effectively
 * total time will be O(m). Proof in Coreman book.
 */
public class DisjointSet {
    HashMap<Integer, Node> dataToNodeMap = new HashMap<>();

    class Node {
        Integer data;
        Node parent;
        Integer rank;
    }

    public void makeSet(Integer data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        dataToNodeMap.put(data, node);
    }

    /**
     * Combines two sets together to one.
     * Does union by rank
     *
     * @return true if data1 and data2 are in different set before union else false.
     */
    public boolean union(Integer first, Integer second) {
        Node firstNode = dataToNodeMap.get(first);
        Node secondNode = dataToNodeMap.get(second);
        if (firstNode.parent == secondNode.parent) {
            return false;
        } else {
            if (firstNode.parent.rank >= secondNode.parent.rank) {
                secondNode.parent.parent = firstNode.parent;
                firstNode.parent.rank = firstNode.parent.rank + 1;
            } else {
                firstNode.parent.parent = secondNode.parent;
            }
            return true;
        }
    }

    public Node findSet(Integer value) {
        return findSetRecursive(dataToNodeMap.get(value));
    }

    private Node findSetRecursive(Node node) {
        if (node.parent == node) {
            //Found parentSet
            return node;
        }
        node.parent = findSetRecursive(node.parent);
        return node.parent;

    }

}
