package com.middle.code_1014;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/9/23
 * @Description
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int mx = values[0]; // j 左边的 values[i] + i 的最大值
        for (int j = 1; j < values.length; j++) {
            ans = Math.max(ans, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }
}
