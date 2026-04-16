package com.easy.code_3184;

/**
 * @Author chenyuxiang
 * @Date 2024/10/22
 * @Description
 */
public class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int res = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
