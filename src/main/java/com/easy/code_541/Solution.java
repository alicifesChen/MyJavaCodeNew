package com.easy.code_541;

/**
 * @Author chenyuxiang
 * @Date 2024/7/9
 * @Description
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            if (i + k <= chars.length) {
                reverse(chars, i, i + k - 1);
            } else {
                reverse(chars, i, chars.length - 1);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
        System.out.println(solution.reverseStr("abcd", 2));
    }
}
