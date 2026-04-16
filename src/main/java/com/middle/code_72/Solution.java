package com.middle.code_72;

/**
 * @Author chenyuxiang
 * @Date 2025/2/10
 * @Description
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            if(midValue == target) {
                return true;
            } else if(midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
