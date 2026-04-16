package com.middle.code_729;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/1/2
 * @Description
 */
public class Solution {

    List<int[]> calendar;
    public void MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        if(calendar.isEmpty()) {
            calendar.add(new int[]{startTime, endTime});
            return true;
        }
        for(int[] time : calendar) {
            if(time[0] >= startTime && time[0] < endTime) {
                return false;
            }
            if(time[1] > startTime && time[1] <= endTime) {
                return false;
            }
            if(time[0] <= startTime && time[1] >= endTime) {
                return false;
            }
        }
        calendar.add(new int[]{startTime, endTime});
        return true;
    }
}
