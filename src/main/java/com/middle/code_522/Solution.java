package com.middle.code_522;

/**
 * @Author chenyuxiang
 * @Date 2024/6/17
 * @Description: 给出一个字符串数组，在里面找出字符串满足当前字符串不是字符串数组中其他字符串的子序列，返回满足条件的字符串中 最长的字符串的长度
 */
public class Solution {
    public int findLUSlength(String[] strs) {
        int end = -1;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    break;
                }
                if (j == strs.length - 1) {
                    end = Math.max(end, strs[i].length());
                }
            }

        }
        return end;
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
