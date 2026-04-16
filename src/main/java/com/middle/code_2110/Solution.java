package com.middle.code_2110;

import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-12-15
 * @Description
 */
public class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 0;
        int i = 0;
        while (i < prices.length) {
            int count = 1;
            while (i + count < prices.length && prices[i + count] == prices[i + count - 1] - 1) {
                count++;
            }
            result += (long) count * (count + 1) / 2;
            i += count;
        }
        return result;
    }
}
