package com.easy.code_3354;

/**
 * @Author chenyuxiang
 * @Date 2025-10-28
 * @Description
 */
public class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int ans = 0;
        int pre = 0;

        for (int x : nums) {
            if( x > 0){
                pre += x;
            } else if(pre * 2 == total){
                ans+= 2;
            } else if(Math.abs(pre * 2 - total) == 1) {
                ans += 1;
            }
        }
        return ans;
    }
}
