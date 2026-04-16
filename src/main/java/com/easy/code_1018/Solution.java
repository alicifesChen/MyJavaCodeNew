package com.easy.code_1018;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-11-24
 * @Description
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int cur = 0;
        List<Boolean> res = new ArrayList<>();
        for (int num : nums) {
            cur = ((cur << 1) + num) % 5;
            res.add(cur == 0);
        }
        return res;
    }
}
