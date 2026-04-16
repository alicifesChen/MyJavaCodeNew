package com.easy.code_2717;

/**
 * @Author chenyuxiang
 * @Date 2024/12/11
 * @Description
 */
public class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 1){
                res++;
            } else {
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 1) continue;
            if(nums[i] != nums.length) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,4,2,5};
        System.out.println(solution.semiOrderedPermutation(nums));
    }
}
