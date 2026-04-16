package com.middle.code_1552;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/2/14
 * @Description
 */
public class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1, right = position[n - 1] - position[0];
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 检验能否在“最小距离 = mid”的前提下放下 m 个球
            if (check(position, m, mid)) {
                // 可以放下，说明 mid 可行，尝试再增大
                answer = mid;
                left = mid + 1;
            } else {
                // 放不下，说明 mid 太大，需要缩小范围
                right = mid - 1;
            }
        }
        return answer;

    }

    private boolean check(int[] position, int mid, int m) {
        int count = 1;
        int last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                count++;
                last = position[i];
            }
        }
        return count >= m;
    }
}
