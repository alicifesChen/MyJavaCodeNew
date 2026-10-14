package com.middle.code_3723;


/**
 * @Author chenyuxiang
 * @Date 2026-10-14
 * @Description 给你两个 正 整数 num 和 sum。
 * 如果一个正整数 n 满足以下两个条件，则称其为 好整数 ：
 * n 的位数 恰好 为 num。
 * n 的各位数字之和 恰好 为 sum。
 * 一个 好整数 n 的 分数 定义为 n 的各位数字的平方和。
 * 返回一个 字符串 ，表示能获得 最大分数 的 好整数 n。如果有多个可能的整数，返回 最大 的那个。如果不存在这样的整数，返回一个空字符串。
 * 示例 1:
 * 输入: num = 2, sum = 3
 * 输出: "30"
 * 解释:
 * 有 3 个好整数：12、21 和 30。
 * 12 的分数是 12 + 22 = 5。
 * 21 的分数是 22 + 12 = 5。
 * 30 的分数是 32 + 02 = 9。
 * 最大分数是 9，由好整数 30 获得。因此，答案是 "30"。
 * 示例 2:
 * 输入: num = 2, sum = 17
 * 输出: "98"
 * 解释:
 * 有两个好整数：89 和 98。
 * 89 的分数是 82 + 92 = 145。
 * 98 的分数是 92 + 82 = 145。
 * 最大分数是 145。获得此分数的最大好整数是 98。因此，答案是 "98"。
 * 示例 3:
 * 输入: num = 1, sum = 10
 * 输出: ""
 * 解释:
 * 不存在恰好有 1 位数字且各位数字之和为 10 的整数。因此，答案是 ""。
 */
public class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (sum > 9) {
            sb.append('9');
            sum -= 9;
            num--;
        }
        sb.append(sum);
        num--;
        for (int i = 0; i < num; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.maxSumOfSquares(2, 3);
        System.out.println(result1); // 输出: "30"

        String result2 = solution.maxSumOfSquares(2, 17);
        System.out.println(result2); // 输出: "98"

        String result3 = solution.maxSumOfSquares(1, 10);
        System.out.println(result3); // 输出: ""
    }
}
