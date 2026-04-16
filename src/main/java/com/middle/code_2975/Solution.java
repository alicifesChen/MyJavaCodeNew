package com.middle.code_2975;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author chenyuxiang
 * @Date 2026-01-16
 * @Description
 */
public class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1_000_000_007;
        Set<Integer> hSet = f(hFences, m);
        Set<Integer> vSet = f(vFences, n);
        // 计算两个集合的交集的最大值
        int ans = 0;
        for (int h : hSet) {
            if (vSet.contains(h)) {
                ans = Math.max(ans, h);
            }
        }
        return ans > 0 ? (int) ((long) ans * ans % MOD) : -1;
    }

    private Set<Integer> f(int[] a, int mx) {
        int n = a.length;
        a = Arrays.copyOf(a, n + 2);
        a[n++] = 1;
        a[n++] = mx;
        Arrays.sort(a);

        // 计算 a 中任意两个数的差，保存到哈希集合中
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(a[j] - a[i]);
            }
        }
        return set;
    }
}

