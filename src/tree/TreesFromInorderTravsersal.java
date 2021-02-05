package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TreesFromInorderTravsersal {
    //Find all possible binary trees with given Inorder Traversal https://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

    static class BinaryTree {

        Node root;

        // A utility function to do preorder traversal of BST
        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        List<Node> getTrees(int start, int end, int arr[]) {
            List<Node> listOfTrees = new ArrayList<>();
            if (start > end) {
                //TRICK this is to return non zero size list if there is not tree present in left and right sub tree
                //Left and right node will be assigned as null.
                listOfTrees.add(null);
                return listOfTrees;
            }
            for (int i = start; i <= end; i++) {
                List<Node> leftSubTree = getTrees(start, i - 1, arr);
                List<Node> rightSubTree = getTrees(i + 1, end, arr);
                //each combination can be linked to i
                for (int leftIter = 0; leftIter < leftSubTree.size(); leftIter++) {
                    for (int rightItr = 0; rightItr < rightSubTree.size(); rightItr++) {
                        Node node = new Node(arr[i]);
                        node.left = leftSubTree.get(leftIter);
                        node.right = rightSubTree.get(rightItr);
                        listOfTrees.add(node);
                    }
                }
            }
            return listOfTrees;
        }


    }


    public static void main(String args[]) {
        int in[] = {4};
        int n = in.length;
        BinaryTree tree = new BinaryTree();
        List<Node> trees = tree.getTrees(0, n - 1, in);
        System.out.println("Preorder traversal of different " +
                " binary trees are:");
        for (int i = 0; i < trees.size(); i++) {
            tree.preOrder(trees.get(i));
            System.out.println("");
        }
    }
}
