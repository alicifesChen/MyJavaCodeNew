package com.easy.code_2974;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/7/12
 * @Description
 */
public class Solution {
    public int[] numberGame(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        list.sort(Integer::compareTo);
//        for (int i = 0; i < nums.length; i += 2) {
//            res.add(list.get(i + 1));
//            res.add(list.get(i));
//        }
//        return res.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            int tmp = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] res = solution.numberGame(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
