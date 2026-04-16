package com.middle.code_1717;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author chenyuxiang
 * @Date 2025/7/23
 * @Description
 */
public class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            // 优先消除"ba"
            return process(s, "ba", y) + process(s, "ab", x);
        } else {
            // 优先消除"ab"
            return process(s, "ab", x) + process(s, "ba", y);
        }
    }

    private int process(String s, String pattern, int score) {
        Deque<Character> stack = new ArrayDeque<>();
        int res = 0;
        char first = pattern.charAt(0), second = pattern.charAt(1);
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                res += score;
            } else {
                stack.push(c);
            }
        }
        // 剩下的字符串顺序反了，如果需要二次处理，需reverse回来
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        s = sb.toString();
        return res;
    }

}
