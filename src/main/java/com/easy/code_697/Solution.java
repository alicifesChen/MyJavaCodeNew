package com.easy.code_697;

import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025/1/23
 * @Description
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] arr = map.get(nums[i]);
                arr[0]++;
                arr[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (int[] arr : map.values()) {
            if (arr[0] > maxNum) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (arr[0] == maxNum) {
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            }
        }
        return minLen;
    }
}
