package com.easy.code_2011;

/**
 * @Author chenyuxiang
 * @Date 2025-10-20
 * @Description
 */
public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }
}
