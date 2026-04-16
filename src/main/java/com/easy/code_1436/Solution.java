package com.easy.code_1436;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2024/10/8
 * @Description
 */
public class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,String> map=new HashMap<>();
        for (List item : paths){
            map.put(item.get(0).toString(),item.get(1).toString());
        }
        String start=paths.get(0).get(0).toString();
        while (map.containsKey(start)){
            start=map.get(start);
        }
        return start;
    }

    public static void main(String[] args) {

    }
}
