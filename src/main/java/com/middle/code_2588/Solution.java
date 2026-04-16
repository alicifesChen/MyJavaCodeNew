package com.middle.code_2588;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025/3/6
 * @Description
 */
class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>(); // 记录前缀异或和的出现次数
        cnt.put(0, 1);  // 初始化，异或前缀和为 0 出现 1 次
        long ans = 0;    // 结果变量
        int mask = 0;    // 维护前缀异或和

        for (int x : nums) { // 遍历数组
            mask ^= x; // 计算当前前缀异或和

            // 统计有多少次之前出现过相同的前缀异或和
            ans += cnt.getOrDefault(mask, 0);

            // 更新前缀异或和的出现次数
            cnt.put(mask, cnt.getOrDefault(mask, 0) + 1);
        }

        return ans;
    }
}

