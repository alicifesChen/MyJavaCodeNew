package com.easy.code_836;

/**
 * @Author chenyuxiang
 * @Date 2026-09-14
 * @Description
 */
public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isOverlap(rec1, rec2);
    }

    private boolean isOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]);
    }
}
