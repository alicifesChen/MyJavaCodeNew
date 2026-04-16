package com.easy.code_1287;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025/2/17
 * @Description
 */
public class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int maxData = n / 4;
        int left = 0;
        int right = left + maxData;
        while (right < n) {
            if (arr[left] == arr[right]) {
                return arr[left];
            }
            left++;
            right++;
        }
        return -1;
    }
}
