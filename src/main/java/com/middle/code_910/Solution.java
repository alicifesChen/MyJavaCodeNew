package com.middle.code_910;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2024/10/21
 * @Description
 */
public class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1) return 0;
        int ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n; i++){
            int max = Math.max(nums[i] + k, nums[nums.length - 1] - k);
            int min = Math.min(nums[i + 1] - k, nums[0] + k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
