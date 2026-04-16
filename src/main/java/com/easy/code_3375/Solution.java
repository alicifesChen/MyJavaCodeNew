package com.easy.code_3375;

import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025/4/10
 * @Description 给你一个数组nums和一个值k,如果nums中所有元素【大于||等于k】那么请返回nums中【大于K】的不重复元素有几个。如果nums中有【小于k】的值就返回-1
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if(num > k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return map.size();
    }
}
