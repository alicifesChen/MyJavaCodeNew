package com.easy.code_2273;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-10-13
 * @Description
 */
public class Solution {
    public List<String> removeAnagrams(String[] words) {
        //根据word的字母数进行排序
        Arrays.sort(words, Comparator.comparingInt(String::length));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (i == 0 || !checkHeteronyms(words[i], words[i - 1])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    public Boolean checkHeteronyms(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : word1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
