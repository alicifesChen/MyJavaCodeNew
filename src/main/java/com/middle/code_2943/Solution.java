package com.middle.code_2943;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2026-01-15
 * @Description
 */
public class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hmax = 1, vmax = 1;
        int hcur = 1, vcur = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                hcur++;
            } else {
                hcur = 1;
            }
            hmax = Math.max(hmax, hcur);
        }
        hmax = Math.max(hmax, hcur);
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                vcur++;
            } else {
                vcur = 1;
            }
            vmax = Math.max(vmax, vcur);
        }
        int side = Math.min(vmax, hmax) + 1;
        return side * side;
    }
}
