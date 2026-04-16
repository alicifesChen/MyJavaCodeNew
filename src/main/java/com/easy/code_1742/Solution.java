package com.easy.code_1742;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/2/13
 * @Description
 */
public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        List<Integer> list = new ArrayList<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if(list.size() <= sum) {
                for (int j = list.size(); j <= sum; j++) {
                    list.add(0);
                }
            }
            list.set(sum, list.get(sum) + 1);
        }
        return list.stream().max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int lowLimit = 1;
        int highLimit = 10;
        System.out.println(solution.countBalls(lowLimit, highLimit));
    }
}
