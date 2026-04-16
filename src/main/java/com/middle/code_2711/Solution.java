package com.middle.code_2711;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author chenyuxiang
 * @Date 2025/3/25
 * @Description
 */
public class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Set<Integer> topLeft = new HashSet<>();
                Set<Integer> bottomRight = new HashSet<>();
                int x = i - 1;
                int y = j - 1;
                while (x >= 0 && y >= 0) {
                    topLeft.add(grid[x][y]);
                    x--;
                    y--;
                }
                x = i + 1;
                y = j + 1;
                while (x < n && y < m) {
                    bottomRight.add(grid[x][y]);
                    x++;
                    y++;
                }
                res[i][j] = Math.abs(bottomRight.size() - topLeft.size());
            }
        }
        return res;
    }
}
