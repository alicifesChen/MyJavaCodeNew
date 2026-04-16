package com.easy.code_3274;

/**
 * @Author chenyuxiang
 * @Date 2024/12/3
 * @Description
 */
public class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int x1 = coordinate1.charAt(0) - 'A';
        int y1 = coordinate1.charAt(1) - '1';
        int x2 = coordinate2.charAt(0) - 'A';
        int y2 = coordinate2.charAt(1) - '1';
        return (x1 + y1) % 2 == (x2 + y2) % 2;
    }
}
