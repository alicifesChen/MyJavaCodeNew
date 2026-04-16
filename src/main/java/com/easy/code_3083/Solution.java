package com.easy.code_3083;

/**
 * @Author chenyuxiang
 * @Date 2024/12/26
 * @Description
 */
public class Solution {
    public boolean isSubstringPresent(String s) {
        int left = 0;
        while (left < s.length() - 1) {
            int right = s.length() - 1;
            if(s.charAt(left) == s.charAt(left + 1)) {
                return true;
            }
            while (right > left + 1) { // Ensure there's space for two characters on the right
                if (s.charAt(left) == s.charAt(right) && s.charAt(left + 1) == s.charAt(right - 1)) {
                    return true;
                }
                right--;
            }
            left++;
        }
        return false;
    }
}
