package tree;

public class PostOrderBST {
    //https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/

    //https://algorithms.tutorialhorizon.com/construct-binary-search-tree-from-a-given-preorder-traversal-using-recursion/
    // Driver program to test above functions
    public static void main(String[] args) {
        PostOrderBST tree = new PostOrderBST();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }

    private void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // The main function to construct BST from given preorder traversal.
    // This function mainly uses constructTreeUtil()
    Node constructTree(int pre[], int size) {
        int preIndex = 0;
        return constructTreeUtil(pre, preIndex, pre[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE, size);
    }

    Node constructTreeUtil(int pre[], Integer preIndex, int key,
                           int min, int max, int size) {
        if (preIndex > size) {
            return null;
        }
        if (pre[preIndex] < min && pre[preIndex] > max) {
            return null;
        }
        Node root = new Node(pre[preIndex]);
        preIndex = preIndex + 1;
        if (preIndex < size) {

            root.left = constructTreeUtil(pre, preIndex,
                    pre[preIndex], min, key, size);

            // All nodes which are in range {key..max}
            // will go in right subtree, and first such
            // node will be root of right subtree.
            root.right = constructTreeUtil(pre, preIndex,
                    pre[preIndex], key, max, size);
        }
        return root;
    }

    class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
