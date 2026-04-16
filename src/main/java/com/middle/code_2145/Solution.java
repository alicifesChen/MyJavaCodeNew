package com.middle.code_2145;

import java.sql.Array;

/**
 * @Author chenyuxiang
 * @Date 2025/4/21
 * @Description
 */
public class Solution {
    public long numberOfArrays(int[] differences, int lower, int upper) {
        long minPref = 0, maxPref = 0, pref = 0;
        for (int d : differences) {        // 单趟遍历
            pref += d;                      // 滚动式前缀和
            if (pref < minPref) minPref = pref;
            if (pref > maxPref) maxPref = pref;
        }
        // 1）前缀和的最小值 minPref，表示前缀和的下界
        // 2）前缀和的最大值 maxPref，表示前缀和的上界
        // 3）lower - minPref，表示前缀和的下界需要加上多少才能大于等于 lower
        // 4）upper - maxPref，表示前缀和的上界需要减去多少才能小于等于 upper
        // 5）right - left + 1，表示前缀和的范围
        // 6）如果前缀和的范围小于 0，表示没有符合条件的前缀和
        // 7）如果前缀和的范围大于 0，表示符合条件的前缀和的个数

        long left  = (long) lower - minPref;  // lower - min
        long right = (long) upper - maxPref;  // upper - max

        return (int) Math.max(0, right - left + 1);
    }
}
