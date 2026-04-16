package com.middle.code_743;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/11/25
 * @Description
 */
public class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int res = 0;
        if(((colors[colors.length - 1] ^ colors[0]) == 1) &&  (colors[0] ^ colors[1]) == 1) {
            res ++;
        }
        for(int i = 1; i < colors.length - 1; i++) {
            if((colors[i] ^ colors[i - 1]) == 1 && (colors[i] ^ colors[i + 1]) == 1) {
                res ++;
            }
        }
        if((colors[colors.length - 2] ^ colors[colors.length - 1]) == 1 && (colors[colors.length - 1] ^ colors[0]) == 1) {
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] colors = {1, 1, 0, 1, 1};
        int res = solution.numberOfAlternatingGroups(colors);
        System.out.println(res);
    }
}
