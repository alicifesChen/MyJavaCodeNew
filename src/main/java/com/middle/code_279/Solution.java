package com.middle.code_279;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/12/31
 * @Description
 */
public class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                if (i - list.get(j) >= 0) {
                    min = Math.min(min, dp[i - list.get(j)]);
                }
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
