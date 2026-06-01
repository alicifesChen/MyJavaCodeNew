package com.middle.code_3043;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author chenyuxiang
 * @Date 2026-05-21
 * @Description
 */
public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();
        for (int x : arr1) {
            for (; x > 0; x /= 10) prefixes.add(x);
        }
        int ans = 0;
        for (int x : arr2) {
            for (; x > 0; x /= 10) {
                if (prefixes.contains(x)) {
                    ans = Math.max(ans, String.valueOf(x).length());
                    break;
                }
            }
        }
        return ans;
    }
}
