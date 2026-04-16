package com.lcp.code_40;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2024/8/1
 * @Description
 */
public class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        if(cards == null || cards.length == 0) {
            return 0;
        }
        if(cnt > cards.length) {
            return 0;
        }
        Arrays.sort(cards);
        int n = cards.length;
        int res = 0;
        int sum = 0;
        int selectEven = Integer.MAX_VALUE;
        int selectOdd = Integer.MIN_VALUE;
        for(int i = 0;i < cnt;++i) {
             sum += cards[n - i -1];
                if(cards[n - i - 1] % 2 == 0) {
                    selectEven = Math.max(selectEven, cards[n - i - 1]);
                } else {
                    selectOdd = Math.min(selectOdd, cards[n - i - 1]);
                }
        }
        if(sum % 2 == 0) {
            return sum;
        }
        //排序先取最大的cnt个数，如果它们的和是偶数直接输出，不然就找一个已取的最小的奇数换成剩下未取的最大的偶数，或者找一个已取的最小的偶数换成剩下未取的最大奇数


        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cards = {1, 2, 8, 9};
        int cnt = 3;
        int res = solution.maxmiumScore(cards, cnt);
        System.out.println(res);
    }
}
