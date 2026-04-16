package com.middle.code_2414;

import java.util.ArrayList;

/**
 * @Author chenyuxiang
 * @Date 2024/9/19
 * @Description
 */
public class Solution {
    public int longestContinuousSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        ArrayList<Integer> dp = new ArrayList<>(s.length());
        dp.add(1);  // 初始化第一个元素的值为1
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {  // 修改循环条件到s.length()
            if (s.charAt(i) - pre == 1) {
                dp.add(dp.get(i - 1) + 1);  // 使用add而不是set
            } else {
                dp.add(1);  // 使用add而不是set
            }
            pre = s.charAt(i);
        }
        return dp.stream().max(Integer::compareTo).orElse(1);  // 使用orElse以防列表为空
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestContinuousSubstring("abacaba"));
    }
}
