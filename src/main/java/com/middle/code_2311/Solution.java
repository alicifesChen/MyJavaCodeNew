package com.middle.code_2311;

/**
 * @Author chenyuxiang
 * @Date 2025/6/26
 * @Description
 */
public class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        // 记录当前二进制数的值
        long num = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // 判断是否可以将当前字符添加到 sb 中
            if (c == '1') {
                sb.append('1'); // 添加 '1' 到 sb
                num = Long.parseLong(sb.toString(), 2); // 计算当前二进制数值
                // 如果当前的二进制数值超过了 k，则删除当前的 '1'
                if (num > k) {
                    sb.deleteCharAt(sb.length() - 1); // 删除最后一个 '1'
                    //前面如果有0补0
                    break;  // 不再继续添加字符
                }
            } else {
                sb.append('0'); // 添加 '0' 到 sb
            }
        }

        return sb.length();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1001010";
        int k = 5;
        int result = solution.longestSubsequence(s, k);
        System.out.println("The length of the longest subsequence is: " + result);
    }
}
