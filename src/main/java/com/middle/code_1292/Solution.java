package com.middle.code_1292;

/**
 * @Author chenyuxiang
 * @Date 2026-01-19
 * @Description
 */
public class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int minSide = Math.min(m, n);

        int result = 0;

        for(int i = 0 ; i < minSide; i ++) {
            for (int j = 0 ; j < minSide ; j++) {
                //最大边长
                for(int k = 1 ; k + i <= m && k + j <= n; k ++) {
                    int sum = getSubmatrixSum(mat, i, j, i + k - 1, j + k - 1);
                    if (sum <= threshold) {
                        result = Math.max(result, k);
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    private int getSubmatrixSum(int[][] mat, int x1, int y1, int x2, int y2) {
        int sum = 0;
        for(int i = x1; i <= x2; i ++) {
            for(int j = y1; j <= y2; j ++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }
}
