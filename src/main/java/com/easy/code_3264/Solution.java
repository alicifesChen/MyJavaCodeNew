package com.easy.code_3264;

/**
 * @Author chenyuxiang
 * @Date 2024/12/13
 * @Description
 */
public class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            nums[minIndex] *= multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int multiplier = 2;
        int[] res = solution.getFinalState(nums, k, multiplier);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
