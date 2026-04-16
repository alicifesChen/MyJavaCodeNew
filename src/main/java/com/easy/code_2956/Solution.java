package com.easy.code_2956;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2024/7/16
 * @Description
 */
public class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int[] res = new int[2];
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        for(int num : nums1){
            if(map2.containsKey(num)){
                res[0]++;
            }
        }
        for(int num : nums2){
            if(map1.containsKey(num)){
                res[1]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = solution.findIntersectionValues(nums1, nums2);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
