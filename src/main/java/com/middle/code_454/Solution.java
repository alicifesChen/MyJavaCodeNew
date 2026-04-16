package com.middle.code_454;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/7/1
 * @Description
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num1 : nums1){
            for(int num2 : nums2){
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if(map.containsKey(-num3 - num4)) {
                    end += map.get(-num3 - num4);
                }
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
