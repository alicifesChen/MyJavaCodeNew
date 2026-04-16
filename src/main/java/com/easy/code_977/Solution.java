package com.easy.code_977;

/**
 * @Author chenyuxiang
 * @Date 2024/6/14
 * @Description
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                res[right - left] = nums[left] * nums[left];
                left++;
            } else {
                res[right - left] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
