package com.middle.code_1456;

/**
 * @Author chenyuxiang
 * @Date 2025/7/9
 * @Description
 */
public class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int res  = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                ans++;
            }
            if(i < k - 1) {
                continue; // 窗口还没有填满
            }
            res = Math.max(res, ans);
            char out = s.charAt(i - k + 1);
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                res--; // 窗口左边的字符是元音字母，减少计数
            }
        }
        return res; // 返回最大元音字母数
    }
}
