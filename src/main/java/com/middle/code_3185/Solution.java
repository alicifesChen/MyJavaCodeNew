package com.middle.code_3185;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2024/10/23
 * @Description
 */
public class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[] preSum = new int[24];
        long res = 0;
        for (int hour : hours) {
            res += preSum[(24 - hour % 24) % 24];
            if (hour % 24 == 0) {
                preSum[0]++;
            } else {
                preSum[hour % 24]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] hours = {12,12,30,24,24};
        System.out.println(solution.countCompleteDayPairs(hours));
    }
}
