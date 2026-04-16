package com.easy.code_3005;

import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025-09-22
 * @Description
 */
public class Solution {
    public int maxFrequencyElements(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                res+=freq;
            }
        }
        return res;
    }
}
