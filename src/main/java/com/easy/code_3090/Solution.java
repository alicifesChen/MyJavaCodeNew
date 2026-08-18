package com.easy.code_3090;

/**
 * @Author chenyuxiang
 * @Date 2026-08-14
 * @Description 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
 * 示例 1：
 * 输入： s = "bcbbbcba"
 * 输出： 4
 * 解释：
 * 以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。
 * 示例 2：
 * 输入： s = "aaaa"
 * 输出： 2
 * 解释：
 * 以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。
 */
public class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] count = new int[26];
        int left = 0, right = 0;
        int maxLength = 0;
        for (right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;
            while (count[s.charAt(right) - 'a'] > 2) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
