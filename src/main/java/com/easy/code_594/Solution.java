package com.easy.code_594;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025/6/30
 * @Description
 */
public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maxLength = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            if (countMap.containsKey(num + 1)) {
                int length = entry.getValue() + countMap.get(num + 1);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
