package com.easy.code_206;

/**
 * @Author chenyuxiang
 * @Date 2024/6/21
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

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        ListNode result = solution.reverseList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
