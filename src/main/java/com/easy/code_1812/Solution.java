package com.easy.code_1812;

/**
 * @Author chenyuxiang
 * @Date 2024/12/9
 * @Description
 */
public class Solution {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '1';
        return (x + y) % 2 == 1;
    }
}
