package com.hard.code_239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author chenyuxiang
 * @Date 2024/8/7
 * @Description
 */

//队列的操作，pollLast()、pollFirst()、peekLast()、peekFirst()、addLast()、addFirst()
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

//        for (int i = k - 1; i < nums.length; i++) {
//            //当窗口形成后，每次移动窗口，先判断队列头部是否在窗口内，不在则移除
//            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
//                deque.pollFirst();
//            }
//            //每次移动窗口，先判断队列尾部是否小于当前值，小于则移除
//            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
//                deque.pollLast();
//            }
//            deque.addLast(i);
//            res[i - k + 1] = nums[deque.peekFirst()];
//        }
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = solution.maxSlidingWindow(nums, k);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
