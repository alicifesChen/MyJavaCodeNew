package com.easy.code_3200;

/**
 * @Author chenyuxiang
 * @Date 2024/10/15
 * @Description
 */
public class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        // 定义一个方法来处理不同的初始情况
        return Math.max(simulate(red, blue, true), simulate(red, blue, false));
    }

    private int simulate(int red, int blue, boolean startWithRed) {
        int mockRead = red;
        int mockBlue = blue;
        int count = 1;

        while (mockBlue >= 0 && mockRead >= 0) {
            if ((count % 2 == 1 && startWithRed) || (count % 2 == 0 && !startWithRed)) {
                mockRead -= count;
            } else {
                mockBlue -= count;
            }

            if (mockRead < 0 || mockBlue < 0) {
                break;
            }

            count++;
        }

        return count - 1; // 返回最大值

    }

    public static void main(String[] args) {
        int res = new Solution().maxHeightOfTriangle(2, 2);
        System.out.println(res);
    }
}
