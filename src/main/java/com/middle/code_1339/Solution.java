package com.middle.code_1339;

/**
 * @Author chenyuxiang
 * @Date 2026-01-07
 * @Description
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxProduct(TreeNode root) {
        int MOD = 1_000_000_007;
        long totalSum = getTotalSum(root);
        long[] maxProduct = new long[1];
        calculateSubtreeSum(root, totalSum, maxProduct);
        return (int) (maxProduct[0] % MOD);
    }

    private long calculateSubtreeSum(TreeNode node, long totalSum, long[] maxProduct) {
        if (node == null) {
            return 0;
        }
        long leftSum = calculateSubtreeSum(node.left, totalSum, maxProduct);
        long rightSum = calculateSubtreeSum(node.right, totalSum, maxProduct);
        long currentSum = node.val + leftSum + rightSum;
        long product = currentSum * (totalSum - currentSum);
        maxProduct[0] = Math.max(maxProduct[0], product);
        return currentSum;
    }


    private long getTotalSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }
}
