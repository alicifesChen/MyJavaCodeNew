package com.easy.code_3718;

/**
 * @Author chenyuxiang
 * @Date 2026-08-25
 * @Description 给你一个整数数组 nums 和一个整数 k，请返回从 nums 中缺失的、最小的正整数 k 的倍数。
 * 倍数 指能被 k 整除的任意正整数。
 * 示例 1：
 * 输入： nums = [8,2,3,4,6], k = 2
 * 输出： 10
 * 解释：
 * 当 k = 2 时，其倍数为 2、4、6、8、10、12……，其中在 nums 中缺失的最小倍数是 10。
 * 示例 2：
 * 输入： nums = [1,4,7,10,15], k = 5
 * 输出： 5
 * 解释：
 * 当 k = 5 时，其倍数为 5、10、15、20……，其中在 nums 中缺失的最小倍数是 5。
 */
public class Solution {
    public int missingMultiple(int[] nums, int k) {
        int radix = 1;
        while (true) {
            int multiple = radix * k;
            boolean found = false;
            for (int num : nums) {
                if (num == multiple) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return multiple;
            }
            radix++;
        }
    }
}
