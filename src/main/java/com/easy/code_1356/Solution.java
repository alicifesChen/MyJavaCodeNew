package com.easy.code_1356;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2026-02-25
 * @Description
 */
public class Solution {
    public int[] sortByBits(int[] arr) {
        // 创建一个包装类数组
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        // 自定义排序：首先按1的个数排序，如果1的个数相同，则按数值大小排序
        Arrays.sort(nums, (a, b) -> {
            int countA = bitCount(a);
            int countB = bitCount(b);
            if (countA != countB) {
                return countA - countB;
            }
            return a - b;
        });

        // 转换回基本类型数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }

    public int bitCount(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
    }
}
