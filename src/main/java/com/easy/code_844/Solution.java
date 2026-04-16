package com.easy.code_844;

/**
 * @Author chenyuxiang
 * @Date 2024/6/17
 * @Description
 */
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
    }

    public String backspace(String s) {
        char[] x = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < x.length; fast++) {
            if (x[fast] != '#') {
                x[slow] = x[fast];
                slow++;
            } else if (slow != 0 && s.charAt(fast) == '#'){
                slow--;
            }
        }
        return String.valueOf(x, 0, slow);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare("a##c", "#a#c"));
    }
}
