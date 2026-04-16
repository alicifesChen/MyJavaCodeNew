package com.middle.code_1878;

import java.util.TreeSet;

/**
 * @Author chenyuxiang
 * @Date 2026-03-16
 * @Description
 */
public class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // 修复问题4：用 TreeSet 维护最大的3个不同值，原代码用 List 没有去重
        TreeSet<Integer> set = new TreeSet<>();

        // 修复问题1：原代码 i = grid.length-1，循环 k < i，导致最后一行/列永远不作为中心
        for (int k = 0; k < rows; k++) {
            for (int l = 0; l < cols; l++) {
                // size=0：单个格子本身也是合法的菱形
                addToSet(set, grid[k][l]);

                // 修复问题2&3：原代码用 (k±m, l±m) 计算的是正方形四角，不是菱形边界；
                // 且 count=0 时 m=0 会把同一格加4次，导致单格结果为 5*grid[k][l]
                // 正确做法：菱形大小为 r，沿4条对角线各走 r 步，拼成菱形边界
                for (int r = 1; k - r >= 0 && k + r < rows && l - r >= 0 && l + r < cols; r++) {
                    int sum = 0;
                    for (int m = 0; m < r; m++) {
                        sum += grid[k - r + m][l + m]; // 左上顶点 → 右顶点（右上边）
                        sum += grid[k + m][l + r - m]; // 右顶点 → 下顶点（右下边）
                        sum += grid[k + r - m][l - m]; // 下顶点 → 左顶点（左下边）
                        sum += grid[k - m][l - r + m]; // 左顶点 → 上顶点（左上边）
                    }
                    addToSet(set, sum);
                }
            }
        }
        return set.descendingSet().stream().mapToInt(x -> x).toArray();
    }

    // 始终只保留最大的3个不同值
    private void addToSet(TreeSet<Integer> set, int val) {
        set.add(val);
        if (set.size() > 3) set.pollFirst();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{7, 7, 7}};
        int[] result = solution.getBiggestThree(grid);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
