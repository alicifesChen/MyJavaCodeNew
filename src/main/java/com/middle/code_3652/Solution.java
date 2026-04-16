package com.middle.code_3652;

/**
 * @Author chenyuxiang
 * @Date 2025-12-18
 * @Description
 */
public class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // 计算原始利润
        long originalProfit = 0;
        for (int i = 0; i < n; i++) {
            originalProfit += (long) prices[i] * strategy[i];
        }

        // 计算第一个窗口 [0, k-1] 的 delta
        long delta = 0;
        for (int j = 0; j < k / 2; j++) {
            // 前半部分设为 0：移除原贡献
            delta -= (long) prices[j] * strategy[j];
        }
        for (int j = k / 2; j < k; j++) {
            // 后半部分设为 1：移除原贡献，加上新贡献
            delta -= (long) prices[j] * strategy[j];
            delta += prices[j];
        }

        long maxDelta = delta;

        // 滑动窗口优化
        for (int i = 1; i <= n - k; i++) {
            // 窗口从 [i-1, i+k-2] 移动到 [i, i+k-1]

            // 移除左边离开的元素 (位置 i-1)
            int leftPos = i - 1;
            if (leftPos < (i - 1) + k / 2) {
                // 原来在前半部分（设为0）
                delta += (long) prices[leftPos] * strategy[leftPos];
            } else {
                // 原来在后半部分（设为1）
                delta += (long) prices[leftPos] * strategy[leftPos];
                delta -= prices[leftPos];
            }

            // 添加右边新加入的元素 (位置 i+k-1)
            int rightPos = i + k - 1;
            if (rightPos < i + k / 2) {
                // 在新窗口的前半部分（设为0）
                delta -= (long) prices[rightPos] * strategy[rightPos];
            } else {
                // 在新窗口的后半部分（设为1）
                delta -= (long) prices[rightPos] * strategy[rightPos];
                delta += prices[rightPos];
            }

            maxDelta = Math.max(maxDelta, delta);
        }

        return originalProfit + maxDelta;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {4,2,8};
        int[] strategy = {-1,0,1};
        int k = 2;
        long result = solution.maxProfit(prices, strategy, k);
        System.out.println(result);
    }

}
