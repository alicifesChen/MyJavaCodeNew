package com.easy.code_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2024/6/28
 * @Description
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : nums2){
            if(map.containsKey(num)){
                res.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = solution.intersect(nums1, nums2);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
