package com.easy.code_2748;

/**
 * @Author chenyuxiang
 * @Date 2024/6/20
 * @Description
 */
public class Solution {
    public int countBeautifulPairs(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isGcd(nums[i], nums[j])) {
                    end++;
                }
            }
        }
        return end;
    }

    //判断两个数互为质数,采用辗转相除法
    public Boolean isGcd(int a, int b) {
        String str = String.valueOf(a);
        int first = str.charAt(0) - '0';
        String str1 = String.valueOf(b);
        int last = str1.charAt(str1.length() - 1) - '0';
        int temp;
        while (last != 0) {
            temp = first % last;
            first = last;
            last = temp;
        }
        return first == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBeautifulPairs(new int[]{2, 5, 1, 4}));
        System.out.println(solution.countBeautifulPairs(new int[]{3, 3, 3, 3}));
        System.out.println(solution.countBeautifulPairs(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
