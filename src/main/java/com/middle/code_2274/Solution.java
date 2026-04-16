package com.middle.code_2274;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/1/6
 * @Description
 */
public class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = 0;
        if(bottom < special[0]) {
            res = special[0] - bottom;
        }
        for (int i = 0; i < special.length; i++) {
            if (special[i] <= bottom) {
                continue;
            }
            if (special[i] > top) {
                break;
            }
            res = Math.max(res, special[i] - bottom - 1);
            bottom = special[i];
        }
        return Math.max(res, top - bottom);
    }
}
