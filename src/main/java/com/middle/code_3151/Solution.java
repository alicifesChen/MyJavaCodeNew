package com.middle.code_3151;

/**
 * @Author chenyuxiang
 * @Date 2024/8/13
 * @Description
 */
public class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return true;
        }
        for(int i = 1; i < nums.length; i ++) {
            if((nums[i] + nums[i - 1]) %2 == 0) {
                return false;
            }
        }
        return true;
    }
}
