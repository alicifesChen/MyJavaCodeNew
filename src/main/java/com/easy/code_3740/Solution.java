package com.easy.code_3740;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2026-04-10
 * @Description 给你一个整数数组 nums。
 * 如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。
 * 有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。
 * 返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1
 */
public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;
            for (int i = 0; i < list.size() - 2; i++) {
                for (int j = i + 1; j < list.size() - 1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        int distance = Math.abs(list.get(i) - list.get(j)) + Math.abs(list.get(j) - list.get(k)) + Math.abs(list.get(k) - list.get(i));
                        min = Math.min(min, distance);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1,1,3};
        System.out.println(solution.minimumDistance(nums));
    }
}

