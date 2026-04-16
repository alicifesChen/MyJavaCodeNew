package com.easy.code_3194;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2024/10/16
 * @Description
 */
public class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double res = Double.MAX_VALUE;  // 使用 Double.MAX_VALUE 而不是 Integer.MAX_VALUE
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            double avgData = (nums[left] + nums[right]) / 2.0;  // 确保进行浮点数除法
            res = Math.min(res, avgData);
            left++;
            right--;
        }

        return res;
    }
}
