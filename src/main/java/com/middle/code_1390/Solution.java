package com.middle.code_1390;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-01-04
 * @Description
 */
public class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int num : nums) {
            List<Integer> divisors = new ArrayList<>();
            // 找出所有因数
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    divisors.add(i);
                    if (i != num / i) {
                        divisors.add(num / i);
                    }
                }
            }
            // 如果恰好有4个因数,累加它们的和
            if (divisors.size() == 4) {
                for (int d : divisors) {
                    result += d;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {21,4,7};
        int result = solution.sumFourDivisors(nums);
        System.out.println(result); // Expected output: 32
    }
}
