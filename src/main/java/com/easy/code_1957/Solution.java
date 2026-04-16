package com.easy.code_1957;

/**
 * @Author chenyuxiang
 * @Date 2025/7/21
 * @Description
 */
public class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1; // 计数连续字符的数量
        for (int i = 0; i < s.length(); i++) {
            // 如果当前字符与前一个字符相同，增加计数
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1; // 重置计数
            }
            // 如果连续字符的数量小于等于2，则添加到结果中
            if (count <= 2) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString(); // 返回处理后的字符串
    }
}
