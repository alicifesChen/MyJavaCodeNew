package com.middle.code_3863;

/**
 * @Author chenyuxiang
 * @Date 2026-10-21
 * @Description 给你一个由小写英文字母组成的字符串 s。
 * 在一次操作中，你可以选择 s 的任意 子字符串（但 不能 是整个字符串），并将其按 非降序字母顺序 进行 排序。
 * 返回使 s 按 非降序 排列所需的 最小 操作次数。如果无法做到，则返回 -1。
 * 示例 1：
 * 输入： s = "dog"
 * 输出： 1
 * 解释：
 * 将子字符串 "og" 排序为 "go"。
 * 现在，s = "dgo"，已按升序排列。因此，答案是 1。
 * 示例 2：
 * 输入： s = "card"
 * 输出： 2
 * 解释：
 * 将子字符串 "car" 排序为 "acr"，得到 s = "acrd"。
 * 将子字符串 "rd" 排序为 "dr"，得到 s = "acdr"，已按升序排列。因此，答案是 2。
 * 示例 3：
 * 输入： s = "gf"
 * 输出： -1
 * 解释：
 * 在给定提示下，无法对 s 进行排序。因此，答案是 -1。
 */
public class Solution {
    public int minOperations(String S) {
        char[] s = S.toCharArray();
        int n = s.length;

        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (s[i - 1] > s[i]) {
                isSorted = false;
                break;
            }
        }
        // s 已经是升序
        if (isSorted) {
            return 0;
        }

        // 长为 2，无法排序
        if (n == 2) {
            return -1;
        }

        char mn = s[0];
        char mx = s[0];
        for (char ch : s) {
            mn = (char) Math.min(mn, ch);
            mx = (char) Math.max(mx, ch);
        }
        if(mn == s[0] || mx == s[n - 1]) {
            return 1;
        }

        // 如果 [1,n-2] 中有最小值，那么先排序 [0,n-2]，把最小值排在最前面，然后排序 [1,n-1] 即可
        // 如果 [1,n-2] 中有最大值，那么先排序 [1,n-1]，把最大值排在最后面，然后排序 [0,n-2] 即可
        for (int i = 1; i < n - 1; i++) {
            if (s[i] == mn || s[i] == mx) {
                return 2;
            }
        }

        // 现在只剩下一种情况：s[0] 是最大值，s[n-1] 是最小值，且 [1,n-2] 不含最小值和最大值
        // 先排序 [0,n-2]，把最大值排到 n-2
        // 然后排序 [1,n-1]，把最大值排在最后面，且最小值排在 1
        // 最后排序 [0,n-2]，把最小值排在最前面
        return 3;
    }
}
