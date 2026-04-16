package com.easy.code_2894;

/**
 * @Author chenyuxiang
 * @Date 2025/5/27
 * @Description
 */
public class Solution {
    public int differenceOfSums(int n, int m) {
        int sumM = 0;
        for (int i = m; i <=n ; i += m) {
            sumM += i;
        }
        int sumN = (n + 1 )* n / 2;
        return sumN - sumM * 2;
    }
}
