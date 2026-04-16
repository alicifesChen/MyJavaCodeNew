package com.easy.code_1200;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-01-26
 * @Description
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return result;
    }
}
