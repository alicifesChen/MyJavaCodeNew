package com.middle.code_2680;

/**
 * @Author chenyuxiang
 * @Date 2025/3/21
 * @Description
 */
public class Solution {
    public long maximumOr(int[] nums, int k) {
        // all记录所有数的或值，mul记录出现两次及以上的1
        int all = 0;
        int mul = 0;
        for (int num : nums) {
            mul |= all & num;
            all |= num;
        }

        long res = 0;
        for (int num : nums) {
            res = Math.max(res, (all ^ num) | mul | ((long) num << k));
        }
        return res;
    }
}
