package com.easy.code_3318;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025-11-04
 * @Description
 */
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length - k + 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int right = i + k - 1;
            int[][] map = new int[51][2];  // map[数字][{数字本身, 出现次数}]
            int cnt = 0;  // 不同数字的个数
            for (int j = i; j <= right; j++) {
                cnt = map[nums[j]][1] == 0 ? cnt + 1 : cnt;  // 新数字则cnt+1
                map[nums[j]][0] = nums[j];   // 记录数字值
                map[nums[j]][1] += 1;         // 频率+1
            }
            int temp = Math.min(cnt, x);
            Arrays.sort(map, (int[] a, int[] b) -> a[1] < b[1] || (a[1]==b[1] && a[0] < b[0]) ? 1 : -1);
            int sum = 0;
            for (int m = 0; m < map.length && temp > 0; m++) {
                if (map[m][1] > 0) {
                    temp--;
                    sum += (map[m][0] * map[m][1]);
                }
            }
            ans[i] = sum;
        }
        return ans;
    }
}
