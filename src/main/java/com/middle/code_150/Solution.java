package com.middle.code_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/8/7
 * @Description
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> list = new ArrayList<>();
        for(String i : tokens) {
            switch (i) {
                case "+": {
                    int a = list.remove(list.size() - 1);
                    int b = list.remove(list.size() - 1);
                    list.add(a + b);
                    break;
                }
                case "-": {
                    int a = list.remove(list.size() - 1);
                    int b = list.remove(list.size() - 1);
                    list.add(b - a);
                    break;
                }
                case "*": {
                    int a = list.remove(list.size() - 1);
                    int b = list.remove(list.size() - 1);
                    list.add(a * b);
                    break;
                }
                case "/": {
                    int a = list.remove(list.size() - 1);
                    int b = list.remove(list.size() - 1);
                    list.add(b / a);
                    break;
                }
                default:
                    list.add(Integer.parseInt(i));
                    break;
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens));
    }
}
