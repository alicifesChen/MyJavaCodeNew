package com.middle.code_2829;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/3/26
 * @Description
 */
public class Solution {
    public int minimumSum(int n, int k) {
        //等差数列求和
        int m = k / 2 + 1;
        if(n < m) {
            //如果n小于m的一半的话，那么最小和就是等差数列求和
            return (1 + n) * n / 2;
        } else {
            //如果n大于m的一半，需要移动剩下的一半的数，移动的幅度是n-m+1，再进行等差数列求和即可
            return m * (m - 1) / 2 + (k + k + n - m) * (n - m + 1) / 2;
        }
    }
}
