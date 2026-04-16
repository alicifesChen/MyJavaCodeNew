package com.easy.code_2176;

/**
 * @Author chenyuxiang
 * @Date 2025/4/17
 * @Description
 */
public class Solution {
    public int countPairs(int[] nums, int k) {
        int res = 0;
        int left = 0;
        while (left < nums.length) {
            for (int right = left + 1; right < nums.length; right ++) {
                if(nums[left] == nums[right] && (left + right) % k == 0) {
                    res++;
                }
            }
            left++;
        }
        return  res;
    }
}
