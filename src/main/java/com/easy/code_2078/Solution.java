package com.easy.code_2078;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2026-04-20
 * @Description 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。
 * 给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
 * 返回 两栋 颜色 不同 房子之间的 最大 距离。
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
 */
public class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0;
        Map<Integer, Integer> mapMin = new HashMap<>();
        Map<Integer, Integer> mapMax = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mapMin.put(colors[i], Math.min(mapMin.getOrDefault(colors[i], Integer.MAX_VALUE), i));
            mapMax.put(colors[i], Math.max(mapMax.getOrDefault(colors[i], Integer.MIN_VALUE), i));
        }
        //取出不同的最大减去不同的最小
        for (int color : mapMin.keySet()) {
            for (int otherColor : mapMin.keySet()) {
                if (color != otherColor) {
                    res = Math.max(res, Math.abs(mapMax.get(color) - mapMin.get(otherColor)));
                    res = Math.max(res, Math.abs(mapMax.get(otherColor) - mapMin.get(color)));
                }
            }
        }
        return res;
        }
}
