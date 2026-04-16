package com.easy.code_3248;

import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/11/21
 * @Description
 */
public class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            if("DOWN".equals(command)) {
                if(x < n - 1) {
                    x++;
                } else {
                    x = 0;
                }
            } else if("UP".equals(command)) {
                if(x > 0) {
                    x--;
                } else {
                    x = n - 1;
                }
            } else if("LEFT".equals(command)) {
                if(y > 0) {
                    y --;
                } else {
                    y = n - 1;
                }
            } else if("RIGHT".equals(command)) {
                if(y < n - 1) {
                    y++;
                } else {
                    y = 0;
                }
            }
        }
        return x * n + y;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
    }
}

