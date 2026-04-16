package com.middle.code_209;

/**
 * @Author chenyuxiang
 * @Date 2024/6/17
 * @Description
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int end = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        int i = 0; //起始位置
        for(int j = 0;j < nums.length; j++){
            sum += nums[j];
            while (sum >= target){
                subLength = j - i + 1;
                end = Math.min(end, subLength);
                sum -= nums[i];
                i ++;
            }
        }
        return end == Integer.MAX_VALUE ? 0 : end;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(solution.minSubArrayLen(11, new int[]{1,1,1,1,1,1}));
    }
}
