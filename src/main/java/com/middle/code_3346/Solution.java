package com.middle.code_3346;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025-10-21
 * @Description
 */
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        numOperations = Math.min(n, numOperations);
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.merge(x, 1, Integer::sum);
        }

        int ans = 0;
        for (int i = nums[0]; i <= nums[n - 1]; i++) {
            int left = lower_bound(nums, i - k);
            int right = upper_bound(nums, i + k);
            int cnt = Math.min(right - left - map.getOrDefault(i, 0), numOperations);
            ans = Math.max(ans, cnt + map.getOrDefault(i, 0));
        }
        return ans;
    }

    private int upper_bound(int[] a, int x) {
        // 寻找第一个大于 x 的下标
        int left = 0, right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int lower_bound(int[] a, int x) {
        // 寻找第一个大于等于 x 的下标
        int left = 0, right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}