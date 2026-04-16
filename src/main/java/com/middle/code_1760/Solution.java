package com.middle.code_1760;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/2/12
 * @Description
 */
public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int maxOperations, int mid) {
        int count = 0;
        for (int num : nums) {
            //这里的 num - 1 =》
            count += (num - 1) / mid;
        }
        return count <= maxOperations;
    }
}
