package com.easy.code_3304;

/**
 * @Author chenyuxiang
 * @Date 2025/7/3
 * @Description
 */
public class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while (sb.length() < k) {
            StringBuilder next = new StringBuilder();
            for (char c : sb.toString().toCharArray()) {
                if (c == 'z') {
                    next.append('a');
                } else {
                    next.append((char) (c + 1));
                }
            }
            sb.append(next);
        }
        return sb.charAt(k);
    }
}
