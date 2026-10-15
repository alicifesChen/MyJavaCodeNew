package com.easy.code_2913;

import java.util.HashSet;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-10-15
 * @Description 给你一个下标从 0 开始的整数数组 nums 。
 * 定义 nums 一个子数组的 不同计数 值如下：
 * 令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ），
 * 那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。
 * 请你返回 nums 中所有子数组的 不同计数 的 平方 和。
 * 子数组指的是一个数组里面一段连续 非空 的元素序列。
 * 示例 1：
 * 输入：nums = [1,2,1]
 * 输出：15
 * 解释：六个子数组分别为：
 * [1]: 1 个互不相同的元素。
 * [2]: 1 个互不相同的元素。
 * [1]: 1 个互不相同的元素。
 * [1,2]: 2 个互不相同的元素。
 * [2,1]: 2 个互不相同的元素。
 * [1,2,1]: 2 个互不相同的元素。
 * 所有不同计数的平方和为 12 + 12 + 12 + 22 + 22 + 22 = 15 。
 * 示例 2：
 * 输入：nums = [2,2]
 * 输出：3
 * 解释：三个子数组分别为：
 * [2]: 1 个互不相同的元素。
 * [2]: 1 个互不相同的元素。
 * [2,2]: 1 个互不相同的元素。
 * 所有不同计数的平方和为 12 + 12 + 12 = 3 。
 */
public class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int res = n;
        for (int i = 0; i < n; i ++){
            HashSet<Integer> set = new HashSet<>();
            set.add(nums.get(i));
            for (int right = i + 1; right < n ; right ++){
                set.add(nums.get(right));
                res += set.size() * set.size();
            }
        }
        return res;
    }

    public static void main(String[] args) {}
}
