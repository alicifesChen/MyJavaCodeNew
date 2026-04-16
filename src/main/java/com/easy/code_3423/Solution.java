package com.easy.code_3423;

/**
 * @Author chenyuxiang
 * @Date 2025/6/12
 * @Description
 */
public class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int res = 0;
        if (n < 2) {
            return res;
        }
        if (n == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
        }
        res = Math.max(res, Math.abs(nums[0] - nums[n - 1]));
        return res;
    }
}
