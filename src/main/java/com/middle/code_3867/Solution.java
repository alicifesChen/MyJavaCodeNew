package com.middle.code_3867;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2026-07-16
 * @Description
 */
public class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        long sum = 0;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            dp[i] = gcd(max, nums[i]);
        }
        Arrays.sort(dp);
        for(int i = 0; i < n / 2; i++){
            sum += gcd(dp[i], dp[n - 1 - i]);
        }
        return sum;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
