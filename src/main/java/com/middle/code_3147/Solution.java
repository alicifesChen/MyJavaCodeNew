package com.middle.code_3147;

/**
 * @Author chenyuxiang
 * @Date 2025-10-10
 * @Description
 */
public class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = 0;
        int left = 0;
        while (left < n) {
            int right = left + k - 1;
            int sum = 0;
            if(right >= n) {
                maxEnergy = Math.max(maxEnergy,energy[left]);
                left++;
                continue;
            }
            for (int i = left; i <= right; i++) {
                sum += energy[i];
            }
            maxEnergy = Math.max(maxEnergy, sum);
            left++;
        }
        return  maxEnergy;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] energy = {5,2,-10,-5,1};
        int k = 3;
        int res = solution.maximumEnergy(energy, k);
        System.out.println(res);
    }
}
