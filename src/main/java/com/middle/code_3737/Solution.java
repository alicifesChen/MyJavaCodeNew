package com.middle.code_3737;

/**
 * @Author chenyuxiang
 * @Date 2026-06-25
 * @Description
 */
public class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    count++;
                }
                if (count * 2 > (j - i + 1)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2,3};
        int target = 2;
        int result = solution.countMajoritySubarrays(nums, target);
        System.out.println("Number of majority subarrays: " + result);
    }
}
