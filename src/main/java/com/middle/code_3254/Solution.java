package com.middle.code_3254;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/11/6
 * @Description
 */
public class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] from = new ArrayList[n];
        Arrays.setAll(from, i -> new ArrayList<>());
        int[] f = new int[n];
        for (int i = 1; i < n; i++) {
            f[i] = i;
        }

        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];
            from[r].add(l);
            if (f[l] + 1 < f[r]) {
                f[r] = f[l] + 1;
                for (int i = r + 1; i < n; i++) {
                    f[i] = Math.min(f[i], f[i - 1] + 1);
                    for (int j : from[i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
            ans[qi] = f[n - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = {1,2,3,4,3,2,5};
        //int k = 3;
        int[] nums = {2,2, 2, 2, 2, 2, 2};
        int k = 4;
    }
}
