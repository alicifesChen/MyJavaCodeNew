package com.middle.code_1061;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author chenyuxiang
 * @Date 2025/6/5
 * @Description
 */
public class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];  // 存储每个字符的父节点

        // 初始化并查集
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // 合并操作
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', parent);
        }

        StringBuilder result = new StringBuilder();

        // 处理 baseStr，替换为最小的等价字符
        for (char c : baseStr.toCharArray()) {
            char smallestChar = (char) (find(c - 'a', parent) + 'a');
            result.append(smallestChar);
        }

        return result.toString();
    }

    // 并查集的查找操作
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);  // 路径压缩
        }
        return parent[x];
    }

    // 并查集的合并操作
    private void union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if (rootX != rootY) {
            // 将小的根节点指向大的根节点，保持字符集的最小性
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }
}
