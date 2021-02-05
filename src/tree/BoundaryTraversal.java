package tree;

//Print root
//Print left boundary in top down
//Print leaf node
//Print right boundary in bottom up manner
public class BoundaryTraversal {

    public static void main(String args[]) {
        BinaryTreeSimple tree = new BinaryTreeSimple();
        tree.root = new NodeSimple(20);
        tree.root.left = new NodeSimple(8);
        tree.root.left.left = new NodeSimple(4);
        tree.root.left.right = new NodeSimple(12);
        tree.root.left.right.left = new NodeSimple(10);
        tree.root.left.right.right = new NodeSimple(14);
        //The solution done by both Tushar and GFG is wrong as it does does not satisfy the condition of right tree missing
        //The correct solution will be
        //1. Take left view of tree
        //2. Take Right view of tree
        //3. Take bottom view of tree. Handle duplicates.
/*        tree.root.right = new NodeSimple(22);
        tree.root.right.right = new NodeSimple(25);*/
        new BoundaryTraversal().printBoundary(tree.root);
    }

    private  void printBoundary(NodeSimple node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);

        // Print all leaf nodes
        printLeaf(node.left);
        printLeaf(node.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right);
    }

    private void printBoundaryRight(NodeSimple node)
    {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
    private void printBoundaryLeft(NodeSimple node)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }


    private static void printLeaf(NodeSimple root) {
        if (root == null)
            return;

        printLeaf(root.left);
        // Print it if it is a leaf node
        if (root.left == null && root.right == null)
            System.out.print(root.data + " ");
        printLeaf(root.right);
    }
}
