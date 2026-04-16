package com.middle.code_3211;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/10/29
 * @Description 生成不含相邻零的二进制字符串
 */
public class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), n);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int n) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }
        // Always safe to append '1'
        sb.append('1');
        dfs(res, sb, n);
        sb.deleteCharAt(sb.length() - 1);
        // Append '0' only if the last character is not '0'
        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '0') {
            sb.append('0');
            dfs(res, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> res = solution.validStrings(n);
        System.out.println(res);
    }
}
