package com.easy.code_2515;

/**
 * @Author chenyuxiang
 * @Date 2026-04-15
 * @Description 给你一个下标从 0 开始的 环形 字符串数组 words 和一个字符串 target 。环形数组 意味着数组首尾相连。
 * 形式上， words[i] 的下一个元素是 words[(i + 1) % n] ，而 words[i] 的前一个元素是 words[(i - 1 + n) % n] ，其中 n 是 words 的长度。
 * 从 startIndex 开始，你一次可以用 1 步移动到下一个或者前一个单词。
 * 返回到达目标字符串 target 所需的最短距离。如果 words 中不存在字符串 target ，返回 -1 。
 * 输入：words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
 * 输出：1
 * 解释：从下标 1 开始，可以经由以下步骤到达 "hello" ：
 * - 向右移动 3 个单位，到达下标 4 。
 * - 向左移动 2 个单位，到达下标 4 。
 * - 向右移动 4 个单位，到达下标 0 。
 * - 向左移动 1 个单位，到达下标 0 。
 * 到达 "hello" 的最短距离是 1 。
 */
public class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int dist = Math.abs(i - startIndex);
                res = Math.min(res, Math.min(dist, n - dist));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        System.out.println(solution.closestTarget(words, target, startIndex));
    }
}
