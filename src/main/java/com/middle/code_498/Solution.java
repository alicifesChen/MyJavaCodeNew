package com.middle.code_498;

/**
 * @Author chenyuxiang
 * @Date 2025-08-25
 * @Description
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n * m];
        int state = 1; // 1: up-right, -1: down-left
        int x = 0, y = 0;
        int index = 0;
        
        while (index < n * m) {
            result[index++] = mat[x][y];
            
            if (state == 1) { // up-right
                x--;
                y++;
                // Check bounds and adjust
                if (x < 0 || y >= m) {
                    state = -1; // Change direction
                    if (x < 0 && y < m) {
                        x = 0; // Move to first row
                    } else {
                        x = x + 2; // Move down
                        y = y - 1; // Move left
                    }
                }
            } else { // down-left
                x++;
                y--;
                // Check bounds and adjust
                if (y < 0 || x >= n) {
                    state = 1; // Change direction
                    if (y < 0 && x < n) {
                        y = 0; // Move to first column
                    } else {
                        y = y + 2; // Move right
                        x = x - 1; // Move up
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = solution.findDiagonalOrder(mat);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
