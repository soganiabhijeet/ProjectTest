package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

    private class Node {
        Node left;
        Node right;
        Node next;
        int data;

        @Override
        public String toString() {
            return "Node{" +
                    ", next=" + next +
                    ", data=" + data +
                    '}';
        }
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.next = null;
        newNode.right = null;
        return newNode;
    }

    public static void main(String[] args) {
        ConnectNodesAtSameLevel a = new ConnectNodesAtSameLevel();
        Node root = a.createNewNode(12);
        root.left = a.createNewNode(7);
        root.left.left = a.createNewNode(6);
        root.left.right = a.createNewNode(9);
        root.right = a.createNewNode(24);
        a.connectNodeUsingQueue(root);
        a.printTree(root);

    }

    private void connectNodesAtSameLevelWithoutUsingQueue(Node node) {
        node.next=null;
        while (node!=null){
            Node currentNode = node;

            while(currentNode != null) {
                if(currentNode.left != null) {
                    if(currentNode.right != null) {
                        currentNode.left.next = currentNode.right;
                    } else {
                        currentNode.left.next = getNextRight(currentNode);
                    }
                }

                if(currentNode.right != null) {
                    currentNode.right.next = getNextRight(currentNode);
                }

                currentNode = currentNode.next;
            }
            if(node.left != null) {
                node = node.left;
            } else if(node.right != null) {
                node = node.right;
            } else {
                node = getNextRight(node);
            }
        }

        }

    public Node getNextRight(Node node) {
        Node tmp = node.next;

        while(tmp != null) {
            if(tmp.left != null) {
                return tmp.left;
            } else if(tmp.right != null) {
                return tmp.right;
            }
            tmp = tmp.next;
        }
        return null;
    }

    private void connectNodeUsingQueue(Node root) {
        Queue<Node> nodeQueue = new LinkedList();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node prev = null;
            int size = nodeQueue.size();
            //Get size of the level in the beginning
            for (int i = 0; i < size; i++) {
                Node node = nodeQueue.poll();
                node.next = prev;
                prev = node;
                if (node.left != null) {
                    nodeQueue.add(node.left);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                }
            }
        }
    }

    private void printTree(Node root) {
        if (root != null) {
            System.out.println(root.toString());
            printTree(root.left);
            printTree(root.right);
        }
    }


}

