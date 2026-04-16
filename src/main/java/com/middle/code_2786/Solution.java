package com.middle.code_2786;

/**
 * @Author chenyuxiang
 * @Date 2024/6/14
 * @Description
 */
public class Solution {
    public long maxScore(int[] nums, int x) {
        int num = nums[0];
        long[] dp = new long[]{num, num};
        dp[num & 1 ^ 1] -= x;

        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            num = nums[i];
            //分别取奇数位和偶数位
            dp[num & 1] = num + Math.max(dp[num & 1], dp[num & 1 ^ 1] - x);
        }

        return Math.max(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 6, 1, 9, 2};
        int x = 5;
        System.out.println(solution.maxScore(nums, x)); //13
    }
}
