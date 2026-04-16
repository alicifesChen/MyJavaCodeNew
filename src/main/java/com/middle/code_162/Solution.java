package com.middle.code_162;

/**
 * @Author chenyuxiang
 * @Date 2025/2/11
 * @Description
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (n == 1) {
                return 0;
            }
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
                continue;
            }
            if (i == n - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
                continue;
            }
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
