package com.middle.code_3403;

/**
 * @Author chenyuxiang
 * @Date 2025/6/4
 * @Description
 */
public class Solution {
    //把 word 分割为 numFriends 个非空子串，返回其中字典序最大的子串。
    public String answerString(String s, int k) {
        if (k == 1) {
            return s;
        }
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            String sub = s.substring(i, Math.min(i + n - k + 1, n));
            if (sub.compareTo(ans) > 0) {
                ans = sub;
            }
        }
        return ans;
    }
}
