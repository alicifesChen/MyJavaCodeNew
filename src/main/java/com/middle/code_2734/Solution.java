package com.middle.code_2734;

/**
 * @Author chenyuxiang
 * @Date 2024/6/27
 * @Description
 */
public class Solution {
    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                sb.append('a');
                sb.append(s.substring(i + 1));
                break;
            } else {
                sb.append((char) (s.charAt(i) - 1));
            }
        }
        if (s.contentEquals(sb)) {
            sb.setCharAt(sb.length() - 1, 'z');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestString("b"));
        System.out.println(solution.smallestString("z"));
        System.out.println(solution.smallestString("ba"));
        System.out.println(solution.smallestString("aa"));
        System.out.println(solution.smallestString("cbabc"));
        System.out.println(solution.smallestString("acbbc"));
    }
}
