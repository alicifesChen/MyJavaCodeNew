package com.middle.code_1382;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-02-09
 * @Description
 */
public class Solution {
    private List<Integer> sortedNodes = new ArrayList<>();

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        sortedNodes.add(node.val);
        inOrder(node.right);
    }

    private TreeNode buildBalancedTree(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(sortedNodes.get(mid));
        node.left = buildBalancedTree(left, mid - 1);
        node.right = buildBalancedTree(mid + 1, right);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        // 第一步：中序遍历，得到有序数组
        inOrder(root);
        // 第二步：通过二分法重新构建平衡树
        return buildBalancedTree(0, sortedNodes.size() - 1);
    }
}
