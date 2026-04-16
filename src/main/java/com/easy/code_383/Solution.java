package com.easy.code_383;

/**
 * @Author chenyuxiang
 * @Date 2024/7/8
 * @Description
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                return false;
            }
            arr[c - 'a']--;
        }
        return true;
    }
}
