package com.middle.code_1504;

/**
 * @Author chenyuxiang
 * @Date 2025-08-21
 * @Description
 */
public class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = (i == 0 ? 0 : dp[i - 1][j]) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            }
        }
        return res;
    }
}

