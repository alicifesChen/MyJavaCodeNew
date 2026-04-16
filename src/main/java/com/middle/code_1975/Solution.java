package com.middle.code_1975;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-01-05
 * @Description
 */
public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minPositive = Integer.MAX_VALUE;
        int maxNegative = Integer.MIN_VALUE;
        int positiveCount = 0;
        int negativeCount = 0;
        long absSum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num >= 0) {
                    minPositive = Math.min(minPositive, num);
                    positiveCount++;
                    absSum += num;
                } else {
                    maxNegative = Math.max(maxNegative, num);
                    negativeCount++;
                    absSum += -num;
                }
            }
        }
        if(negativeCount % 2 == 0) {
            return absSum;
        } else {
            return absSum - 2 * Math.min(minPositive, -maxNegative);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1,2,3},{-1,-2,-3},{1,2,3}
        };
        long result = solution.maxMatrixSum(matrix);
        System.out.println(result); // Expected output: 5
    }
}

