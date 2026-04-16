package com.middle.code_3381;

/**
 * @Author chenyuxiang
 * @Date 2025-11-27
 * @Description
 */
public class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n];
        long tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp += nums[i];
            dp[i] = 0;
        }
        dp[k - 1] = tmp;
        long ans = tmp;
        for (int i = k; i < n; i++) {
            tmp = tmp + nums[i] - nums[i - k];
            dp[i] = Math.max(tmp, dp[i - k] + tmp);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
