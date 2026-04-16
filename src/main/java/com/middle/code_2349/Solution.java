package com.middle.code_2349;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2025-09-17
 * @Description
 */
public class Solution {
    class NumberContainers {
        Map<Integer, Integer> indexToNumber;
        Map<Integer, TreeSet<Integer>> numberToIndices;


        public NumberContainers() {
            indexToNumber = new HashMap<>();
            numberToIndices = new HashMap<>();
        }

        public void change(int index, int number) {
            if(indexToNumber.containsKey(index)) {
                int oldNumber = indexToNumber.get(index);
                numberToIndices.get(oldNumber).remove(index);
                if (numberToIndices.get(oldNumber).isEmpty()) {
                    indexToNumber.remove(index);
                }
            }
            indexToNumber.put(index, number);
            numberToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
        }

        public int find(int number) {
            TreeSet<Integer> indices = numberToIndices.get(number);
            return indices == null || indices.isEmpty() ? -1 : indices.first();
        }
    }
}
