package com.easy.code_1534;

/**
 * @Author chenyuxiang
 * @Date 2025/4/14
 * @Description
 */
public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (isGood(i, j, k, a, b, c, arr)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

   public boolean isGood(int i, int j, int k, int a, int b, int c, int[] arr) {
        return Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c;
    }
}
