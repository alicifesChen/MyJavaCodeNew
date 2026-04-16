package com.middle.code_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/7/8
 * @Description
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> numsList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        numsList.sort(Integer::compareTo);
        for (int i = 0; i < numsList.size(); i++) {
            for (int j = i + 1; j < numsList.size(); j++) {
                map.put(numsList.get(j), j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = solution.threeSum(nums);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
