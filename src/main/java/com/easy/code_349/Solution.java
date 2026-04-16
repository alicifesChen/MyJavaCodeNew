package com.easy.code_349;

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
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums1){
            map.put(num, 1);
        }
        for(int num : nums2){
            if(map.containsKey(num)){
                res.add(num);
                map.remove(num);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
