package com.easy.code_3903;

/**
 * @Author chenyuxiang
 * @Date 2026-09-04
 * @Description 给你一个长度为 n 的整数数组 nums 和一个整数 k。
 * 对于每个下标 i，定义它的 不稳定值 为 max(nums[0..i]) - min(nums[i..n - 1])。
 * 换句话说：
 * max(nums[0..i]) 表示从下标 0 到下标 i 的元素中的 最大值 。
 * min(nums[i..n - 1]) 表示从下标 i 到下标 n - 1 的元素中的 最小值 。
 * 如果某个下标 i 的不稳定值 小于等于 k，则称该下标为 稳定下标 。
 * 返回 最小 的稳定下标。如果不存在这样的下标，则返回 -1。
 * 示例 1：
 * 输入： nums = [5,0,1,4], k = 3  输出： 3
 * 解释：
 * 在下标 0 处：[5] 中的最大值是 5，[5, 0, 1, 4] 中的最小值是 0，因此不稳定值为 5 - 0 = 5。
 * 在下标 1 处：[5, 0] 中的最大值是 5，[0, 1, 4] 中的最小值是 0，因此不稳定值为 5 - 0 = 5。
 * 在下标 2 处：[5, 0, 1] 中的最大值是 5，[1, 4] 中的最小值是 1，因此不稳定值为 5 - 1 = 4。
 * 在下标 3 处：[5, 0, 1, 4] 中的最大值是 5，[4] 中的最小值是 4，因此不稳定值为 5 - 4 = 1。
 * 这是第一个不稳定值小于等于 k = 3 的下标，因此答案是 3。
 * 示例 2：
 * 输入： nums = [3,2,1], k = 1
 * 输出： -1
 * 解释：
 * 在下标 0 处，不稳定值为 3 - 1 = 2。
 * 在下标 1 处，不稳定值为 3 - 1 = 2。
 * 在下标 2 处，不稳定值为 3 - 1 = 2。
 * 这些值都不小于等于 k = 1，因此答案是 -1。
 * 示例 3：
 * 输入： nums = [0], k = 0
 * 输出： 0
 * 解释：
 * 在下标 0 处，不稳定值为 0 - 0 = 0，它小于等于 k = 0。因此答案是 0。
 */
public class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxPrefix = new int[n];
        int[] minSuffix = new int[n];

        // 计算前缀最大值
        maxPrefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        }

        // 计算后缀最小值
        minSuffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(minSuffix[i + 1], nums[i]);
        }

        // 查找第一个稳定下标
        for (int i = 0; i < n; i++) {
            int unstableValue = maxPrefix[i] - minSuffix[i];
            if (unstableValue <= k) {
                return i;
            }
        }

        return -1; // 如果没有找到稳定下标，返回 -1

    }
}
