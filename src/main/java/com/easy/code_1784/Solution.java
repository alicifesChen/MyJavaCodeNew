package com.easy.code_1784;

/**
 * @Author chenyuxiang
 * @Date 2026-03-06
 * @Description 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 */
public class Solution {
    public boolean checkOnesSegment(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                return false;
            }
        }
        return true;
    }
}
