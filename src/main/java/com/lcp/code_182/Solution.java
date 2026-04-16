package com.lcp.code_182;

/**
 * @Author chenyuxiang
 * @Date 2024/7/11
 * @Description
 */
public class Solution {
    public String dynamicPassword(String password, int target) {
        StringBuilder sb = new StringBuilder();
        for (int i = target; i < password.length(); i++) {
            sb.append(password.charAt(i));
        }
        for (int i = 0; i < target; i++) {
            sb.append(password.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dynamicPassword("abcdef", 2));
        System.out.println(solution.dynamicPassword("abcdef", 3));
        System.out.println(solution.dynamicPassword("abcdef", 4));
    }
}
