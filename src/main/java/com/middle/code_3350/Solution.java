package com.middle.code_3350;

import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-10-15
 * @Description
 */
public class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0, pre = 0, cur = 0;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            ++cur;
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                ans = Math.max(ans, Math.max(cur / 2, Math.min(pre, cur)));
                pre = cur;
                cur = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = List.of(2,5,7,8,9,2,3,4,3,1);
        int res = solution.maxIncreasingSubarrays(nums);
        System.out.println(res);
    }
}

