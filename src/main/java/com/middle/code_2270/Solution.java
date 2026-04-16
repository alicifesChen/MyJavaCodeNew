package com.middle.code_2270;

/**
 * @Author chenyuxiang
 * @Date 2025/1/13
 * @Description
 */
public class Solution {
    public int waysToSplitArray(int[] nums) {
        int res = 0;
        int n = nums.length;
        int leftSum = nums[0];
        int rightSum = 0;
        for (int i = 1; i < n; i++) {
            rightSum += nums[i];
        }
        for(int i = 1; i <= n -1; i++){
            if (leftSum >= rightSum) {
                res ++;
            }
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return res;
    }
}
