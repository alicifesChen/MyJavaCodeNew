package com.middle.code_3115;

/**
 * @Author chenyuxiang
 * @Date 2024/7/2
 * @Description
 */
public class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (isPrime(nums[left]) && isPrime(nums[right])) {
                return right - left;
            }
            if (!isPrime(nums[left])) {
                left++;
            }
            if (!isPrime(nums[right])) {
                right--;
            }
        }
        return 0;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumPrimeDifference(new int[]{7, 2, 3, 5, 5, 2}));
        System.out.println(solution.maximumPrimeDifference(new int[]{10, 5, 7}));
        System.out.println(solution.maximumPrimeDifference(new int[]{3, 7, 1, 9, 5, 11, 6, 12}));
    }
}
