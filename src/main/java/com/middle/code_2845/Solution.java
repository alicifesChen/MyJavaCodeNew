package com.middle.code_2845;

import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/4/25
 * @Description
 */
public class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (nums.get(i) % modulo == k ? 1 : 0);
        }
        int[] cnt = new int[Math.min(n + 1, modulo)];
        long ans = 0;
        for (int s : sum) {
            if (s >= k) {
                ans += cnt[(s - k) % modulo];
            }
            cnt[s % modulo]++;
        }
        return ans;
    }
}
