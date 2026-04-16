package com.middle.code_3070;

/**
 * @Author chenyuxiang
 * @Date 2026-03-18
 * @Description 给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。
 * 返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵的数目。
 */
public class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        // prefix[i][j] 表示从 (0,0) 到 (i,j) 的子矩阵元素和
        int[][] prefix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = grid[i][j];
                if (i > 0) prefix[i][j] += prefix[i - 1][j];
                if (j > 0) prefix[i][j] += prefix[i][j - 1];
                if (i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1];
                if (prefix[i][j] <= k) res++;
            }
        }
        return res;
    }
}
