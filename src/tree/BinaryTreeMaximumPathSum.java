package tree;

//youtube.com/watch?v=TO5zsKtc1Ic&ab_channel=TECHDOSE
/*
3 cases:
1. Current node is part of the sum, and is not the root node.
2. current node is part of the sum and the root node.
3. Current node is not part of the sum at all.

We will keep max as Max.(max, case 1 and 2)
But we will return only case 1 as next iteration value.
 */

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class BinaryTreeMaximumPathSum {
    Integer max = Integer.MIN_VALUE;

    public int maxPathSum(NodeSimple root) {
        maxPathSumRecur(root);
        return max;
    }

    int maxPathSumRecur(NodeSimple root) {
        if (root != null) {
            int leftMax = maxPathSumRecur(root.left);
            int rightMax = maxPathSumRecur(root.right);
            //Current node is part of the sum, and is not the root node.
            if (leftMax < 0) {
                leftMax = 0;
            }
            if (rightMax < 0) {
                rightMax = 0;
            }
            int maxWithCurrNodeAsRoot = root.data + leftMax + rightMax;
            int maxWithCurrNode = root.data + Integer.max(leftMax, rightMax);
            int getGreatest = getGreatestAmongThreeNumbers(maxWithCurrNode, maxWithCurrNodeAsRoot, max);
            if (getGreatest > max) {
                max = getGreatest;
            }
            return maxWithCurrNode;

        }
        return 0;
    }

    private int getGreatestAmongThreeNumbers(int a, int b, int c) {
        int max;
        max = Integer.max(a, b);
        return Integer.max(max, c);
    }
}
