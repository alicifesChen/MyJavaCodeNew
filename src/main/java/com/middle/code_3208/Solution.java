package com.middle.code_3208;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/11/27
 * @Description
 */
public class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n * 2; i++) {
            if (i > 0 && colors[i % n] == colors[(i - 1) % n]) {
                cnt = 0;
            }
            cnt++;
            if (i >= n && cnt >= k) {
                ans++;
            }
        }
        return ans;
    }
}
