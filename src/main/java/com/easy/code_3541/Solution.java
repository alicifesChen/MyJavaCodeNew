package com.easy.code_3541;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025-09-13
 * @Description
 */
public class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int aeiouMax = 0;
        int otherMax = 0;
        for (char c : map.keySet()) {
            if ("aeiou".indexOf(c) != -1) {
                aeiouMax = Math.max(aeiouMax, map.get(c));
            } else {
                otherMax = Math.max(otherMax, map.get(c));
            }
        }
        return aeiouMax + otherMax;
    }
}
