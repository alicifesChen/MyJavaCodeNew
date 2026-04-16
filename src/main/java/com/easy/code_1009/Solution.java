package com.easy.code_1009;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-03-11
 * @Description
 */
public class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            sb.append(n % 2 == 0 ? 1 : 0);
            n = n / 2;
        }
        sb.append(n == 1 ? 0 : 1);
        System.out.println(sb.toString());
        return Integer.parseInt(sb.reverse().toString(), 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.bitwiseComplement(10);
        System.out.println("Complement of 5 is: " + result);
    }
}
