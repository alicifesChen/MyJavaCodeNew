package com.easy.code_3136;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/7/15
 * @Description
 */
public class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) {
            return false; // 如果字符串长度小于2，直接返回true
        }
        boolean isVowel = false; // 标记是否遇到元音字母
        boolean isConsonant = false; // 标记是否遇到辅音字母
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        //由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
        if(!word.matches("[a-zA-Z0-9]+")) {
            return false; // 如果字符串中包含非字母数字字符，直接返回false
        }

        //判断是字母
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                if (vowels.contains(Character.toLowerCase(c))) {
                    isVowel = true; // 遇到元音字母
                } else {
                    isConsonant = true; // 遇到辅音字母
                }
            }
        }
        return isVowel && isConsonant; // 如果没有遇到元音字母或辅音字母，直接返回true
    }
}
