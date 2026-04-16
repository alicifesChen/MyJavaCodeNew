package com.easy.code_3158;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2024/10/12
 * @Description
 */
public class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                list.add(num);
            } else {
                hashMap.put(num, 1);
            }
        }
        if(list.isEmpty()) {
            return 0;
        }
        if(list.size() == 1) {
            return list.get(0);
        }
        int end = list.get(list.size() - 1);
        for (int i = 1; i < list.size(); i++) {
            end ^= list.get(i);
        }
        return end;
    }
}
