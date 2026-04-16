package com.easy.code_1920;

/**
 * @Author chenyuxiang
 * @Date 2025/5/6
 * @Description
 */
public class Solution {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i ++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
