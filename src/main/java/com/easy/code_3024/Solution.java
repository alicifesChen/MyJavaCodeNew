package com.easy.code_3024;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/5/19
 * @Description
 */
public class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if(nums[0] == nums[2]) {
            return "equilateral";
        }
        if(nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        }
        return "scalene";

    }
}


//class Solution {
//    public String triangleType(int[] nums) {
//        Arrays.sort(nums);
//        int a = nums[0];
//        int b = nums[1];
//        int c = nums[2];
//        if (a + b <= c) {
//            return "none";
//        }
//        if (a == c) {
//            return "equilateral";
//        }
//        if (a == b || b == c) {
//            return "isosceles";
//        }
//        return "scalene";
//    }
//}