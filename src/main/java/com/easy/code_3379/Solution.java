package com.easy.code_3379;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2026-02-05
 * @Description
 */
public class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i ++) {
            int moveStep =Math.abs( nums[i] % nums.length);
            if(nums[i] < 0) {
                //左移动
                int moveEnd = i - moveStep;
                if (moveEnd < 0){
                    moveEnd += nums.length;
                }
                res[i] = nums[moveEnd];
            } else {
                //右移动
                int moveEnd = i + moveStep;
                if (moveEnd >= nums.length){
                    moveEnd -= nums.length;
                }
                res[i] = nums[moveEnd];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.constructTransformedArray(new int[]{3,-2,1,1});
        System.out.println(Arrays.toString(res));
    }
}
