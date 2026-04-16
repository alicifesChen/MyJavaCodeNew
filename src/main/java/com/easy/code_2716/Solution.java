package com.easy.code_2716;

import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025/3/28
 * @Description
 */
public class Solution {
    public int minimizedStringLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = s.substring(i, i + 1);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map.size();
    }
}
