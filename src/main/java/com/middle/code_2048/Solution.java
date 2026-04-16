package com.middle.code_2048;

/**
 * @Author chenyuxiang
 * @Date 2025-10-24
 * @Description
 */
public class Solution {
    public int nextBeautifulNumber(int n) {
        int res = n + 1;
        while (!isBeautiful(res)) {
            res++;
        }
        return res;
    }

    private boolean isBeautiful(int num) {
        String s = String.valueOf(num);
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        for (int i = 0; i <= 9; i++) {
            if (count[i] != i&&count[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextBeautifulNumber(1));
    }
}
