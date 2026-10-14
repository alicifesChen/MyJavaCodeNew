package com.easy.code_3870;

/**
 * @Author chenyuxiang
 * @Date 2026-09-08
 * @Description 给你一个整数 n。
 * 返回将所有从 [1, n]（包含两端）范围内的整数以 标准 数字格式书写时所用到的 逗号总数。
 * 在 标准 格式中：
 * 从右边开始，每 三位 数字后插入一个逗号。
 * 位数 少于四位 的数字不包含逗号。
 * 示例 1：
 * 输入： n = 1002
 * 输出： 3
 * 解释：
 * 数字 "1,000"、"1,001" 和 "1,002" 每个都包含一个逗号，总计 3 个逗号。
 * 示例 2：
 * 输入： n = 998
 * 输出： 0
 * 解释：
 * 从 1 到 998 的所有数字位数都少于四位，因此没有使用逗号。
 */
public class Solution {
        public long countCommas(long n) {
            long ans = 0;
            // 从低到高，枚举逗号的位置
            for (long low = 1000; low <= n; low *= 1000) {
                // [low, n] 中的每个数都在这个位置上有一个逗号
                ans += n - low + 1;
            }
            return ans;
        }
}
