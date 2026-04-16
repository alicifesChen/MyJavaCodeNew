package com.easy.code_3000;

/**
 * @Author chenyuxiang
 * @Date 2025-08-26
 * @Description
 */
public class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int pastSquare = 0;
        for (int[] dim : dimensions) {
            int curSquare = dim[0] * dim[0] + dim[1] * dim[1];
            if(curSquare > pastSquare) {
                maxArea = dim[0] * dim[1];
            }
            if(curSquare == pastSquare) {
                maxArea = Math.max(maxArea, dim[0] * dim[1]);
            }
            pastSquare = Math.max(pastSquare, curSquare);
        }
        return  maxArea;
    }
}
