package com.middle.code_2364;

import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025/4/18
 * @Description
 */
public class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        for (int value : map.values()) {
            res += (long) value * (value - 1) / 2;
        }
        return (long) nums.length * (nums.length - 1) / 2 - res;
    }
}
