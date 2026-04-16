package com.middle.code_1733;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author chenyuxiang
 * @Date 2025-09-10
 * @Description
 */
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[][] learned = new boolean[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int x : languages[i]) {
                learned[i][x] = true;
            }
        }

        List<int[]> todoList = new ArrayList<>();
        next:
        for (int[] f : friendships) {
            //u 朋友1  v 朋友2
            int u = f[0] - 1, v = f[1] - 1; // 减一，下标从 0 开始
            for (int x : languages[u]) {
                if (learned[v][x]) { // 两人可以相互沟通，无需学习语言
                    continue next;
                }
            }
            todoList.add(f);
        }

        int ans = m;
        for (int k = 1; k <= n; k++) { // 枚举需要教的语言 k
            Set<Integer> set = new HashSet<>();
            for (int[] f : todoList) {
                int u = f[0] - 1, v = f[1] - 1;
                if (!learned[u][k]) { // u 需要学习语言 k
                    set.add(u);
                }
                if (!learned[v][k]) { // v 需要学习语言 k
                    set.add(v);
                }
            }
            ans = Math.min(ans, set.size()); // set.size() 是需要学习语言 k 的人数
        }
        return ans;
    }
}
