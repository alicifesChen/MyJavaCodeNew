package com.easy.code_3065;

/**
 * @Author chenyuxiang
 * @Date 2025/1/14
 * @Description
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        for (int num: nums){
            if(num < k){
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,11,10,1,3};
        int k = 10;
        System.out.println(solution.minOperations(nums, k));
    }
}
