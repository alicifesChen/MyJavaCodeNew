package com.middle.code_2840;

import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-03-30
 * @Description 给你两个字符串 s1 和 s2 ，两个字符串长度都为 n ，且只包含 小写 英文字母。
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 * 选择两个下标 i 和 j ，满足 i < j 且 j - i 是 偶数，然后 交换 这个字符串中两个下标对应的字符。
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
 */
public class Solution {
    public boolean checkStrings(String s1, String s2) {
        List<Character> oddS1 = new java.util.ArrayList<>();
        List<Character> evenS1 = new java.util.ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                evenS1.add(s1.charAt(i));
            } else {
                oddS1.add(s1.charAt(i));
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (i % 2 == 0) {
                if (!evenS1.remove((Character) c)) {
                    return false; // 偶数位置字符不匹配
                }
            } else {
                if (!oddS1.remove((Character) c)) {
                    return false; // 奇数位置字符不匹配
                }
            }
        }
        return oddS1.isEmpty() && evenS1.isEmpty(); // 还有剩余字符，说明不匹配
    }
}
