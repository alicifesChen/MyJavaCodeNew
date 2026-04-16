package com.middle.code_3440;

/**
 * @Author chenyuxiang
 * @Date 2025/7/10
 * @Description
 */
public class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] free = new int[n + 1];
        int[] time = new int[n];
        free[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            free[i] = startTime[i] - endTime[i - 1];
        }
        free[n] = eventTime - endTime[n - 1];
        for (int i = 0; i < n; i++) {
            time[i] = endTime[i] - startTime[i];
        }
        // 左侧最大空闲
        int leftFreeMax = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int cur = free[i] + free[i + 1];
            // 如果左侧最大空闲比当前会议时长大 说明可以把当前会议移到左侧 当前连续空余时间要加上当前会议时长
            if (leftFreeMax >= time[i]) {
                cur += time[i];
            }
            leftFreeMax = Math.max(leftFreeMax, free[i]);
            res = Math.max(cur, res);
        }
        // 右侧最大空闲
        int rightFreeMax = 0;
        for (int i = n; i >= 1; i--) {
            int cur = free[i] + free[i - 1];
            // 如果右侧最大空闲比当前会议时长大 说明可以把当前会议移到右侧 当前连续空余时间要加上当前会议时长
            if (rightFreeMax >= time[i - 1]) {
                cur += time[i - 1];
            }
            rightFreeMax = Math.max(rightFreeMax, free[i]);
            res = Math.max(cur, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int eventTime = 41;
        int[] startTime = {17, 24};
        int[] endTime = {18,25};
        int result = solution.maxFreeTime(eventTime, startTime, endTime);
        System.out.println("最大空余时间段: " + result); // 输出最大空余时间段
    }
}
