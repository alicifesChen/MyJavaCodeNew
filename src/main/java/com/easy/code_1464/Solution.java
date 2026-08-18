package com.easy.code_1464;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2026-07-27
 * @Description 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = nums[i] - 1;
        }
        Arrays.sort(p);
        return Math.max(p[n - 1] * p[n - 2], p[0] * p[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,4,5,2};
        System.out.println(solution.maxProduct(nums));
    }
}
