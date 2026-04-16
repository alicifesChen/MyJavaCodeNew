package com.easy.code_2278;

/**
 * @Author chenyuxiang
 * @Date 2025/3/31
 * @Description
 */
public class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }
}
