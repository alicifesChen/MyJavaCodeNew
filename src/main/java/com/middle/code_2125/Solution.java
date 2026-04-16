package com.middle.code_2125;

/**
 * @Author chenyuxiang
 * @Date 2025-10-27
 * @Description
 */
public class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int res = 0;
        for (String s : bank) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            if (count > 0) {
                res += prev * count;
                prev = count;
            }
        }
        return res;

    }
}
