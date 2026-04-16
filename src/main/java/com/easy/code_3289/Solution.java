package com.easy.code_3289;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025-10-31
 * @Description
 */
public class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 2) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
