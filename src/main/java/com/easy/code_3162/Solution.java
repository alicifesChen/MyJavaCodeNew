package com.easy.code_3162;

import java.util.ArrayList;

/**
 * @Author chenyuxiang
 * @Date 2024/10/10
 * @Description
 */
public class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int end = 0;
        for (int value : nums1) {
            for (int i : nums2) {
                if (value % (i * k) == 0) {
                    end++;
                }
            }
        }
        return end;
    }
}
