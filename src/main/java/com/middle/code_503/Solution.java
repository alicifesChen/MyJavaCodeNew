package com.middle.code_503;

/**
 * @Author chenyuxiang
 * @Date 2024/6/24
 * @Description
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] numsDouble = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            numsDouble[i] = nums[i];
            numsDouble[i + nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < numsDouble.length; j++) {
                if (numsDouble[j] > nums[i]) {
                    nums[i] = numsDouble[j];
                    break;
                }
                if (nums[i] == max) {
                    nums[i] = -1;
                    break;
                }
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //   int[] result = solution.nextGreaterElements(new int[]{1, 2, 1});
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
        int[] result = solution.nextGreaterElements(new int[]{5, 4, 3, 2, 1});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
