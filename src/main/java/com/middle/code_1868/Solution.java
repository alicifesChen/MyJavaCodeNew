package com.middle.code_1868;

/**
 * @Author chenyuxiang
 * @Date 2026-05-06
 * @Description 你一个 m x n 的字符矩阵 boxGrid ，它表示一个箱子的侧视图。箱子的每一个格子可能为：
 * '#' 表示石头
 * '*' 表示固定的障碍物
 * '.' 表示空位置
 * 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。
 * 每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。
 * 题目保证初始时 boxGrid 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
 * 请你返回一个 n x m 的矩阵，表示按照上述旋转后，箱子内的结果。
 * 输入：box = [["#",".","#"]]
 * 输出：[["."],
 *       ["#"],
 *       ["#"]]
 */
public class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] rotated = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = boxGrid[i][j];
            }
        }
        // 模拟重力  这里 j 是列 i 是行
        for (int j = 0; j < m; j++) {
            //当前可放石头的最低位置 emptyRow
            int emptyRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                //固定的障碍物
                if (rotated[i][j] == '*') {
                    //最低只能往上放
                    emptyRow = i - 1;
                    //如果障碍物上面有石头，石头就会掉落到障碍物上面
                } else if (rotated[i][j] == '#') {
                    if (emptyRow != i) {
                        rotated[emptyRow][j] = '#';
                        rotated[i][j] = '.';
                    }
                    emptyRow--;
                }
            }
        }
        return rotated;
    }


    public static void main(String[] args) {
            Solution solution = new Solution();
            char[][] boxGrid = {{'#','.','#'}};
            char[][] result = solution.rotateTheBox(boxGrid);
            for (char[] row : result) {
                for (char c : row) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
    }
}
