package com.middle.code_3484;

/**
 * @Author chenyuxiang
 * @Date 2025-09-19
 * @Description
 */
public class Solution {
    class Spreadsheet {

        int[][] sheet;

        public Spreadsheet(int rows) {
            sheet = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int row = Integer.parseInt(cell.substring(1)) - 1;
            int col = cell.charAt(0) - 'A';
            sheet[row][col] = value;
        }

        public void resetCell(String cell) {
            int row = Integer.parseInt(cell.substring(1)) - 1;
            int col = cell.charAt(0) - 'A';
            sheet[row][col] = 0;
        }

        public int getValue(String formula) {
            formula = formula.replace("=", "");
            String[] cells = formula.split("\\+");
            int sum = 0;
            for (String cell : cells) {
                cell = cell.trim();
                if (cell.isEmpty()) continue;

                //如果只是数字
                if(cell.chars().allMatch(Character::isDigit)){
                    sum += Integer.parseInt(cell);
                } else {
                    int row = Integer.parseInt(cell.substring(1)) - 1;
                    int col = cell.charAt(0) - 'A';

                    // 添加边界检查
                    if (row >= 0 && row < sheet.length && col >= 0 && col < 26) {
                        sum += sheet[row][col];
                    }
                }
            }
            return sum;
        }

    }
}
