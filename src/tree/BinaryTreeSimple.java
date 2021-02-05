package tree;

class NodeSimple
{
    int data;
    NodeSimple left, right;

    NodeSimple(int item)
    {
        data = item;
        left = right = null;
    }
}
public class BinaryTreeSimple {
    NodeSimple root;
    public void printInorder(NodeSimple node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }
}
