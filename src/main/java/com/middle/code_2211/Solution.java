package com.middle.code_2211;

/**
 * @Author chenyuxiang
 * @Date 2025-12-04
 * @Description
 */
public class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;

        // 跳过最左边连续的 'L'
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }

        // 跳过最右边连续的 'R'
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        // 中间所有非 'S' 的车都会碰撞
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                res++;
            }
        }

        return res;
    }
}
