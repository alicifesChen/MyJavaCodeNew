package com.hard.code_2931;

import org.w3c.dom.ls.LSException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/12/12
 * @Description
 */
public class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        int[] a = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(values[i], 0, a, i * n, n);
        }
        Arrays.sort(a);

        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += (long) a[i] * (i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] values = {{10,8,6,4,2}, {9,7,5,3,2} };
        long res = solution.maxSpending(values);
        System.out.println(res);
    }
}
