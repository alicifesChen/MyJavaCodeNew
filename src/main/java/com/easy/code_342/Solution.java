package com.easy.code_342;

/**
 * @Author chenyuxiang
 * @Date 2025-08-15
 * @Description
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return n == 1;
    }
}
