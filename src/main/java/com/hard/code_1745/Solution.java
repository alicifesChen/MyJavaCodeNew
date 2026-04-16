package com.hard.code_1745;

/**
 * @Author chenyuxiang
 * @Date 2025/3/4
 * @Description
 */
public class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            dp[i][i] = true;
            dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        //开始找是否能分成三个回文子串，即能否找到两个分割点
        for (int spOne = 0; spOne + 2 < n; spOne++) {
            for (int spTwo = spOne + 1; spTwo + 1 < n; spTwo++) {
                if (dp[0][spOne] && dp[spOne + 1][spTwo] && dp[spTwo + 1][n- 1]) return true;
            }
        }
        return false;
    }
}
