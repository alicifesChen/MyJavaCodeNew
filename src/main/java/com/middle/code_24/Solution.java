package com.middle.code_24;

/**
 * @Author chenyuxiang
 * @Date 2024/6/24
 * @Description
 */
public class Solution {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode swapPairs(ListNode head) {
          ListNode dummy = new ListNode(0, head);
          ListNode cur = dummy;
          while (dummy != null && dummy.next != null && dummy.next.next != null) {
              ListNode first = dummy.next;
              ListNode second = dummy.next.next;
              dummy.next = second;
              first.next = second.next;
              second.next = first;
              dummy = first;
          }
          return cur.next;
    }
}
