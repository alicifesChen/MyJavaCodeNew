package com.middle.code_2348;

/**
 * @Author chenyuxiang
 * @Date 2025-08-19
 * @Description
 */
public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res += i - last;
            } else {
                last = i;
            }
        }
        return res;
    }
}
