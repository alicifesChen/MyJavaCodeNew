package com.middle.code_624;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/2/19
 * @Description
 */
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        // 如果只有一个数组，题意通常无法构成“不同数组”对，视题目要求决定返回什么
        if (n < 2) {
            return 0;
        }

        // 记录最小值和最大值信息
        // minVal1, minVal2: 最小值和次小值
        // minIdx1, minIdx2: 它们对应的数组下标
        int minVal1 = Integer.MAX_VALUE, minVal2 = Integer.MAX_VALUE;
        int minIdx1 = -1, minIdx2 = -1;

        // maxVal1, maxVal2: 最大值和次大值
        // maxIdx1, maxIdx2: 它们对应的数组下标
        int maxVal1 = Integer.MIN_VALUE, maxVal2 = Integer.MIN_VALUE;
        int maxIdx1 = -1, maxIdx2 = -1;

        // 一次遍历，找出全局最小/次小，全局最大/次大
        for (int i = 0; i < n; i++) {
            // 当前数组排好序，首元素是最小值，尾元素是最大值
            int first = arrays.get(i).get(0);
            int last = arrays.get(i).get(arrays.get(i).size() - 1);

            // 更新最小值
            if (first < minVal1) {
                minVal2 = minVal1;
                minIdx2 = minIdx1;
                minVal1 = first;
                minIdx1 = i;
            } else if (first < minVal2) {
                minVal2 = first;
                minIdx2 = i;
            }

            // 更新最大值
            if (last > maxVal1) {
                maxVal2 = maxVal1;
                maxIdx2 = maxIdx1;
                maxVal1 = last;
                maxIdx1 = i;
            } else if (last > maxVal2) {
                maxVal2 = last;
                maxIdx2 = i;
            }
        }

        // 现在判断全局最小和全局最大是否来自同一个数组
        int res = 0;
        if (minIdx1 != maxIdx1) {
            // 来自不同数组，可以直接用
            res = Math.abs(maxVal1 - minVal1);
        } else {
            // 来自同一个数组，需要跟“次小值”或“次大值”配合
            // 情况1: 用最小值 + 次大值
            int diff1 = Math.abs(maxVal2 - minVal1);
            // 情况2: 用最大值 + 次小值
            int diff2 = Math.abs(maxVal1 - minVal2);
            res = Math.max(diff1, diff2);
        }

        return res;


//        // 用于存储最终结果（最大距离）
//        int ans = 0;
//        // 用于记录“之前遍历过的所有数组”中的最小值
//        // 初始化为 Integer.MAX_VALUE / 2，避免直接用 Integer.MAX_VALUE 在做减法时溢出
//        int mn = Integer.MAX_VALUE / 2;
//        // 用于记录“之前遍历过的所有数组”中的最大值
//        // 初始化为 Integer.MIN_VALUE / 2，避免直接用 Integer.MIN_VALUE 在做减法时溢出
//        int mx = Integer.MIN_VALUE / 2;
//
//        // 遍历所有数组
//        for (List<Integer> a : arrays) {
//            // 当前数组的最小值（因为数组已排序，最小值即首元素）
//            int x = a.get(0);
//            // 当前数组的最大值（因为数组已排序，最大值即尾元素）
//            int y = a.get(a.size() - 1);
//
//            // 计算两种可能的最大距离：
//            // 1. 当前数组的最大值 y，与“前面所有数组最小值 mn”的差值 (y - mn)
//            // 2. “前面所有数组最大值 mx”与当前数组最小值 x 的差值 (mx - x)
//            // 这里用 Math.max(y - mn, mx - x)，再和当前的 ans 做比较并更新
//            ans = Math.max(ans, Math.max(y - mn, mx - x));
//
//            // 继续更新全局的最小值和最大值
//            // mn 表示“所有已经遍历过的数组”最小值的最小值
//            mn = Math.min(mn, x);
//            // mx 表示“所有已经遍历过的数组”最大值的最大值
//            mx = Math.max(mx, y);
//        }
//        return ans;
    }
}
