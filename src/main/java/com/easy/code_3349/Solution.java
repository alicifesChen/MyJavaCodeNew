package com.easy.code_3349;

import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-10-14
 * @Description
 */
public class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int left = 0;
        while (left + k * 2 -1 < nums.size()) {
            if (isIncreasing(nums, left, left + k - 1) && isIncreasing(nums, left + k, left + k * 2 - 1)) {
                return true;
            }
            left++;
        }
        return false;
    }

    private boolean isIncreasing(List<Integer> nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
