package com.middle.code_2327;

/**
 * @Author chenyuxiang
 * @Date 2025-09-09
 * @Description
 */
public class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = Math.max(1, i - forget + 1); j <= i - delay; j++) {
                dp[i] = (dp[i] + dp[j]) % mod;
            }
        }
        
        int result = 0;
        for (int i = Math.max(1, n - forget + 1); i <= n; i++) {
            result = (result + dp[i]) % mod;
        }
        return result;
    }
}

