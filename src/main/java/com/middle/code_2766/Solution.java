package com.middle.code_2766;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2024/7/24
 * @Description
 */
public class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        nums = new int[set.size()];
//        int index = 0;
//        for (int num : set) {
//            nums[index++] = num;
//        }
//        for (int i = 0; i < moveFrom.length; i++) {
//            int from = moveFrom[i];
//            int to = moveTo[i];
//            if (from == to) {
//                continue;
//            }
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] == from) {
//                    nums[j] = to;
//                    break;
//                }
//            }
//        }
//        Set<Integer> end = new HashSet<>();
//        for (int num : nums) {
//            end.add(num);
//        }
//        List<Integer> res = Arrays.asList(end.toArray(new Integer[0]));
//        res.sort(Integer::compareTo);
//        return res;
        Set<Integer> set = new HashSet<>(nums.length); // 预分配空间，效率更高
        for (int x : nums) {
            set.add(x);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }

        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] moveFrom = {1, 2};
        int[] moveTo = {3, 4};
        List<Integer> res = solution.relocateMarbles(nums, moveFrom, moveTo);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
