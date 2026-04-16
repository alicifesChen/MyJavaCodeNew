package com.easy.code_3546;

/**
 * @Author chenyuxiang
 * @Date 2026-03-25
 * @Description
 */
public class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //前缀和
        int sum = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
        }
        return  check(grid, sum ) || check(rotate(grid), sum);
    }

    // 能否水平分割
    private boolean check(int[][] a, long total) {
        long s = 0;
        for (int i = 0; i < a.length - 1; i++) { // 最后一行无需遍历
            for (int x : a[i]) {
                s += x;
            }
            if (s * 2 == total) {
                return true;
            }
        }
        return false;
    }

//    private int[][] reverse(int[][] a) {
//        int m = a.length, n = a[0].length;
//        int[][] b = new int[n][m];
//        for (int i = 0; i < m; i++)
//            for (int j = 0; j < n; j++)
//                b[j][i] = a[i][j];
//        return b;
//    }
// 顺时针旋转矩阵 90°
private int[][] rotate(int[][] a) {
    int m = a.length, n = a[0].length;
    int[][] b = new int[n][m];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            b[j][m - 1 - i] = a[i][j];
        }
    }
    return b;
}

}
