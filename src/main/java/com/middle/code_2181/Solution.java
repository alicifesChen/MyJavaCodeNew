package com.middle.code_2181;

/**
 * @Author chenyuxiang
 * @Date 2024/9/9
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

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int sum = 0;
        while (head != null) {
            if (head.val != 0) {
                sum += head.val;
            } else {
                ListNode node = new ListNode();
                node.val = sum;
                cur.next = node;
                cur = cur.next;
                sum = 0;
            }
            head = head.next;
        }
        return dummy.next.next;
    }
}
