package com.easy.code_236;

/**
 * @Author chenyuxiang
 * @Date 2025-08-13
 * @Description
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
}
