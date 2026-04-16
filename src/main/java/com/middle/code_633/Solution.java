package com.middle.code_633;

/**
 * @Author chenyuxiang
 * @Date 2024/11/4
 * @Description
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        int maxData = (int) Math.sqrt(c);
        for (int i = 0; i <= maxData; i++) {
            int b = c - i * i;
            int bSqrt = (int) Math.sqrt(b);
            if (bSqrt * bSqrt == b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int c = 5;
        System.out.println(solution.judgeSquareSum(c));
    }
}
