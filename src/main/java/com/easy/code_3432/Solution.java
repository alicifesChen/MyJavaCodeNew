package com.easy.code_3432;

/**
 * @Author chenyuxiang
 * @Date 2025-12-05
 * @Description
 */
public class Solution {
    public int countPartitions(int[] nums) {
        int res = 0;
        int left = nums[0];
        int n = nums.length;
        int right = 0;
        for (int i = 1; i < n; i++) {
            right += nums[i];
        }
        for (int i  = 1; i < n ; i++) {
            System.out.println("left: " + left + ", right: " + right);
            System.out.println("left - right: " + (left - right));
            System.out.println("---------------------");
            if ((left - right) % 2  == 0) {
                res++;
            }
            left += nums[i];
            right -= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,4,6,8};
        int partitions = solution.countPartitions(nums);
        System.out.println(partitions);
    }
}
