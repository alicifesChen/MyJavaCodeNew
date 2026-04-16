package com.middle.code_2044;

/**
 * @Author chenyuxiang
 * @Date 2025-07-28
 * @Description
 */
public class Solution {
    private int mx;
    private int ans;
    private int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        for(int num : nums) {
            mx |= num; // 计算所有数字的按位或
        }
        this.nums = nums;
        dfs(0,0);
        return ans;
    }

    public void dfs(int i, int cur) {
        if(i == nums.length) {
            if(cur == mx) {
                ans++; // 如果当前按位或等于最大值，计数加一
            }
            return;
        }
        // 不选择当前数字
        dfs(i + 1, cur);
        // 选择当前数字
        dfs(i + 1, cur | nums[i]);
    }
}
