package com.easy.code_1290;

/**
 * @Author chenyuxiang
 * @Date 2025/7/14
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

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
        }
        return Integer.parseInt(sb.toString(), 2); // 将二进制字符串转换为十进制整数
    }
}
