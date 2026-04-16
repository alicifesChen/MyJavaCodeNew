package com.easy.code_344;

/**
 * @Author chenyuxiang
 * @Date 2024/7/9
 * @Description
 */
public class Solution {
    public void reverseString(char[] s) {
       int left = 0;
       int right = s.length - 1;
       while (left < right) {
           char temp = s[left];
           s[left] = s[right];
           s[right] = temp;
           left++;
           right--;
       }
    }
}
