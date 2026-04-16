package com.easy.code_3516;

/**
 * @Author chenyuxiang
 * @Date 2025-09-04
 * @Description
 */
public class Solution {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(x- z);
        int b = Math.abs(y - z);
        if(a < b) {
            return 1;
        }
        if(a > b) {
            return 2;
        }
        return 0;
    }
}
