package com.middle.code_3175;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/10/25
 * @Description
 */
public class Solution {
    public int findWinningPlayer(int[] skills, int k) {
//        List<Integer> list = new ArrayList<>();
//        int max = 0;
//        for (int i = 0; i < skills.length; i++) {
//            list.add(i);
//            max = Math.max(max, skills[i]);
//        }
//        int end = 0;
//        int cur = list.get(0);
//        while (end < k) {
//            if(max == skills[cur]) {
//                return cur;
//            }
//            if(skills[cur] > skills[list.get(1)]) {
//                int remove = list.get(1);
//                list.add(remove);
//                list.remove(1);
//                ++ end;
//            } else {
//                list.remove(0);
//                list.add(cur);
//                cur = list.get(0);
//                end = 1;
//            }
//        }
//        return cur;
        int maxI = 0;
        int win = 0;
        for (int i = 1; i < skills.length && win < k; i++) {
            if (skills[i] > skills[maxI]) { // 打擂台，发现新的最大值
                maxI = i;
                win = 0;
            }
            win++; // 获胜回合 +1
        }
        // 如果 k 很大，那么 maxI 就是 skills 最大值的下标，毕竟最大值会一直赢下去
        return maxI;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] skills = {4,2,6,3,9};
        int k = 2;
        System.out.println(solution.findWinningPlayer(skills, k));
    }
}
