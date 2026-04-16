package com.easy.code_1925;

/**
 * @Author chenyuxiang
 * @Date 2025-12-08
 * @Description
 */
public class Solution {
    public int countTriples(int n) {
        int res = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int cSquare = a * a + b * b;
                int c = (int) Math.sqrt(cSquare);
                if (c <= n && c * c == cSquare) {
                    if (a == b) {
                        res += 1;
                    } else {
                        res += 2;
                    }
                }
            }
        }
        return res;
    }
}
