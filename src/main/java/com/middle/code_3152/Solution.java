package com.middle.code_3152;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2024/8/14
 * @Description
 */
public class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i -1];
            if ((nums[i] + nums[i - 1]) % 2 == 0) {
                prefix[i]++;
            }
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // 如果区间内有一对相邻元素的和为偶数，结果为false
            res[i] = (prefix[right] - prefix[left]) == 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int[][] queries = {{0, 2}, {1, 3}, {2, 4}};
        boolean[] res = solution.isArraySpecial(nums, queries);
        for (boolean re : res) {
            System.out.println(re);
        }
    }
}
