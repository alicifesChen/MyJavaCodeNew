package com.middle.code_3356;

/**
 * @Author chenyuxiang
 * @Date 2025/5/21
 * @Description
 */
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int q = queries.length;
        int left = -1, right = q + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(mid, nums, queries)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right <= q ? right : -1;
    }

    // 3355. 零数组变换 I
    private boolean check(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) { // 前 k 个询问
            int[] q = queries[i];
            int l = q[0], r = q[1], val = q[2];
            diff[l] += val;
            diff[r + 1] -= val;
        }

        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            if (nums[i] > sumD) {
                return false;
            }
        }
        return true;
    }
}
