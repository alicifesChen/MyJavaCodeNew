package com.middle.code_2537;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyuxiang
 * @Date 2025/4/16
 * @Description
 */
class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;                    // 最终答案，统计满足“pairs >= k”的子数组数量
        Map<Integer, Integer> cnt = new HashMap<>(); // 用来记录当前窗口内每个元素出现的次数
        int pairs = 0;                   // 当前窗口内的“相同元素对”数量
        int left = 0;                    // 滑动窗口左边界

        for (int x : nums) {
            // 1）加入新元素 x 到窗口
            int c = cnt.getOrDefault(x, 0);
            pairs += c;          // x 与其在窗口中已出现的 c 个相同元素，各形成 1 个新对
            cnt.put(x, c + 1);   // 更新 x 的出现次数

            // 2）如果当前窗口内的 pairs >= k，就开始收缩左边界
            //    使得收缩完后，窗口的“相同元素对”pairs < k
            while (pairs >= k) {
                int leftVal = nums[left];      // 准备移除左端元素
                int freqLeftVal = cnt.get(leftVal);
                // 移除这个 leftVal，减少的对数是 freqLeftVal - 1
                // 因为 leftVal 跟窗口中“它之外的 freqLeftVal-1 个相同元素”构成了对
                pairs -= freqLeftVal - 1;

                cnt.put(leftVal, freqLeftVal - 1);  // 更新出现次数
                left++;                            // 窗口左边界右移
            }

            // 3）走到这里时，窗口内的 pairs < k
            //    那么对于当前 right（即 for 循环中的下标），
            //    所有以 end = right 为右边界、start ∈ [0,1,2,...,left-1] 的子数组，其 pairs >= k
            //    也就是说，子数组起点在 [0 .. left-1] 会被「while」循环挤出去，
            //    因为它们的对数太大(>=k)，所以需要把它们“排除”出窗口。
            //    但这里正好说明：有 left 个不同的 start（0~left-1）可以使 pairs >= k。
            ans += left;
        }

        return ans;
    }
}
