package com.middle.code_2058;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-08-31
 * @Description 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
 * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。
 * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
 * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
 * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
 * 示例 1：
 * 输入：head = [3,1]
 * 输出：[-1,-1]
 * 解释：链表 [3,1] 中不存在临界点。
 * 示例 2：
 * 输入：head = [5,3,1,2,5,1,2]
 * 输出：[1,3]
 * 解释：存在三个临界点：
 * - [5,3,1,2,5,1,2]：第三个节点是一个局部极小值点，因为 1 比 3 和 2 小。
 * - [5,3,1,2,5,1,2]：第五个节点是一个局部极大值点，因为 5 比 2 和 1 大。
 * - [5,3,1,2,5,1,2]：第六个节点是一个局部极小值点，因为 1 比 5 和 2 小。
 * 第五个节点和第六个节点之间距离最小。minDistance = 6 - 5 = 1 。
 * 第三个节点和第六个节点之间距离最大。maxDistance = 6 - 3 = 3 。
 * 示例 3：
 * 输入：head = [1,3,2,2,3,2,2,2,7]
 * 输出：[3,3]
 * 解释：存在两个临界点：
 * - [1,3,2,2,3,2,2,2,7]：第二个节点是一个局部极大值点，因为 3 比 1 和 2 大。
 * - [1,3,2,2,3,2,2,2,7]：第五个节点是一个局部极大值点，因为 3 比 2 和 2 大。
 * 最小和最大距离都存在于第二个节点和第五个节点之间。
 * 因此，minDistance 和 maxDistance 是 5 - 2 = 3 。
 * 注意，最后一个节点不算一个局部极大值点，因为它之后就没有节点了。
 * 示例 4：
 * 输入：head = [2,3,3,2]
 * 输出：[-1,-1]
 * 解释：链表 [2,3,3,2] 中不存在临界点。
 */
public class Solution {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
          ListNode prev = head;
          ListNode curr = head.next;
          List<Integer> criticalPoints = new ArrayList<>();
          int index = 1; // 当前节点的索引，从 1 开始
          while (curr != null && curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
                criticalPoints.add(index);
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
          if (criticalPoints.size() < 2) {
              return new int[]{-1, -1};
          }
          int minDistance = Integer.MAX_VALUE;
          int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
          for (int i = 1; i < criticalPoints.size(); i++) {
              minDistance = Math.min(minDistance, criticalPoints.get(i) - criticalPoints.get(i - 1));
          }
          return new int[]{minDistance, maxDistance};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head1 = solution.new ListNode(3);
        head1.next = solution.new ListNode(1);
        int[] result1 = solution.nodesBetweenCriticalPoints(head1);
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]");

        ListNode head2 = solution.new ListNode(5);
        head2.next = solution.new ListNode(3);
        head2.next.next = solution.new ListNode(1);
        head2.next.next.next = solution.new ListNode(2);
        head2.next.next.next.next = solution.new ListNode(5);
        head2.next.next.next.next.next = solution.new ListNode(1);
        head2.next.next.next.next.next.next = solution.new ListNode(2);
        int[] result2 = solution.nodesBetweenCriticalPoints(head2);
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]");

        ListNode head3 = solution.new ListNode(1);
        head3.next = solution.new ListNode(3);
        head3.next.next = solution.new ListNode(2);
        head3.next.next.next = solution.new ListNode(2);
        head3.next.next.next.next = solution.new ListNode(3);
        head3.next.next.next.next.next = solution.new ListNode(2);
        head3.next.next.next.next.next.next = solution.new ListNode(2);
        head3.next.next.next.next.next.next.next = solution.new ListNode(2);
        head3.next.next.next.next.next.next.next.next = solution.new ListNode(7);
        int[] result3 = solution.nodesBetweenCriticalPoints(head3);
        System.out.println("Result 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}
