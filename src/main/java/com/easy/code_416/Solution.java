package com.easy.code_416;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/4/7
 * @Description
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果总和是奇数，不可能分成两部分
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        // dp[i] 表示是否能通过选择某些元素使得和为 i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 和为 0 是可能的，什么都不选
        //能不能找出元素的和为 target

        for (int num : nums) {
            // 从后往前遍历，避免重复使用同一个元素
            for (int i = target; i >= num; i--) {
                // 如果 dp[i - num] 为 true，说明可以通过选择当前元素 num 来达到和为 i
                // 因为 dp[i] 可能已经被更新过，所以需要用 || 来合并结果
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}
