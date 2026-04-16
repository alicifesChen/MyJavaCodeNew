package com.middle.code_2101;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/7/22
 * @Description
 */
public class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                // 如果炸弹i在炸弹j的爆炸范围内，那么炸弹j就在炸弹i的爆炸范围内
                if (i != j && isInRange(bombs[i], bombs[j])) {
                    graph.get(i).add(j);
                }
            }
        }

        // 计算每个炸弹引爆的最多炸弹数
        int maxDetonation = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            maxDetonation = Math.max(maxDetonation, dfs(graph, i, visited));
        }

        return maxDetonation;
    }

    private int dfs(List<List<Integer>> graph, int i, boolean[] visited) {
        visited[i] = true;
        int res = 1;
        for (int j : graph.get(i)) {
            if (!visited[j]) {
                res += dfs(graph, j, visited);
            }
        }
        return res;
    }


    // 判断炸弹j是否在炸弹i的爆炸范围内
    private boolean isInRange(int[] boom1,int[] boom2) {
        return Math.pow(boom1[0] - boom2[0], 2) + Math.pow(boom1[1] - boom2[1], 2) <= Math.pow(boom1[2], 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] bombs = {{0, 0, 2}, {1, 1, 2}, {2, 2, 2}};
        System.out.println(solution.maximumDetonation(bombs));
    }
}
