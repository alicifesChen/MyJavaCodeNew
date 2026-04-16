package com.easy.code_20;

/**
 * @Author chenyuxiang
 * @Date 2024/8/6
 * @Description
 */
public class Solution {
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty();
    }
}
