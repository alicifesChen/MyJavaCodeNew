package com.middle.code_2708;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2024/9/4
 * @Description
 */
public class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[1] == 0 && nums[n - 1] == 0) {
            return 0;
        }
        long ans = 1;
        int i = 0;
        while (i < n) {
            if (nums[i] < 0 && i + 1 < n && nums[i + 1] < 0) {
                ans *= nums[i] * nums[i + 1];
                i += 2;
            } else if (nums[i] <= 0) {
                i += 1;
            } else {
                ans *= nums[i];
                i += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = {-1, -2, -3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums = {-4, -5, -4};
        long res = solution.maxStrength(nums);
        System.out.println(res);
    }
}
