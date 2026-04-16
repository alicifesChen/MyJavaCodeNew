package com.middle.code_2740;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/7/26
 * @Description
 */
public class Solution {
    public int findValueOfPartition(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int end = Integer.MAX_VALUE;
        for (int num : nums) {
            list.add(num);
        }
        list.sort(Integer::compareTo);
        for(int i = 0; i < list.size() - 1; i++) {
            end = Math.min(end, list.get(i+ 1) - list.get(i));
        }
        return end;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 10, 100};
        int res = solution.findValueOfPartition(nums);
        System.out.println(res);
    }
}
