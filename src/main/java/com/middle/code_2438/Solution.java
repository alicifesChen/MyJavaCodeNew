package com.middle.code_2438;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-08-11
 * @Description
 */
public class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        while (n != 0) {
            int i = tableSizeFor(n);
            powers.add(i);
            n -= i;
        }
        Collections.reverse(powers);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            long product = 1;
            while (left <= right) {
                product *= (powers.get(left++) % 1000000007);
                product %= 1000000007;
            }
            result[i] = (int) product;
        }
        return result;
    }

    private int tableSizeFor(int num) {
        int index = 0;
        while (num >= (1 << index)) {
            index++;
        }
        return 1 << (index - 1);
    }
}
