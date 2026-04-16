package com.middle.code_2906;

/**
 * @Author chenyuxiang
 * @Date 2026-03-24
 * @Description 给你一个下标从 0 开始、大小为 n * m 的二维整数矩阵 grid ，定义一个下标从 0 开始、大小为 n * m 的的二维矩阵 p。如果满足以下条件，则称 p 为 grid 的 乘积矩阵 ：
 * 对于每个元素 p[i][j] ，它的值等于除了 grid[i][j] 外所有元素的乘积。乘积对 12345 取余数。
 * 返回 grid 的乘积矩阵。
 */
public class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        int[] flat = new int[total];
        // 展平
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                flat[i * n + j] = grid[i][j];

        // 前缀积
        long[] prefix = new long[total];
        prefix[0] = 1;
        for (int i = 1; i < total; i++)
            prefix[i] = prefix[i - 1] * flat[i - 1] % 12345;

        // 后缀积
        long[] suffix = new long[total];
        suffix[total - 1] = 1;
        for (int i = total - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * flat[i + 1] % 12345;

        // 构造结果
        int[][] p = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                p[i][j] = (int) (prefix[idx] * suffix[idx] % 12345);
            }
        return p;
    }
}
