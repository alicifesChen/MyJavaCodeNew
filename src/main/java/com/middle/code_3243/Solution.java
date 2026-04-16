package com.middle.code_3243;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2024/11/19
 * @Description
 */
public class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] dp = new int[n];
        int[] res = new int[queries.length];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = query[0];
            int y = query[1];
            dp[y] = Math.min(dp[y], dp[x] + 1);
            for (int j = y + 1; j < n - 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1] + 1);
            }
            System.out.println(Arrays.toString(dp));
            res[i] = dp[n - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
        int[] res = solution.shortestDistanceAfterQueries(n, queries);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
