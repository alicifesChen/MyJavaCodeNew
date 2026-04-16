package com.easy.code_2595;

/**
 * @Author chenyuxiang
 * @Date 2025/2/20
 * @Description
 */
public class Solution {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        for (int i = 0; n > 0; n >>= 1) {
            ans[i] += n & 1;
            i ^= 1; // 切换奇偶
        }
        return ans;
    }
}
