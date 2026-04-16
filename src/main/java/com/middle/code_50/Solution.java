package com.middle.code_50;

/**
 * @Author chenyuxiang
 * @Date 2024/7/30
 * @Description
 */
public class Solution {
    public double myPow(double x, int N) {
        double ans = 1;
        long n = N;
        if (n < 0) { // x^-n = (1/x)^n
            n = -n;
            x = 1 / x;
        }
        while (n != 0){
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
