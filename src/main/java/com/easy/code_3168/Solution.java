package com.easy.code_3168;

/**
 * @Author chenyuxiang
 * @Date 2025-11-12
 * @Description
 */
public class Solution {
    public int minimumChairs(String s) {
        int res = 0;
        int current = 0;
        for (char c : s.toCharArray()) {
            if(c == 'E') {
                current ++;
                res = Math.max(res, current);
            } else {
                current --;
            }
        }
        return res;
    }
}
