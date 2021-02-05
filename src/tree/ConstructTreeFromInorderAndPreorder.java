package tree;

public class ConstructTreeFromInorderAndPreorder {
    private static Integer preIndex = 0;

    class Node {

        char data;
        ConstructTreeFromInorderAndPreorder.Node left, right;

        Node(char d) {
            data = d;
            left = right = null;
        }
    }

    Node constructRecursiveTree(char[] pre, char[] inorder, int start, int end) {
        if (start == end) {
            //Leaf node
            return new Node(pre[preIndex++]);
        }
        if (start > end) {
            return null;
        }
        //Find inorder index
        int index = searchIndex(inorder, pre[preIndex]);
        Node node = new Node(pre[preIndex++]);
        node.left = constructRecursiveTree(pre, inorder, start, index - 1);
        node.right = constructRecursiveTree(pre, inorder, index + 1, end);
        return node;

    }

    // driver program to test above functions
    public static void main(String args[])
    {
        ConstructTreeFromInorderAndPreorder tree = new ConstructTreeFromInorderAndPreorder();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = tree.constructRecursiveTree(pre, in, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }

    private void printInorder(Node node) {

        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }


    private Integer searchIndex(char[] arr, char value) {
        int index = 0;
        for (int temp : arr) {
            if (temp == value) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }


}
