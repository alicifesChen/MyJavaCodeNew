package com.middle.code_2958;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2026-08-12
 * @Description 给你一个整数数组 nums 和一个整数 k 。
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 * 请你返回 nums 中 最长好 子数组的长度。
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 * 示例 1：
 * 输入：nums = [1,2,3,1,2,3,1,2], k = 2
 * 输出：6
 * 解释：最长好子数组是 [1,2,3,1,2,3] ，值 1 ，2 和 3 在子数组中的频率都没有超过 k = 2 。[2,3,1,2,3,1] 和 [3,1,2,3,1,2] 也是好子数组。
 * 最长好子数组的长度为 6 。
 * 示例 2：
 * 输入：nums = [1,2,1,2,1,2,1,2], k = 1
 * 输出：2
 * 解释：最长好子数组是 [1,2] ，值 1 和 2 在子数组中的频率都没有超过 k = 1 。[2,1] 也是好子数组。
 * 最长好子数组的长度为 2 。
 * 示例 3：
 * 输入：nums = [5,5,5,5,5,5,5], k = 4
 * 输出：4
 * 解释：最长好子数组是 [5,5,5,5] ，值 5 在子数组中的频率没有超过 k = 4 。
 * 最长好子数组的长度为 4 。
 */
public class Solution {
    /**
     * 使用滑动窗口求最长好子数组
     * 核心思路：维护一个窗口，确保窗口内所有元素频率 <= k
     * 当右边界扩展导致某元素超频时，收缩左边界直到满足条件
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;   // 窗口左边界
        int right = 0;  // 窗口右边界
        int maxLen = 0; // 记录最长好子数组的长度
        int n = nums.length;
        // 使用 HashMap 代替固定大小数组，可以处理任意范围的数字
        Map<Integer, Integer> freq = new HashMap<>();

        while (right < n) {
            // 扩展窗口：将右边界元素加入窗口
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // 收缩窗口：如果当前元素频率超过 k，移除左边界元素直到满足条件
            // 关键点：只需检查刚加入的元素是否超频，因为之前窗口是合法的
            while (freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                // 如果频率降为 0，从 map 中移除以节省空间
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            // 更新最大长度（此时窗口一定是合法的）
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    /**
     * 带详细演示输出的版本，展示算法执行的每一步
     */
    public int maxSubarrayLengthWithDemo(int[] nums, int k) {
        System.out.println("\n========== 算法演示开始 ==========");
        System.out.println("输入数组: " + java.util.Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("===================================\n");

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        while (right < n) {
            // 扩展窗口
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            System.out.printf("步骤 %d: 加入 nums[%d] = %d\n", right + 1, right, nums[right]);
            System.out.println("  当前频率: " + freq);

            // 收缩窗口
            if (freq.get(nums[right]) > k) {
                System.out.println("  ⚠️ 频率超过 k! nums[" + right + "] = " + nums[right] + " 出现了 " + freq.get(nums[right]) + " 次");
                System.out.print("  开始收缩窗口: ");

                while (freq.get(nums[right]) > k) {
                    System.out.print("移除 nums[" + left + "]=" + nums[left] + " ");
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                    if (freq.get(nums[left]) == 0) {
                        freq.remove(nums[left]);
                    }
                    left++;
                }
                System.out.println();
                System.out.println("  收缩后频率: " + freq);
            }

            // 当前窗口
            int currentLen = right - left + 1;
            System.out.print("  窗口 [" + left + ", " + right + "]: [");
            for (int i = left; i <= right; i++) {
                System.out.print(nums[i]);
                if (i < right) System.out.print(", ");
            }
            System.out.println("], 长度 = " + currentLen);

            // 更新最大长度
            if (currentLen > maxLen) {
                maxLen = currentLen;
                System.out.println("  ✓ 更新最大长度: " + maxLen);
            }

            System.out.println();
            right++;
        }

        System.out.println("========== 算法演示结束 ==========");
        System.out.println("最终结果: " + maxLen);
        System.out.println("===================================\n");
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ========== 演示模式 ==========
        System.out.println("【演示 1】基本示例 - 窗口滑动过程");
        int[] demo1 = {1, 2, 3, 1, 2, 3, 1, 2};
        solution.maxSubarrayLengthWithDemo(demo1, 2);

        System.out.println("\n【演示 2】严格限制 k=1");
        int[] demo2 = {1, 2, 1, 2, 1};
        solution.maxSubarrayLengthWithDemo(demo2, 1);

        System.out.println("\n【演示 3】包含大数字");
        int[] demo3 = {1000000000, 1000000000, 999999999, 1000000000};
        solution.maxSubarrayLengthWithDemo(demo3, 2);

        // ========== 批量测试 ==========
        System.out.println("\n\n========== 批量测试结果 ==========");

        int[] nums1 = {1, 2, 3, 1, 2, 3, 1, 2};
        System.out.println("示例 1: " + solution.maxSubarrayLength(nums1, 2)); // 输出: 6

        int[] nums2 = {1, 2, 1, 2, 1, 2, 1, 2};
        System.out.println("示例 2: " + solution.maxSubarrayLength(nums2, 1)); // 输出: 2

        int[] nums3 = {5, 5, 5, 5, 5, 5, 5};
        System.out.println("示例 3: " + solution.maxSubarrayLength(nums3, 4)); // 输出: 4

        int[] nums4 = {1000000000, 1000000000, 999999999, 1000000000};
        System.out.println("示例 4（大数字）: " + solution.maxSubarrayLength(nums4, 2)); // 输出: 3

        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("示例 5（无重复）: " + solution.maxSubarrayLength(nums5, 1)); // 输出: 5

        int[] nums6 = {1, 1, 1, 1, 1};
        System.out.println("示例 6（k > 频率）: " + solution.maxSubarrayLength(nums6, 10)); // 输出: 5
    }
}
