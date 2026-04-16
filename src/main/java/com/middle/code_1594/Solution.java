package com.middle.code_1594;

/**
 * @Author chenyuxiang
 * @Date 2026-03-23
 * @Description 给你一个大小为 m x n 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
 * 在从左上角 (0, 0) 开始到右下角 (m - 1, n - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
 * 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为 负数 ，则返回 -1 。
 * 注意，取余是在得到最大积之后执行的。
 */
public class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long MOD = 1000000007L;
        long[][] dpMax = new long[n][m];
        long[][] dpMin = new long[n][m];

        dpMax[0][0] = dpMin[0][0] = grid[0][0];

        for (int i = 1; i < n; i++)
            dpMax[i][0] = dpMin[i][0] = dpMax[i-1][0] * grid[i][0];
        for (int j = 1; j < m; j++)
            dpMax[0][j] = dpMin[0][j] = dpMax[0][j-1] * grid[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long v = grid[i][j];
                long a = dpMax[i-1][j] * v, b = dpMin[i-1][j] * v;
                long c = dpMax[i][j-1] * v, d = dpMin[i][j-1] * v;
                dpMax[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                dpMin[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        if (dpMax[n-1][m-1] < 0) return -1;
        return (int)(dpMax[n-1][m-1] % MOD);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid ={{1,-2,1},{1,-2,1},{3,-4,1}};
        System.out.println(solution.maxProductPath(grid));
    }
}
