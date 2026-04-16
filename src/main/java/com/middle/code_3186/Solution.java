package com.middle.code_3186;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025-10-11
 * @Description
 */
public class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;

        // 统计每个伤害值的总和
        long[] values = new long[n];
        long[] sums = new long[n];
        int idx = 0;

        values[0] = power[0];
        sums[0] = power[0];

        for (int i = 1; i < n; i++) {
            if (power[i] == power[i - 1]) {
                sums[idx] += power[i];
            } else {
                idx++;
                values[idx] = power[i];
                sums[idx] = power[i];
            }
        }

        // 实际有效的唯一值个数
        int m = idx + 1;

        // DP数组
        long[] dp = new long[m];
        dp[0] = sums[0];

        for (int i = 1; i < m; i++) {
            // 找到第一个不冲突的位置(差值>2)
            int j = i - 1;
            while (j >= 0 && values[i] - values[j] <= 2) {
                j--;
            }

            if (j >= 0) {
                // 选当前值：dp[j] + sums[i]
                // 不选当前值：dp[i-1]
                dp[i] = Math.max(dp[i - 1], dp[j] + sums[i]);
            } else {
                // 前面所有值都冲突
                dp[i] = Math.max(dp[i - 1], sums[i]);
            }
        }

        return dp[m - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] power = {1,1,3,4};
        int[] power = {7,1,6,6};
        long res = solution.maximumTotalDamage(power);
        System.out.println(res);
    }
}
