package com.easy.code_2970;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/7/10
 * @Description
 */
public class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                List<Integer> list = new ArrayList<Integer>();
                for (int k = 0; k < i; ++k) {
                    list.add(nums[k]);
                }
                for (int k = j + 1; k < nums.length; ++k) {
                    list.add(nums[k]);
                }
                if (checkSort(list)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean checkSort(List<Integer> list) {
        for(int i = 0;i < list.size() - 1;++i) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
