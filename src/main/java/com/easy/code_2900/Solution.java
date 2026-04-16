package com.easy.code_2900;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/5/15
 * @Description
 */
public class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 1; i < groups.length; i ++) {
            if(groups[i] != groups[res.get(res.size() -1)]) {
                res.add(i);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < res.size(); i ++) {
            result.add(words[res.get(i)]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"a", "b", "c", "d", "e"};
        int[] groups = {1, 2, 3, 4, 5};
        List<String> result = solution.getLongestSubsequence(words, groups);
        System.out.println(result);
    }
}
