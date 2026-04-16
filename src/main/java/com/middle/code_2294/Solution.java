package com.middle.code_2294;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/6/19
 * @Description
 */
public class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] - nums[left] > k) {
                count++;
                left = i;
            }
        }
        return count + 1; // 最后一个分区
    }
}

