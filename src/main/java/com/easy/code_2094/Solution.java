package com.easy.code_2094;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2025/5/12
 * @Description
 */
public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> res = new HashSet<Integer>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (digits[k] % 2 == 0) {
                        res.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(res);
        Collections.sort(list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
