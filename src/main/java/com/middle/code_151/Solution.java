package com.middle.code_151;

/**
 * @Author chenyuxiang
 * @Date 2024/7/9
 * @Description
 */
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if(!word.equals("")) {
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
