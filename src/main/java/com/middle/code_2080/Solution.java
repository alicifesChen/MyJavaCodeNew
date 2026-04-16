package com.middle.code_2080;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2025/2/18
 * @Description
 */
public class Solution {
    class RangeFreqQuery {

        Map<Integer, List<Integer>> map;
        public RangeFreqQuery(int[] arr) {
            map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int value) {
            if (!map.containsKey(value)) {
                return 0;
            }
            List<Integer> indices = map.get(value);
            int l = Collections.binarySearch(indices, left);
            int r = Collections.binarySearch(indices, right);
            if (l < 0) l = -l - 1;
            if (r < 0) r = -r - 2;
            return r - l + 1;
        }
    }
}
