package com.easy.code_202;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author chenyuxiang
 * @Date 2024/7/1
 * @Description
 */
public class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int end = n;
        while (true) {
            String s = String.valueOf(end);
            end = 0;
            for(int i = 0; i < s.length(); i++){
                end += Math.pow(s.charAt(i) - '0', 2);
            }
            if(map.containsKey(end)){
                return false;
            }
            map.put(end, 1);
            if(end == 1){
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
    }
}
