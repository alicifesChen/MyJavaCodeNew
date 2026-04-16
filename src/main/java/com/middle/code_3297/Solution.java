package com.middle.code_3297;

/**
 * @Author chenyuxiang
 * @Date 2025/1/9
 * @Description
 */
class Solution {
    public long validSubstringCount(String word1, String word2) {
        // 初始化 word2 的字符计数
        int[] targetCount = new int[26];
        for (char c : word2.toCharArray()) {
            targetCount[c - 'a']++;
        }

        // 滑动窗口初始化
        int[] windowCount = new int[26];
        int left = 0, right = 0, valid = 0;
        long result = 0;

        // 滑动窗口遍历 word1
        while (right < word1.length()) {
            // 添加右边的字符到窗口
            char c = word1.charAt(right);
            windowCount[c - 'a']++;
            right++;

            // 检查当前窗口是否包含 word2 所需的所有字符
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (windowCount[i] < targetCount[i]) {
                    isValid = false;
                    break;
                }
            }

            // 如果窗口合法，则计算以当前窗口为结束的合法子字符串数量
            while (isValid) {
                result += word1.length() - right + 1; // 当前窗口长度的所有子串
                // 移动左边界，缩小窗口
                char removedChar = word1.charAt(left);
                windowCount[removedChar - 'a']--;
                left++;
                // 检查窗口是否仍然合法
                for (int i = 0; i < 26; i++) {
                    if (windowCount[i] < targetCount[i]) {
                        isValid = false;
                        break;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "abcabc";
        String word2 = "abc";
        System.out.println(solution.validSubstringCount(word1, word2));
    }
}
