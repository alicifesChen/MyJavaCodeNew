package com.easy.code_1399;

/**
 * @Author chenyuxiang
 * @Date 2025/4/23
 * @Description
 */
public class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            count[sum]++;
        }
        int maxCount = 0;
        for (int c : count) {
            maxCount = Math.max(maxCount, c);
        }
        int res = 0;
        for (int c : count) {
            if (c == maxCount) {
                res++;
            }
        }
        return res;
    }
}
