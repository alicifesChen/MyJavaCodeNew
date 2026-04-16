package com.middle.code_2140;

/**
 * @Author chenyuxiang
 * @Date 2025/4/1
 * @Description
 */
public class Solution {
    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        return dfs(0, questions, memo);
    }

    private long dfs(int i, int[][] questions, long[] memo) {
        if (i >= memo.length) {
            return 0;
        }
        if (memo[i] > 0) { // 之前计算过
            return memo[i];
        }
        long notChoose = dfs(i + 1, questions, memo);
        long choose = dfs(i + questions[i][1] + 1, questions, memo) + questions[i][0];
        return memo[i] = Math.max(notChoose, choose); // 记忆化
    }
}
