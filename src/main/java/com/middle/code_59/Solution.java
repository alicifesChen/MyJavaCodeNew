package com.middle.code_59;

/**
 * @Author chenyuxiang
 * @Date 2025/2/7
 * @Description
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = num++;
            }
            for (int i = right - 1; i >= left; i--) {
                res[bottom][i] = num++;
            }
            for (int i = bottom - 1; i > top; i--) {
                res[i][left] = num++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] res = solution.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
