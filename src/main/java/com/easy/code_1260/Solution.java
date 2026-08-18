package com.easy.code_1260;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-07-20
 * @Description 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j]（j < n - 1）的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        // 迁移 m*n 次等于回到原位，取模去掉冗余圈数
        k %= (m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当前元素在一维展平数组中的目标下标（循环右移 k 位）
                int index = (i * n + j + k) % (m * n);
                res[index / n][index % n] = grid[i][j];
            }
        }
        // 将 int[][] 转换为题目要求的 List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : res) {
            List<Integer> rowList = new ArrayList<>();
            for (int val : row) rowList.add(val);
            result.add(rowList);
        }
        return result;
    }
}
