package com.easy.code_3174;

/**
 * @Author chenyuxiang
 * @Date 2024/9/6
 * @Description
 */
public class Solution {
    public String clearDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                s = s.substring(0, i - 1 ) + s.substring(i + 1);
                i -= 2;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a1c1e1";
        //String s = "abc";
        //String s = "cb34";
        String res = solution.clearDigits(s);
        System.out.println(res);
    }
}
