package com.easy.code_3370;

/**
 * @Author chenyuxiang
 * @Date 2025-10-29
 * @Description
 */
public class Solution {
    public int smallestNumber(int n) {
        if(n == 0) return 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        sb.reverse();
        System.out.println(sb.toString());
        int res = 0;
        for (int i = 0; i < sb.length(); i++) {
            res += (int) Math.pow(2, sb.length() - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int res = solution.smallestNumber(n);
        System.out.println(res);
    }
}
