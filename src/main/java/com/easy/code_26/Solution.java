package com.easy.code_26;

/**
 * @Author chenyuxiang
 * @Date 2024/6/14
 * @Description
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[end]){
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
}
