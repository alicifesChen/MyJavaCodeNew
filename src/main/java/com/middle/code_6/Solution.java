package com.middle.code_6;

import java.util.ArrayList;

/**
 * @Author chenyuxiang
 * @Date 2024/6/19
 * @Description
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<Character>[] end = new ArrayList[numRows];
        int row = 0;
        boolean direction = true; //  true: down false: up
        for (int i = 0; i < numRows; i++) {
            end[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            end[row].add(s.charAt(i));
            if (row == numRows - 1 || row == 0) {
                direction = !direction;
            }
            if (direction) {
                row--;
            } else {
                row++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < end[i].size(); j++) {
                result.append(end[i].get(j));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("LEETCODEISHIRING", 3));
        System.out.println(solution.convert("LEETCODEISHIRING", 4));
        System.out.println(solution.convert("A", 1));
    }
}
