package tree;

import java.util.HashMap;

//TODO remember this https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
public class BinaryTreeFromParentRepresentation {
    public static void main(String args[]) {
        BinaryTreeFromParentRepresentation btpp = new BinaryTreeFromParentRepresentation();
        int input[] = {1, 5, 5, 2, 2, -1, 3};
        NodeSimple root = btpp.createTree(input, input.length);
        BinaryTreeSimple binaryTreeSimple = new BinaryTreeSimple();
        binaryTreeSimple.root = root;
        binaryTreeSimple.printInorder(root);

    }

    HashMap<Integer, NodeSimple> map = new HashMap();
    NodeSimple root = null;

    public NodeSimple createTree(int parent[], int N) {
        for (int i = 0; i < N; i++) {
            createNode(parent, i);
        }
        return root;
    }

    private NodeSimple createNode(int parent[], int i) {
        if (!map.containsKey(i)) {
            NodeSimple node = new NodeSimple(i);
            int parentIndex = parent[i];
            if (parentIndex == -1) {
                map.put(i, node);
                root = node;
                return node;
            }
            //Check if parent exists

            if (!map.containsKey(parentIndex)) {
                //Create parent
                createNode(parent, parentIndex);
            }
            NodeSimple parentNode = map.get(parentIndex);

            if (parentNode.left == null) {
                parentNode.left = node;
            }
            else if (parentNode.right == null) {
                parentNode.right = node;
            }
            map.put(i, node);
        }
        return map.get(i);
    }
}
