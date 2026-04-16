package com.middle.code_3259;

/**
 * @Author chenyuxiang
 * @Date 2024/11/1
 * @Description
 */
public class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        f[1] = energyDrinkA[0];
        g[1] = energyDrinkB[0];
        for(int i = 2; i <= n; i++) {
            f[i] = Math.max(f[i - 1], g[i - 2]) + energyDrinkA[i - 1];
            g[i] = Math.max(g[i - 1], f[i - 2]) + energyDrinkB[i - 1];
        }
        return Math.max(f[n], g[n]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] energyDrinkA = {1, 2, 3, 4, 5};
        int[] energyDrinkB = {2, 3, 4, 5, 6};
        System.out.println(solution.maxEnergyBoost(energyDrinkA, energyDrinkB));
    }
}
