package com.middle.code_3653;

/**
 * @Author chenyuxiang
 * @Date 2026-04-08
 * @Description
 */
public class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1000000007L;
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int step = queries[i][2];
            int val = queries[i][3];

            for (int j = start; j <= end; j += step) {
                nums[j] = (int) (((long) nums[j] * val) % MOD);
            }
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,5,4};
        int[][] queries = {{1,4,2,3},{0,2,1,2}};
        int result = solution.xorAfterQueries(nums, queries);
        System.out.println("Final XOR result: " + result);
    }
}
