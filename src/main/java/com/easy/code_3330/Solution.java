package com.easy.code_3330;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025/7/1
 * @Description
 */
public class Solution {
    public int possibleStringCount(String word) {
        int res = 0;
        for (int i = 1; i < word.length(); i ++) {
            if(word.charAt(i) == word.charAt(i - 1)) {
                res++;
            }
        }
        return res + 1; // 每个相同字符对都可以形成一个可能的字符串
    }
}
