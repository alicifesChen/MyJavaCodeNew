package com.middle.code_2901;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/5/16
 * @Description
 */
public class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> result = new ArrayList<>();

        // 动态规划数组 dp[i] 表示以第 i 个字符串结尾的最长有效子序列长度
        int[] dp = new int[n];
        int[] prev = new int[n];  // 记录路径
        int maxLength = 1;
        int endIndex = 0;

        // 初始化 dp 数组
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;  // 初始化为 -1，表示没有前驱
        }

        // 动态规划计算最长有效子序列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && words[i].length() == words[j].length() && hammingDistance(words[i], words[j]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }

        // 回溯找到最长有效子序列
        List<String> longestSubsequence = new ArrayList<>();
        while (endIndex != -1) {
            longestSubsequence.add(0, words[endIndex]);
            endIndex = prev[endIndex];
        }

        return longestSubsequence;
    }

    // 计算两个字符串的汉明距离
    private int hammingDistance(String a, String b) {
        int distance = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) distance++;
        }
        return distance;
    }
}
