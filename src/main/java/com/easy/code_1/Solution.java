package com.easy.code_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author chenyuxiang
 * @Date 2024/7/1
 * @Description
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = solution.twoSum(nums, target);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
