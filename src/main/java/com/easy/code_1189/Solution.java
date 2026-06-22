package com.easy.code_1189;

import java.util.Arrays;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-06-22
 * @Description
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        List<Character> list = Arrays.asList('b', 'a', 'l', 'o', 'n' );
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (char c : list) {
            if (c == 'l' || c == 'o') {
                min = Math.min(min, count[c - 'a'] / 2);
            } else {
                min = Math.min(min, count[c - 'a']);
            }
        }
        return min;
    }
}
