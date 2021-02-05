package tree;

public class AddGreaterValueNodeToEveryNode {

    static class IntegerRef {
        public IntegerRef(int val) {
            this.val = val;
        }

        int val;
    }

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(5, root);
        root = bt.addNode(20, root);
        root = bt.addNode(15, root);
        root = bt.addNode(25, root);
        AddGreaterValueNodeToEveryNode agv = new AddGreaterValueNodeToEveryNode();
        IntegerRef ir = new IntegerRef(0);
        agv.add(root, ir);
        TreeTraversals tt = new TreeTraversals();
        tt.inOrder(root);
    }

    private void add(Node root, IntegerRef sum) {
        if (root != null) {
            add(root.right, sum);
            Integer temp = root.data;
            root.data = root.data + sum.val;
            sum.val = sum.val + temp;
            add(root.left, sum);

            /*add(root.right,ref);
            root.data += ref.val;
            ref.val = root.data;
            add(root.left,ref);*/
        }
    }
}
