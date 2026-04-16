package com.middle.code_1963;

import java.util.Stack;

/**
 * @Author chenyuxiang
 * @Date 2025/3/17
 * @Description
 */
public class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return (stack.size() + 1) / 2;
    }
}
