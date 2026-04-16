package com.easy.code_3392;

/**
 * @Author chenyuxiang
 * @Date 2025/4/27
 * @Description
 */
public class Solution {
    public int countSubarrays(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 2; i ++) {
            if (isGood(nums[i], nums[i + 1], nums[i + 2])) {
                res++;
            }
        }
        return res;
    }

    public boolean isGood(int a,int b, int c) {
        return b == 2*(a + c);
    }
}
