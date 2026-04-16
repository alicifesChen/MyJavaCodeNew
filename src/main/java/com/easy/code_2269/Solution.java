package com.easy.code_2269;

/**
 * @Author chenyuxiang
 * @Date 2025/3/10
 * @Description
 */
public class Solution {
    public int divisorSubstrings(int num, int k) {
        int res = 0;
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length() -k + 1; i++) {
            int temp = Integer.parseInt(numStr.substring(i, i + k));
            if(temp == 0){
                continue;
            }
            if(num % temp == 0){
                res ++;
            }
        }
        return res;
    }
}
