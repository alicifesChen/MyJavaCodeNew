package com.easy.code_3285;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/12/19
 * @Description
 */
public class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList<>();
        if (height.length < 2){
            return res;
        }
        for(int i = 1; i < height.length - 1; i++) {
            if(height[i] - height[i - 1] >= threshold) {
                res.add(i);
            }
        }
        return res;
    }
}
