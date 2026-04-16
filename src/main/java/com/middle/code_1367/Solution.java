package com.middle.code_1367;

/**
 * @Author chenyuxiang
 * @Date 2024/12/30
 * @Description
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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

    //root 是orgin tree的root

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true; // 空链表总是匹配
        }
        if (root == null) {
            return false; // 树为空但链表不为空，无法匹配
        }
        // 如果当前节点匹配链表头，尝试两种情况：
        // 1. 继续匹配链表的下一个节点
        // 2. 从当前节点的左右子节点重新开始匹配链表的头
        if (root.val == head.val && (isSubPathHelper(head.next, root.left) || isSubPathHelper(head.next, root.right))) {
                return true;
            }
        // 无论当前节点是否匹配，都需要在左右子树中继续查找
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSubPathHelper(ListNode head, TreeNode root) {
        if (head == null) {
            return true; // 链表已完全匹配
        }
        if (root == null) {
            return false; // 树路径结束但链表未结束
        }
        if (root.val != head.val) {
            return false; // 当前节点不匹配
        }
        // 继续匹配链表的下一个节点
        return isSubPathHelper(head.next, root.left) || isSubPathHelper(head.next, root.right);
    }
}
