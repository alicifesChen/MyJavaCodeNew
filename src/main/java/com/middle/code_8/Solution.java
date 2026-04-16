package com.middle.code_8;

/**
 * @Author chenyuxiang
 * @Date 2024/12/16
 * @Description
 */
public class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                sign = s.charAt(i) == '+' ? 1 : -1;
            } else if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                if (res > (Integer.MAX_VALUE - num) / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + num;
            } else {
                break;
            }
        }
        return res * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1337c0d3";
        System.out.println(solution.myAtoi(s));
    }
}
