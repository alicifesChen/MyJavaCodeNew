package com.middle.code_19;

/**
 * @Author chenyuxiang
 * @Date 2024/6/25
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0, head);
//        ListNode slow = dummy;
//        for(int i = 0; i < n; i++) {
//            dummy = dummy.next;
//        }
//        while (dummy.next != null) {
//            dummy = dummy.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return head;
        ListNode dummy = new ListNode(0, head); // 创建一个哑结点
        ListNode fast = dummy; // fast 指针从哑结点开始
        ListNode slow = dummy; // slow 指针也从哑结点开始

        // fast 指针先前移 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // fast 和 slow 一起移动直到 fast 指针到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除 slow 指针的下一个节点
        slow.next = slow.next.next;

        // 返回哑结点的下一个节点，即新的头结点
        return dummy.next;
    }
}
