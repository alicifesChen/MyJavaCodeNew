package com.middle.code_2785;

/**
 * @Author chenyuxiang
 * @Date 2025-09-11
 * @Description
 */
public class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (vowels.indexOf(c) != -1) {
                sb.append(c);
            }
        }
        char[] vowelArr = sb.toString().toCharArray();
        java.util.Arrays.sort(vowelArr);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (vowels.indexOf(arr[i]) != -1) {
                arr[i] = vowelArr[index++];
            }
        }
        return new String(arr);
    }
}
