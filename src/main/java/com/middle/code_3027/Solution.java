package com.middle.code_3027;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025-09-03
 * @Description
 */
public class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(a,b) ->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(b[1],a[1]);
            }
        });
        int n = points.length;
        int ans = 0;
        for(int i = 0; i < n - 1; i++ ) {
            int down = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if(points[i][1] < points[j][1]) {
                    continue;
                }
                if(points[j][1] > down) {
                    ans++;
                    down = points[j][1];
                }
            }
        }
        return ans;

    }
}

