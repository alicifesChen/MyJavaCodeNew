package com.middle.code_3583;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025-12-09
 * @Description
 */
public class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long count = 0;
        final int MOD = 1000000007;

        // 右侧哈希表：统计每个值在当前位置右边出现的次数
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 1; i < n; i++) {
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }

        // 左侧哈希表：统计每个值在当前位置左边出现的次数
        Map<Integer, Integer> leftMap = new HashMap<>();

        // 遍历每个位置作为 j
        for (int j = 0; j < n; j++) {
            // 将 nums[j] 从右侧移除
            if (j > 0) {
                rightMap.put(nums[j], rightMap.get(nums[j]) - 1);
                if (rightMap.get(nums[j]) == 0) {
                    rightMap.remove(nums[j]);
                }
            }

            int target = nums[j] * 2;
            long leftCount = leftMap.getOrDefault(target, 0);
            long rightCount = rightMap.getOrDefault(target, 0);

            count = (count + leftCount * rightCount % MOD) % MOD;

            // 将 nums[j] 加入左侧
            leftMap.put(nums[j], leftMap.getOrDefault(nums[j], 0) + 1);
        }
        return (int) count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8,4,2,8,4};
        int result = solution.specialTriplets(nums);
        System.out.println(result); // Expected output: 2
    }
}
