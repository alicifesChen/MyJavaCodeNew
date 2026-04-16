package com.easy.code_3222;

/**
 * @Author chenyuxiang
 * @Date 2024/11/5
 * @Description
 */
public class Solution {
    public String losingPlayer(int x, int y) {
        int turn = 0;
        while (x > 0 && y > 0) {
            x --;
            y -= 4;
            turn ++;
        }
        if(turn % 2 == 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
}
