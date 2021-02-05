package tree;

public class ArbitaryTreeToChildSumTree {
    //cannot decrement

    public static void main(String args[]) {
        ArbitaryTreeToChildSumTree att = new ArbitaryTreeToChildSumTree();
        BinaryTree bt = new BinaryTree();
        Node head = null;
        BinaryTreeSimple tree = new BinaryTreeSimple();
        tree.root = new NodeSimple(50);
        tree.root.left = new NodeSimple(7);
        tree.root.right = new NodeSimple(2);
        tree.root.left.left = new NodeSimple(3);
        tree.root.left.right = new NodeSimple(5);
        tree.root.right.left = new NodeSimple(1);
        tree.root.right.right = new NodeSimple(30);
        tree.printInorder(tree.root);
        att.childSumTree(tree.root);
        System.out.println("\n");
        tree.printInorder(tree.root);
    }

    private void childSumTree(NodeSimple head) {
        childSumTreeRecur(head);
    }

    //Will increment the value and return
    private NodeSimple childSumTreeRecur(NodeSimple head) {
        if (head != null) {
            childSumTreeRecur(head.left);
            childSumTreeRecur(head.right);
            Integer leftVal = 0;
            Integer rightVal = 0;
            if (head.left != null) {
                leftVal = head.left.data;
            }
            if (head.right != null) {
                rightVal = head.right.data;
            }
            if(head.data<leftVal+rightVal){
                head.data=leftVal+rightVal;
            }else if(head.data>(leftVal+rightVal)){
                incrementChildNodeRecur(head, head.data-(leftVal+rightVal));
            }
        }
        return head;
    }

    private void incrementChildNodeRecur(NodeSimple node, Integer value){
        //Give precedence to left child
        if(node!=null){
            if (node.left != null) {
                node.left.data+=value;
                incrementChildNodeRecur(node.left, value);
            }else if(node.right!=null){
                node.right.data+=value;
                incrementChildNodeRecur(node.right, value);
            }
        }
    }


}
