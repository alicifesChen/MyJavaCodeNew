package com.easy.code_2784;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2026-05-14
 * @Description 给你一个整数数组 nums ，如果它是数组 base[n] 的一个排列，我们称它是个 好 数组。
 * base[n] = [1, 2, ..., n - 1, n, n] （换句话说
 * ，它是一个长度为 n + 1 且包含 1 到 n - 1 恰好各一次，包含 n  两次的一个数组）。比方说，base[1] = [1, 1] ，base[3] = [1, 2, 3, 3] 。
 * 如果数组是一个好数组，请你返回 true ，否则返回 false 。
 * 注意：数组的排列是这些数字按任意顺序排布后重新得到的数组。
 * 示例 1：
 * 输入：nums = [2, 1, 3]
 * 输出：false
 * 解释：因为数组的最大元素是 3 ，唯一可以构成这个数组的 base[n] 对应的 n = 3
 * 。但是 base[3] 有 4 个元素，但数组 nums 只有 3 个元素，所以无法得到
 * base[3] = [1, 2, 3, 3] 的排列，所以答案为 false 。
 * 示例 2：
 * 输入：nums = [1, 3, 3, 2]
 * 输出：true
 * 解释：因为数组的最大元素是 3 ，唯一可以构成这个数组的 base[n] 对应的 n = 3 ，
 * 可以看出数组是 base[3] = [1, 2, 3, 3] 的一个排列（交换 nums 中第二个和第四个元素）。所以答案为 true 。
 * 示例 3：
 * 输入：nums = [1, 1]
 * 输出：true
 * 解释：因为数组的最大元素是 1 ，唯一可以构成这个数组的 base[n] 对应的 n = 1，可以看出数组是 base[1] = [1, 1] 的一个排列。所以答案为 true 。
 */
public class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i <= n - 2; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        return nums[n-1] == n - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 3, 2};
        System.out.println(solution.isGood(nums));
    }
}
