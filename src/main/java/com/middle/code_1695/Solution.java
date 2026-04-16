package com.middle.code_1695;

import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025/7/22
 * @Description
 */
public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxSum = 0, currentSum = 0;
        while (right < nums.length) {
            if(map.containsKey(nums[right])) {
                // 如果当前数字已经存在于map中，移动左指针
                while (left <= right && map.containsKey(nums[right])) {
                    currentSum -= nums[left];
                    map.remove(nums[left]);
                    left++;
                }
            }else {
                // 如果当前数字不在map中，添加到map中
                map.put(nums[right], 1);
                currentSum += nums[right];
                maxSum = Math.max(maxSum, currentSum);
                right++;
            }
        }
        return maxSum;
    }
}
