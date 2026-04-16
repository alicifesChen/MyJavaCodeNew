package com.easy.code_0207;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/6/25
 * @Description
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> stack1 = new ArrayList<>();
        List<ListNode> stack2 = new ArrayList<>();
        while (headA != null) {
            stack1.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stack2.add(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.get(stack1.size() - 1) == stack2.get(stack2.size() - 1)) {
            res = stack1.get(stack1.size() - 1);
            stack1.remove(stack1.size() - 1);
            stack2.remove(stack2.size() - 1);
        }
        return res;
    }
}
