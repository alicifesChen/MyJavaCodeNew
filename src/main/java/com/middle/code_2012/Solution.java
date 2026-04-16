package com.middle.code_2012;

/**
 * @Author chenyuxiang
 * @Date 2025/3/11
 * @Description
 */
public class Solution {
    public int sumOfBeauties(int[] nums) {
//    在 nums[i] 左边的所有元素都比它小，在 nums[i] 右边的所有元素都比它大，这种情况下 nums[i] “美丽值” 就是 2。
//     nums[i] 比它左边相邻的元素大，比它右边相邻的元素小，但不满足左边所有元素都比它小且右边所有元素都比它大的情况，此时 nums[i] 的 “美丽值” 是 1。
//      上述两个条件都不满足，那么 nums[i] 的 “美丽值” 为 0。
//      然后计算 美丽值的总和
        int n = nums.length;
        int res = 0;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = nums[0];
        rightMin[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMax[i - 1] && nums[i] < rightMin[i + 1]) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }
        return res;
    }
}
