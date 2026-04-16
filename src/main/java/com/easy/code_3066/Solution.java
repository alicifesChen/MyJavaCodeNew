package com.easy.code_3066;

import java.util.PriorityQueue;

/**
 * @Author chenyuxiang
 * @Date 2025/1/15
 * @Description
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.offer((long) x);
        }

        while (pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            pq.offer(x * 2 + y);
            ans++;
        }
        return ans;
    }

}
