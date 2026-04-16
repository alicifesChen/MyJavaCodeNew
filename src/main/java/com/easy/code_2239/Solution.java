package com.easy.code_2239;

/**
 * @Author chenyuxiang
 * @Date 2025/1/20
 * @Description
 */
public class Solution {
    public int findClosestNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i ++){
            if(nums[i] == 0){
                return 0;
            }
            if(Math.abs(nums[i]) == Math.abs(res) ) {
                res = Math.max(res, nums[i]);
            }
            if(Math.abs(nums[i]) < Math.abs(res)){
                res = nums[i];
            }
        }
        return res;
    }
}
