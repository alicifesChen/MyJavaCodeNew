package com.middle.code_3623;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025-12-02
 * @Description
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> cnt = new HashMap<>(points.length, 1); // 预分配空间
        for (int[] p : points) {
            cnt.merge(p[1], 1, Integer::sum); // 统计每一行（水平线）有多少个点
        }

        long ans = 0, s = 0;
        for (int c : cnt.values()) {
            long k = (long) c * (c - 1) / 2;
            ans += s * k;
            s += k;
        }
        return (int) (ans % MOD);
    }
}

