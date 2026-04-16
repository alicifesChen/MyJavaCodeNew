package com.easy.code_283;

/**
 * @Author chenyuxiang
 * @Date 2024/6/17
 * @Description
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                if(fast != slow){
                    nums[fast] = 0;
                }
                slow++;
            }
        }
    }
}
