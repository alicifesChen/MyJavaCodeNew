package com.easy.code_1582;

/**
 * @Author chenyuxiang
 * @Date 2026-03-04
 * @Description 给定一个 m x n 的二进制矩阵 mat，返回矩阵 mat 中特殊位置的数量。
 * 如果位置 (i, j) 满足 mat[i][j] == 1 并且行 i 与列 j 中的所有其他元素都是 0（行和列的下标从 0 开始计数），那么它被称为 特殊 位置。
 */
public class Solution {
    public int numSpecial(int[][] mat) {
        // 优化1: 使用更有意义的变量名
        int rows = mat.length;
        int cols = mat[0].length;
        int result = 0;

        // 优化2: 使用数组替代HashMap，空间复杂度不变但访问速度更快
        int[] rowCount = new int[rows];  // 记录每行1的个数
        int[] colCount = new int[cols];  // 记录每列1的个数

        // 第一次遍历：统计每行每列1的个数
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        // 第二次遍历：找出特殊位置
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 优化3: 添加空格使代码更易读
                if (mat[row][col] == 1 && rowCount[row] == 1 && colCount[col] == 1) {
                    result++;
                }
            }
        }

        return result;
    }
}
