package com.easy.code_1656;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/2/24
 * @Description
 */
public class Solution {
    class OrderedStream {
        List<String> list;
        int ptr;

        public OrderedStream(int n) {
            this.list = new ArrayList<>(Collections.nCopies(n, null)); // 预填充 n 个 null
            this.ptr = 0; // 记录当前指针位置
        }

        public List<String> insert(int idKey, String value) {
            list.set(idKey - 1, value); // 安全地设置值
            List<String> res = new ArrayList<>();

            // 从指针开始收集连续的非空元素
            while (ptr < list.size() && list.get(ptr) != null) {
                res.add(list.get(ptr));
                ptr++;
            }
            return res;
        }
    }

}
