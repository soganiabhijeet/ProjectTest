package tree;

public class BinaryTreeToDoubleLinkList {
    // head --> Pointer to head node of created doubly linked list
    NodeSimple head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static NodeSimple prev = null;

    public static void main(String args[]) {
        BinaryTreeToDoubleLinkList btd = new BinaryTreeToDoubleLinkList();
        // Let us create the tree as shown in above diagram
        BinaryTreeSimple tree = new BinaryTreeSimple();
        tree.root = new NodeSimple(10);
        tree.root.left = new NodeSimple(12);
        tree.root.right = new NodeSimple(15);
        tree.root.left.left = new NodeSimple(25);
        tree.root.left.right = new NodeSimple(30);
        tree.root.right.left = new NodeSimple(36);
        btd.toDoubleLL(tree.root);
        //btd.print(head);
    }

    private void toDoubleLL(NodeSimple root) {
        if (root != null) {
            toDoubleLL(root.left);
            if (prev == null) {
                head = root;
            } else {
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            toDoubleLL(root.right);
        }
    }
}
