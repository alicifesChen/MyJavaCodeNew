package com.middle.code_3228;

/**
 * @Author chenyuxiang
 * @Date 2025-11-13
 * @Description
 */
public class Solution {
    public int maxOperations(String s) {
        int res = 0;
        int onesCount = 0; // 统计遇到的1的总数

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            } else if (i > 0 && s.charAt(i - 1) == '1') {
                // 从1变成0，说明一个1块结束，这些1会跨过后面的0块
                res += onesCount;
            }
        }

        return res;
    }

}
