package com.easy.code_2614;

/**
 * @Author chenyuxiang
 * @Date 2025/3/18
 * @Description
 */
public class Solution {
    public int diagonalPrime(int[][] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                res = Math.max(res, nums[i][i]);
            }
            if (isPrime(nums[i][n - i - 1])) {
                res = Math.max(res, nums[i][n - i - 1]);
            }
        }
        return res;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
