package com.easy.code_203;

/**
 * @Author chenyuxiang
 * @Date 2024/6/20
 * @Description
 */
public class Solution {
    public static class ListNode {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next; // 删除下一个节点
            } else {
                cur = cur.next; // 继续向后遍历链表
            }
        }
        return dummy.next;
    }
}
