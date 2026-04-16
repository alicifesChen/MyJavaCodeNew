package com.easy.code_2843;

/**
 * @Author chenyuxiang
 * @Date 2025/4/11
 * @Description
 */
public class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSymmetric(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        if (len % 2 != 0) {
            return false;
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < len / 2; i++) {
            leftSum += str.charAt(i) - '0';
            rightSum += str.charAt(len - 1 - i) - '0';
        }
        return leftSum == rightSum;
    }
}
