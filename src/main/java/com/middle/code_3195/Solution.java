package com.middle.code_3195;

/**
 * @Author chenyuxiang
 * @Date 2025-08-22
 * @Description
 */
public class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int left = n, right = 0, top = m, bottom = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    left = Math.min(left, i);
                    right = Math.max(right, i);
                    top = Math.min(top, j);
                    bottom = Math.max(bottom, j);
                }
            }
        }
        return Math.abs(right - left + 1) * Math.abs(bottom - top + 1);
    }
}
