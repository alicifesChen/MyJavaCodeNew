package com.middle.code_120;

import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-09-25
 * @Description  自下向上
 *   核心思想：从三角形底部开始，逐层向上计算每个位置到底部的最小路径和。
 *   详细步骤
 *   1. 初始化：
 *   int[] dp = new int[n];
 *     - dp[i] 表示从当前层第i个位置到底部的最小路径和
 *   2. 边界条件：
 *   for (int i = 0; i < n; i++) {
 *       dp[i] = triangle.get(n - 1).get(i);
 *   }
 *     - 将最后一行的值作为初始状态（到自己的距离就是自己的值）
 *   3. 状态转移：
 *   for (int row = n - 2; row >= 0; row--) {
 *       for (int col = 0; col <= row; col++) {
 *           dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
 *       }
 *   }
 *     - 从倒数第二行开始，向上逐层计算
 *     - 对于位置(row, col)，只能向下移动到(row+1, col)或(row+1, col+1)
 *     - 选择两个下层位置中路径和更小的那个
 *   举例说明
 *   假设三角形：
 *      2
 *     3 4
 *    6 5 7
 *   4 1 8 3
 *   执行过程：
 *   - 初始：dp = [4, 1, 8, 3]
 *   - 第3行：dp = [7, 6, 10] （6+min(4,1), 5+min(1,8), 7+min(8,3)）
 *   - 第2行：dp = [9, 10] （3+min(7,6), 4+min(6,10)）
 *   - 第1行：dp = [11] （2+min(9,10)）
 *   复杂度分析
 *   - 时间复杂度：O(n²) - 遍历三角形每个元素一次
 *   - 空间复杂度：O(n) - 只需要一个一维数组
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }

        return dp[0];
    }
}
