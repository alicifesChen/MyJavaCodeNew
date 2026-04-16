package com.easy.code_27;

/**
 * @Author chenyuxiang
 * @Date 2024/6/14
 * @Description
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[end] = nums[i];
                end++;
            }
        }
        return end;
    }
}
