package com.easy.code_2255;

/**
 * @Author chenyuxiang
 * @Date 2025/3/24
 * @Description
 */
public class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        if (s.isEmpty()) {
            return res;
        }
        for (String word : words) {
            if (s.startsWith(word)) {
                res++;
            }
        }
        return res;
    }
}
