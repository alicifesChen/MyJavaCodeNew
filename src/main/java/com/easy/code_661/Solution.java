package com.easy.code_661;

/**
 * @Author chenyuxiang
 * @Date 2024/11/18
 * @Description
 */
public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = smooth(img, i, j);
            }
        }
        return res;
    }

    private int smooth(int[][] img, int i, int j) {
        int m = img.length;
        int n = img[0].length;
        int sum = 0;
        int count = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    sum += img[x][y];
                    count++;
                }
            }
        }
        return sum / count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] img = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] res = solution.imageSmoother(img);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
