package com.middle.code_31;

/**
 * @Author chenyuxiang
 * @Date 2024/12/17
 * @Description
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                for(int j = nums.length - 1; j >= i; j--) {
                    if(nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                for(int j = i; j < (nums.length + i) / 2; j++) {
                    int temp = nums[j];
                    nums[j] = nums[nums.length - 1 - j + i];
                    nums[nums.length - 1 - j + i] = temp;
                }
                return;
            }
        }
        for(int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}
