package com.hard.code_2197;

import java.util.List;
import java.util.Stack;

/**
 * @Author chenyuxiang
 * @Date 2025-09-16
 * @Description
 */
public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                int gcd = gcd(top, num);
                if (gcd == 1) {
                    break;
                }
                num = lcm(top, num);
                stack.pop();
            }
            stack.push(num);
        }
        return new java.util.ArrayList<>(stack);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
