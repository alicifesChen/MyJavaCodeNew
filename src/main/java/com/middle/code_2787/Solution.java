package com.middle.code_2787;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-08-12
 * @Description
 */
public class Solution {
    public int numberOfWays(int n, int x) {
//        long[] dp = new long[n + 1];
//        dp[0] = 1L;
//        for (int i = 1, num = (int)Math.pow(i, x); num <= n; ++i, num = (int)Math.pow(i, x)) {
//            for (int j = n; j >= num; --j) {
//                dp[j] += dp[j - num];
//            }
//        }
//        return (int)(dp[n] % 1000000007);
        final int MOD = 1_000_000_007;

        // dp[target] = 组成 target 的组合数
        long[] dp = new long[n + 1];
        dp[0] = 1; // 组成 0 只有 1 种方式：不选任何数

        // 先生成所有可能的 i^x（不超过 n）
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; ; i++) {
            int power = (int) Math.pow(i, x);
            if (power > n) break;
            powers.add(power);
        }

        // 对每一个可用的 i^x，更新组合数
        for (int power : powers) {
            for (int target = n; target >= power; target--) {
                dp[target] = (dp[target] + dp[target - power]) % MOD;
            }
        }

        return (int) dp[n];
    }
}
