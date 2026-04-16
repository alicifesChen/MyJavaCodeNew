package com.easy.code_1758;

/**
 * @Author chenyuxiang
 * @Date 2026-03-05
 * @Description 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 */
public class Solution {
    public int minOperations(String s) {
        //把首位变为 0
        int n = s.length();
        int changeFirst = 0;
        int changeSecond = 0;
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0 && s.charAt(i) == '1') {
                changeFirst++;
            } else if(i % 2 == 1 && s.charAt(i) == '0') {
                changeFirst++;
            }
            if(i % 2 == 1 && s.charAt(i) == '1') {
                changeSecond++;
            } else if(i % 2 == 0 && s.charAt(i) == '0') {
                changeSecond++;
            }
        }
        return Math.min(changeFirst, changeSecond);
    }
}
