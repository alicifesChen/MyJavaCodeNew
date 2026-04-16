package com.middle.code_2946;

/**
 * @Author chenyuxiang
 * @Date 2026-03-27
 * @Description 给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
 * 如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
 */
public class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length , m = mat[0].length;
        int kMod = k % m; // 取模，避免重复移动
        if(kMod == 0) return true; // 不需要移动
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int expected;
                if (i % 2 == 0) { // 偶数行左移
                    expected = mat[i][(j + kMod) % m];
                } else { // 奇数行右移
                    expected = mat[i][(j - kMod + m) % m];
                }
                if (expected != mat[i][j]) {
                    return false; // 不匹配，返回 false
                }
            }
        }
        return true; // 全部匹配，返回 true
    }
}
