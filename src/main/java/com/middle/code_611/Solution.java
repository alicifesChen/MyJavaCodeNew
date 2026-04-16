package com.middle.code_611;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025-09-26
 * @Description
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;

        //固定最长边
        //双指针寻找另外两条边
        //因为已经排序，所以如果两边之和大于第三边，那么中间的边和更大的边之和也一定大于第三边
        //坐标的指针都从0开始，右边从k-1开始向左移动
        for (int k = 2; k < n; k++) {
            int left = 0;
            int right = k - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 3, 4};
        int res = solution.triangleNumber(nums);
        System.out.println(res);
    }
}
