package com.middle.code_2683;

/**
 * @Author chenyuxiang
 * @Date 2025-07-31
 * @Description
 */
public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for(int der : derived){
            sum += der;
        }
        return sum % 2 == 0;
    }
}
