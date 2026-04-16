package com.middle.code_3132;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2024/8/9
 * @Description
 */
public class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        for (int i = 2; i > 0; i--) {
//            int left = i + 1;
//            int right = 1;
//            int diff = nums1[i] - nums2[0];
//            while (left < m && right < n) {
//                if (nums1[left] - nums2[right] == diff) {
//                    ++right;
//                }
//                ++left;  // 左指针必定移动
//            }
//            if (right == n) {
//                return nums2[0] - nums1[i];
//            }
//        }
//        return 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 枚举保留 nums1[2] 或者 nums1[1] 或者 nums1[0]
        // 倒着枚举是因为 nums1[i] 越大答案越小，第一个满足的就是答案
        for (int i = 2; i > 0; i--) {
            int x = nums2[0] - nums1[i];
            // 在 {nums1[i] + x} 中找子序列 nums2
            int j = 0;
            for (int k = i; k < nums1.length; k++) {
                if (nums2[j] == nums1[k] + x && ++j == nums2.length) {
                    // nums2 是 {nums1[i] + x} 的子序列
                    return x;
                }
            }
        }
        // 题目保证答案一定存在
        return nums2[0] - nums1[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3, 4};
        int res = solution.minimumAddedInteger(nums1, nums2);
        System.out.println(res);
    }
}
