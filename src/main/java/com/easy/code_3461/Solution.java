package com.easy.code_3461;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-10-23
 * @Description
 */
public class Solution {
    public boolean hasSameDigits(String s) {
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c - '0');
        }
        List<Integer> temp = new ArrayList<>();
        while (list.size() != 2) {
            temp.clear();
            for(int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i));
                int cur = (list.get(i) + list.get(i + 1)) % 10;
                temp.add(cur);
            }
            list = new ArrayList<>(temp);
        }
        return list.get(0).equals(list.get(1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasSameDigits("355"));
    }

}
