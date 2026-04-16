package com.middle.code_2966;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/6/18
 * @Description
 */
public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = n / 3;
        int[][] result = new int[count][3];
        int index = 0;
        for (int i = 0; i < n; i += 3) {
            result[index] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            index++;
            if(nums[i + 2] - nums[i] > k) {
                return new int[0][];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        int[][] result = solution.divideArray(nums, k);
        if (result.length == 0) {
            System.out.println("No valid division found.");
        } else {
            System.out.println("Valid division found: " + Arrays.deepToString(result));
        }
    }
}
