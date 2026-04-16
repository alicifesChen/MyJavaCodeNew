package com.middle.code_2419;

/**
 * @Author chenyuxiang
 * @Date 2025-07-30
 * @Description
 */
public class Solution {
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num); // 找到数组中的最大值
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == max && nums[i - 1] == max) {
                int j = i;
                while (j < nums.length && nums[j] == max) {
                    j++;
                }
                res = Math.max(res, j - i + 1); // 更新最长子数组长度
                i = j - 1; // 跳过已处理的部分
            }
        }
        return res == 0 ? 1 : res; // 如果没有找到连续的最大值，返回1
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 3, 2, 2};
        int result = solution.longestSubarray(nums);
        System.out.println("最长子数组长度: " + result); // 输出最长子数组长度
    }

}
