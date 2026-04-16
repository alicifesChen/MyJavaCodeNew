package com.easy.code_1047;

/**
 * @Author chenyuxiang
 * @Date 2024/8/6
 * @Description
 */
public class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : s.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
}
