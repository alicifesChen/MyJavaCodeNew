package com.middle.code_1561;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/1/22
 * @Description
 */
public class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int res = 0;
        int k = n / 3;
        Arrays.sort(piles);
        for (int i = n - 2; i >= k; i -= 2) {
            res += piles[i];
        }
        return res;
    }
}
