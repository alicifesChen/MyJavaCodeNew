package com.lcp.code_22;

/**
 * @Author chenyuxiang
 * @Date 2024/7/9
 * @Description
 */
public class Solution {
    public String pathEncryption(String path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '.') {
                sb.append(" ");
            } else {
                sb.append(path.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pathEncryption("dir1.dir2.dir3"));
        System.out.println(solution.pathEncryption("dir1.dir2.dir3."));
        System.out.println(solution.pathEncryption("dir1.dir2.dir3.."));
    }
}

