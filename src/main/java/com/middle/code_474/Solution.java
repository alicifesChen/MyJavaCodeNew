package com.middle.code_474;

/**
 * @Author chenyuxiang
 * @Date 2025-11-11
 * @Description
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0) return 0;
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1]; //最大的限制
        //遍历字符串
        for (int i = 1; i <= len; i++) {
            //计算当前字符串的0和1的个数
            int zeros = 0, ones = 0;
            for (char c : strs[i - 1].toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            //倒序遍历背包容量(dp数组)
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
