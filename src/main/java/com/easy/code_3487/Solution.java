package com.easy.code_3487;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2025/7/25
 * @Description
 */
public class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxSum = 0;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if(list.get(list.size() -1) < 0){
            return list.get(list.size() - 1);
        }
        for (int i = 0; i < list.size(); i++) {
            maxSum = Math.max(maxSum, maxSum + list.get(i));
        }
        return maxSum;
    }
}
