package com.easy.code_1935;

/**
 * @Author chenyuxiang
 * @Date 2025-09-15
 * @Description
 */
public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }
        int count = 0;
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (broken[c - 'a']) {
                    canType = false;
                    break;
                }
            }
            if (canType) {
                count++;
            }
        }
        return count;
    }
}
