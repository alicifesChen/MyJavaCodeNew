package com.middle.code_122;

import org.w3c.dom.ls.LSOutput;

/**
 * @Author chenyuxiang
 * @Date 2025-12-17
 * @Description
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            dp[i] = Math.max(dp[i], dp[i - 1] + Math.max(0, prices[i] - prices[i - 1]));
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7,1,5,3,6,4};
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }
}
