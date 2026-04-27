package com.middle.code_1391;

/**
 * @Author chenyuxiang
 * @Date 2026-04-27
 * @Description
 */
class Solution {
    private static final int[][][] DIRS = {
            {},
            {{0, -1}, {0, 1}},  // 站在街道 1，可以往左或者往右
            {{-1, 0}, {1, 0}},  // 站在街道 2，可以往上或者往下
            {{0, -1}, {1, 0}},  // 站在街道 3，可以往左或者往下
            {{0, 1}, {1, 0}},   // 站在街道 4，可以往右或者往下
            {{0, -1}, {-1, 0}}, // 站在街道 5，可以往左或者往上
            {{0, 1}, {-1, 0}},  // 站在街道 6，可以往右或者往上
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        return dfs(0, 0, grid, vis);
    }

    private boolean dfs(int x, int y, int[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[x].length;
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        vis[x][y] = true; // 标记 (x, y) 访问过，从而避免重复访问
        for (int[] d : DIRS[grid[x][y]]) { // 枚举下一步往哪走
            int i = x + d[0];
            int j = y + d[1];
            if (0 <= i && i < m && 0 <= j && j < n && !vis[i][j] &&
                    contains(grid[i][j], -d[0], -d[1]) && dfs(i, j, grid, vis)) {
                return true;
            }
        }
        return false;
    }

    // 判断街道 street 是否包含移动方向 (dx, dy)
    private boolean contains(int street, int dx, int dy) {
        int[][] ds = DIRS[street];
        return ds[0][0] == dx && ds[0][1] == dy ||
                ds[1][0] == dx && ds[1][1] == dy;
    }
}