package com.middle.code_3159;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/12/27
 * @Description
 */
public class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = list.size() >= queries[i] ? list.get(queries[i] - 1) : -1;
        }
        return res;
    }
}
