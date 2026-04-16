package com.middle.code_2799;

import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025/4/24
 * @Description
 */
public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int differentCount = map.size();
        int left = 0;
        int res = 0;
        HashMap<Integer, Integer> window = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            window.put(num, window.getOrDefault(num, 0) + 1);
            while (window.size() == differentCount) {
                res += nums.length - right;
                int leftNum = nums[left];
                window.put(leftNum, window.get(leftNum) - 1);
                if (window.get(leftNum) == 0) {
                    window.remove(leftNum);
                }
                left++;
            }
        }
        return res;
    }
}
