package com.easy.code_682;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/7/29
 * @Description
 */
public class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            if ("C".equals(operation)) {
                list.remove(list.size() - 1);
            } else if ("D".equals(operation)) {
                list.add(list.get(list.size() - 1) * 2);
            } else if ("+".equals(operation)) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else {
                list.add(Integer.parseInt(operation));
            }
        }
        return list.stream().mapToInt(Integer::valueOf).sum();
    }
}
