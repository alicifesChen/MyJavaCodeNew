package com.middle.code_1705;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/12/24
 * @Description
 */
public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int res = 0;
        int dayLen = apples.length;
        List<Integer> list = new ArrayList<>();
        List<Integer> dayList = new ArrayList<>();
        for (int i = 0; i < dayLen; i++) {
            days[i] = i + days[i];
            dayList.set(days[i], i);
        }
        for (int i = 0; i < dayLen; i++) {
            if (apples[i] > 0) {
                list.add(apples[i]);
            }
        }
        return res;
    }
}
