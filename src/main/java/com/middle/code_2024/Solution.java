package com.middle.code_2024;

/**
 * @Author chenyuxiang
 * @Date 2024/9/2
 * @Description
 */
public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int res = 0;
        int maxCountT = 0; // 用于记录最多可以连续的T的数量
        int maxCountF = 0; // 用于记录最多可以连续的F的数量
        int left = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                maxCountT++;
            } else {
                maxCountF++;
            }

            // 如果当前窗口大小减去最大连续同字符的数量大于k，需要移动左指针缩小窗口
            while (right - left + 1 - Math.max(maxCountT, maxCountF) > k) {
                if (answerKey.charAt(left) == 'T') {
                    maxCountT--;
                } else {
                    maxCountF--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answerKey = "TTFTTFTT";
        int k = 1;
        int res = solution.maxConsecutiveAnswers(answerKey, k);
        System.out.println(res);
    }
}
