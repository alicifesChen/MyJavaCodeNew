package com.easy.code_3131;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2024/8/8
 * @Description
 */
public class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        if (nums1.length != nums2.length) {
            return 0;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = nums2[0] - nums1[0];
        for (int i = 1; i < nums1.length; i++) {
            if (nums2[i] - nums1[i] != res) {
                return 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3, 4};
        int res = solution.addedInteger(nums1, nums2);
        System.out.println(res);
    }
}
