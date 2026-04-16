package com.middle.code_216;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/2/21
 * @Description
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List res = new ArrayList();
        List<Integer> path = new ArrayList<>();
        dfs(k, n, 1, res, path);
        return res;
    }

    public void dfs(int k, int n, int start, List res, List<Integer> path) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k - 1, n - i, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
