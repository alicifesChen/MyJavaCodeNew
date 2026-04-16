package com.easy.code_70;

/**
 * @Author chenyuxiang
 * @Date 2025/2/21
 * @Description
 */
public class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n];
        if (n == 1) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }
}
