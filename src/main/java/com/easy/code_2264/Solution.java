package com.easy.code_2264;

/**
 * @Author chenyuxiang
 * @Date 2025/1/8
 * @Description
 */

public class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        int count = 1;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            // 当找到一个长度为3的连续字符序列时
            if (count == 3) {
                String candidate = num.substring(i - 2, i + 1);
                // 只更新res，如果找到的序列比当前res字典序更大
                if (candidate.compareTo(res) > 0) {
                    res = candidate;
                }
                // 重置计数器
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num = "6777133339";
        System.out.println(solution.largestGoodInteger(num));
    }
}
