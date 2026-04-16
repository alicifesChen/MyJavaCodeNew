package com.easy.code_3396;

import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025/4/8
 * @Description
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxCount = 0;
        while (Boolean.FALSE.equals(onlyOne(map))) {
            for (int i = maxCount * 3; i < Math.min(maxCount * 3 + 3, nums.length); i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) - 1);
                    if (map.get(nums[i]) == 0) {
                        map.remove(nums[i]);
                    }
                }
                if (map.isEmpty()) {
                    return maxCount;
                }
            }
            maxCount += 1;
        }
        return maxCount;
    }

    private Boolean onlyOne(HashMap<Integer, Integer> map) {
        if (map.isEmpty()) {
            return true;
        }
        for (Integer value : map.values()) {
            if (value > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 2, 3, 3, 5, 7};
        System.out.println(solution.minimumOperations(nums)); // Output: 0
    }
}
