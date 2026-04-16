package com.easy.code_1437;

/**
 * @Author chenyuxiang
 * @Date 2025-11-17
 * @Description
 */
public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastPos != -1 && i - lastPos - 1 < k) {
                    return false;
                }
                lastPos = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,0,0,1,0,1};
        int k = 2;
        System.out.println(solution.kLengthApart(nums, k));
    }
}
