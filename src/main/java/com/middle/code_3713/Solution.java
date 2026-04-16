package com.middle.code_3713;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestBalanced(String s) {
        int res = 0;
        int l = s.length();

        // 外层循环枚举左端点
        for (int i = 0; i < l; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int maxFreq = 0;

            // 内层循环扩展右端点
            for (int j = i; j < l; j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(c));

                // 判断当前窗口是否是平衡子串
                boolean isBalanced = true;
                for (int freq : map.values()) {
                    if (freq != maxFreq) {
                        isBalanced = false;
                        break;
                    }
                }

                if (isBalanced) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestBalanced("aaabba")); // 输出应为 4 ("aabb")
    }
}
