package com.middle.code_3191;

/**
 * @Author chenyuxiang
 * @Date 2024/10/18
 * @Description
 */
public class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                if (i + 2 >= n) {
                    return -1;
                }
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ++ans;
            }
        }
        return ans;
    }
}
