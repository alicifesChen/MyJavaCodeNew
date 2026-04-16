package com.middle.code_731;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/1/3
 * @Description
 */
public class Solution {
    List<int[]> calendar;
    public void MyCalendarTwo() {
        calendar = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        if (calendar.isEmpty()) {
            calendar.add(new int[]{startTime, endTime});
            return true;
        }
        List<int[]> overlap = new ArrayList<>();
        for (int[] time : calendar) {
            if (time[0] >= endTime || time[1] <= startTime) {
                continue;
            }
            int[] overlapTime = new int[]{Math.max(time[0], startTime), Math.min(time[1], endTime)};
            for (int[] time2 : overlap) {
                if (time2[0] >= overlapTime[1] || time2[1] <= overlapTime[0]) {
                    continue;
                }
                return false;
            }
            overlap.add(overlapTime);
        }
        calendar.add(new int[]{startTime, endTime});
        return true;
    }

}
