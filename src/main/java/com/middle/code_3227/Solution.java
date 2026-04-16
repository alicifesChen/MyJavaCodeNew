package com.middle.code_3227;

/**
 * @Author chenyuxiang
 * @Date 2025-09-12
 * @Description
 */
public class Solution {
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }
}
