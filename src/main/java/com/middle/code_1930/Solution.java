package com.middle.code_1930;

import java.util.HashSet;

/**
 * @Author chenyuxiang
 * @Date 2025-11-21
 * @Description
 */
public class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        int count = 0;
        for (char c : uniqueChars) {
            int firstIndex = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if (lastIndex - firstIndex > 1) {
                HashSet<Character> middleChars = new HashSet<>();
                for (int i = firstIndex + 1; i < lastIndex; i++) {
                    middleChars.add(s.charAt(i));
                }
                count += middleChars.size();
            }
        }
        return count;
    }
}
