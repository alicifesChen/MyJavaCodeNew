package com.easy.code_3142;

/**
 * @Author chenyuxiang
 * @Date 2024/8/29
 * @Description
 */
public class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        if(grid.length == 1){
            for (int i = 0; i < grid[0].length - 1; i++) {
                if (grid[0][i] == grid[0][i + 1]) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] == grid[i][j + 1] || grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
            }
            if (grid[i][grid[0].length - 1] != grid[i + 1][grid[0].length - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1}, {2}, {3}};
        boolean res = solution.satisfiesConditions(grid);
        System.out.println(res);
    }
}

