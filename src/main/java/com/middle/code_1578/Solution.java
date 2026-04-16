package com.middle.code_1578;

/**
 * @Author chenyuxiang
 * @Date 2025-11-03
 * @Description
 */
public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int ans = 0;
        int maxT = 0;
        for (int i = 0; i < n; i++) {
            int t = neededTime[i];
            ans += t;
            maxT = Math.max(maxT, t);
            if (i == n - 1 || colors.charAt(i) != colors.charAt(i + 1)) {
                // 遍历到了连续同色段的末尾
                ans -= maxT; // 保留耗时最大的气球
                maxT = 0; // 准备计算下一段的最大耗时
            }
        }
        return ans;
    }
}
