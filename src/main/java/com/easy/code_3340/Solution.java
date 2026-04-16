package com.easy.code_3340;

/**
 * @Author chenyuxiang
 * @Date 2025/3/14
 * @Description
 */
public class Solution {
    public boolean isBalanced(String num) {
        int n = num.length();
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return num.charAt(0) == '0';
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even += num.charAt(i) - '0';
            } else {
                odd += num.charAt(i) - '0';
            }
        }
        return odd == even;
    }
}
