package com.middle.code_3335;

/**
 * @Author chenyuxiang
 * @Date 2025/5/13
 * @Description
 */
public class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long res = s.length();
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            int curArr = arr[25];
            res = (res + curArr) % 1000000007;
            for (int j = 24; j > 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[1] = (arr[0] + curArr) % 1000000007;
            arr[0] = curArr;
        }
        return (int) res;
    }
}
