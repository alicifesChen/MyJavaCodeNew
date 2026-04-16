package com.easy.code_3477;

/**
 * @Author chenyuxiang
 * @Date 2025-08-05
 * @Description
 */
public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] == 0) {
                continue;
            }
            boolean placed = false;
            for (int j = 0; j < baskets.length; j++) {
                if(baskets[j] >= fruits[i]) {
                    baskets[j] = 0;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                res += 1;
            }

        }
        return res;
    }
}

