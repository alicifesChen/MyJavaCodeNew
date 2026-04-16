package com.easy.code_28;

/**
 * @Author chenyuxiang
 * @Date 2024/7/11
 * @Description
 */

//使用kmp
public class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        return 0;
    }

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < needle.length() - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("", ""));
    }
}
