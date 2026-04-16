package com.easy.code_3074;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025-12-24
 * @Description
 */
public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for (int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }
        int res = 0;
        for (int i = capacity.length - 1; i >= 0 && sum > 0; i--) {
            sum -= capacity[i];
            res++;
        }
        return res;
    }
}