package com.easy.code_3507;

/**
 * @Author chenyuxiang
 * @Date 2026-01-22
 * @Description 给你一个数组 nums，你可以执行以下操作任意次数：
 * 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
 * 用它们的和替换这对元素。
 * 返回将数组变为 非递减 所需的 最小操作次数 。
 * 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
 */
public class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;
        while (!isNonDecreasing(nums)) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = i;
                }
            }
            // Create a new array with the pair replaced by their sum
            int[] newNums = new int[nums.length - 1];
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (i == minIndex) {
                    newNums[j++] = minSum;
                    i++; // Skip the next element as it's part of the pair
                } else {
                    newNums[j++] = nums[i];
                }
            }
            nums = newNums;
            operations++;
        }
        return operations;
    }

    private boolean isNonDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
