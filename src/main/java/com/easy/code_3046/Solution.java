package com.easy.code_3046;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2024/12/30
 * @Description
 */
public class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            if (count == 3) {
                return false;
            }
            countMap.put(num, count);
        }
        return true;
    }
}
