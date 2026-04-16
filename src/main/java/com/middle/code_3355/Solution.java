package com.middle.code_3355;

/**
 * @Author chenyuxiang
 * @Date 2025/5/20
 * @Description
 */
public class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            // 区间 [l,r] 中的数都加一
            diff[q[0]]++;
            diff[q[1] + 1]--;
        }

        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            // 此时 sumD 表示 nums[i] 要减掉多少
            if (nums[i] > sumD) { // nums[i] 无法变成 0
                return false;
            }
        }
        return true;
    }
}
