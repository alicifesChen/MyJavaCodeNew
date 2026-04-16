package com.easy.code_3019;

/**
 * @Author chenyuxiang
 * @Date 2025/1/7
 * @Description
 */
public class Solution {
    public int countKeyChanges(String s) {
        int res = 0;
        for (int i = 1; i < s.length(); i ++){
            if(!(s.charAt(i) - s.charAt(i - 1) == 0 || s.charAt(i) - s.charAt(i - 1) == 32 || s.charAt(i) - s.charAt(i - 1) == -32)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println('a' - 'A');
    }
}
