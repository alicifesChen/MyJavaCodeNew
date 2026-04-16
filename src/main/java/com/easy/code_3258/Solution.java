package com.easy.code_3258;

/**
 * @Author chenyuxiang
 * @Date 2024/11/12
 * @Description
 */
public class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int countOne = 0;
            int countZero = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    countOne++;
                } else {
                    countZero++;
                }
                if(countOne > k && countZero > k) {
                    break;
                } else {
                    end++;
                }
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "10101";
        int k = 1;
        System.out.println(solution.countKConstraintSubstrings(s, k));
    }
}
