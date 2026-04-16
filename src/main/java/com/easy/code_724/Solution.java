package com.easy.code_724;

/**
 * @Author chenyuxiang
 * @Date 2024/7/8
 * @Description
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sumLeft = 0;
        for(int i = 0; i < nums.length; i++){
            if(sumLeft == sum - sumLeft - nums[i]){
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(solution.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
    }
}
