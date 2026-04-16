package com.easy.code_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025-08-01
 * @Description
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            return List.of(List.of(1));
        }
        if(numRows == 2) {
            return List.of(List.of(1), List.of(1, 1));
        }
        List<List<Integer>> result = new ArrayList<>();
        int count = 2;
        result.add(List.of(1));
        result.add(List.of(1, 1));
        while (count < numRows) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); // 每行的第一个元素为1
            List<Integer> previousRow = result.get(count - 1); // 获取上一行
            for (int i = 0; i < previousRow.size() - 1; i++) {
                // 每个元素是上一行相邻两个元素的和
                currentRow.add(previousRow.get(i) + previousRow.get(i + 1));
            }
            currentRow.add(1); // 每行的最后一个元素为1
            result.add(currentRow); // 将当前行添加到结果中
            count++;
        }
        return  result;
    }
}

