package com.easy.code_2200;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2025/6/24
 * @Description
 */
public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> nunData = new ArrayList<>();
        for (int i = 0; i < n; i ++ ) {
            if(nums[i] == key) {
                nunData.add(i);
            }
        }
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nunData.size(); i++) {
            int index = nunData.get(i);
            for (int j = Math.max(0, index - k); j <= Math.min(n - 1, index + k); j++) {
                res.add(j);
            }
        }
        List<Integer> result = new ArrayList<>(res);
        Collections.sort(result);
        return result;
    }
}
