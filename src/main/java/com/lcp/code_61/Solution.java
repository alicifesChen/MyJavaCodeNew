package com.lcp.code_61;

/**
 * @Author chenyuxiang
 * @Date 2024/6/21
 * @Description
 */
public class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int maxTrend = 0;
        int left = 0;
        for (int right = 1; right < temperatureA.length; right++) {
            if (temperatureA[right] > temperatureA[right - 1] && temperatureB[right] > temperatureB[right - 1] ||
                    temperatureA[right] < temperatureA[right - 1] && temperatureB[right] < temperatureB[right - 1] ||
                    temperatureA[right] == temperatureA[right - 1] && temperatureB[right] == temperatureB[right - 1]
            ) {
                maxTrend = Math.max(maxTrend, right - left);
            } else {
                left = right;
            }
        }
        return maxTrend;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.temperatureTrend(new int[]{1, 2, 3, 2, 1}, new int[]{1, 2, 3, 2, 1}));
        System.out.println(solution.temperatureTrend(new int[]{1, 2, 3, 2, 1}, new int[]{1, 2, 3, 2, 3}));
        System.out.println(solution.temperatureTrend(new int[]{1, 2, 3, 2, 1}, new int[]{1, 2, 3, 2, 2}));
    }
}
