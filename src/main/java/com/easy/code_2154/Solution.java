package com.easy.code_2154;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025-11-19
 * @Description
 */
public class Solution {
    public int findFinalValue(int[] nums, int original) {
        int result = original;
        Arrays.sort(nums);
        while (original <= nums[nums.length - 1] && Arrays.binarySearch(nums, original) >= 0) {
            original *= 2;
            result = original;
        }
        return result;
    }
}
