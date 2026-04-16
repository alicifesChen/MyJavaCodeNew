package com.middle.code_3097;

/**
 * @Author chenyuxiang
 * @Date 2025/1/17
 * @Description
 */
public class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x >= k) {
                return 1;
            }
            for (int j = i - 1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                if (nums[j] >= k) {
                    ans = Math.min(ans, i - j + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
