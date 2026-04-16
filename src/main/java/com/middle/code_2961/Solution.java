package com.middle.code_2961;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/7/30
 * @Description
 */
public class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < variables.length;i ++) {
            List<Integer> list = new ArrayList<>();
            for (int variable : variables[i]) {
                list.add(variable);
            }
            if(checkSort(list, target)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean checkSort(List<Integer> list, int target) {
        if (list.size() != 4) {
            return false;
        }
        long base = list.get(0) % 10;
        long exponent = list.get(1);
        long mod1 = list.get(2);
        long mod2 = list.get(3);

        // Calculate (base ^ exponent) % 10
        long firstMod = modPow(base, exponent, 10);

        // Calculate (firstMod ^ mod1) % mod2
        long finalMod = modPow(firstMod, mod1, mod2);

        return finalMod == target;
    }

    // Helper method to perform modular exponentiation
    private static long modPow(long base, long exp, long mod) {
        if (mod == 1) return 0;
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] variables = {{1, 2, 3, 4}, {1, 2, 3, 4}};
        int target = 1;
        List<Integer> res = solution.getGoodIndices(variables, target);
        for (int num : res) {
            System.out.println(num);
        }
    }
}


