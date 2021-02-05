package tree;

public class BSTSearch {

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(20, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(0, root);
        root = bt.addNode(21, root);
        root = bt.addNode(-1, root);
        BSTSearch bstSearch = new BSTSearch();
        Node result = bstSearch.search(root, 21);
        assert result.data == 21;

        result = bstSearch.search(root, -1);
        assert result.data == 21;

        result = bstSearch.search(root, 11);
        assert result == null;
    }

    private Node search(Node root, int i) {
        if (root != null) {
            if (root.data == i) {
                return root;
            } else if (root.data > i) {
                return root.left;
            } else {
                return root.right;
            }
        }
        return null;
    }
}
