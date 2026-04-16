package com.easy.code_3637;

/**
 * @Author chenyuxiang
 * @Date 2026-02-03
 * @Description
 */
public class Solution {
    public boolean isTrionic(int[] nums) {
        if (nums[0] >= nums[1]) { // 一开始必须是递增的
            return false;
        }
        int cnt = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            if ((nums[i - 2] < nums[i - 1]) != (nums[i - 1] < nums[i])) {
                cnt++;
            }
        }
        return cnt == 3; // 一定是增减增
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Boolean res =  solution.isTrionic(new int[]{6,7,5,1});
        System.out.println(res);
    }
}
