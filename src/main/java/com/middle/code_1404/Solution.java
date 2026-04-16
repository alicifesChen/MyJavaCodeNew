package com.middle.code_1404;

/**
 * @Author chenyuxiang
 * @Date 2026-02-26
 * @Description 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 */
public class Solution {
    public int numSteps(String s) {
        int count = 0;
        int carry = 0;

        // 从右往左处理（除了最左边的1）
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0' + carry;

            if (bit % 2 == 1) {  // 奇数：加1
                carry = 1;
                count += 2;  // 加1操作 + 除2操作
            } else {  // 偶数：除2
                count += 1;
            }
        }

        return count + carry;  // 如果有进位，还需要额外的除2操作
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1101";
        System.out.println(solution.numSteps(s));
    }
}
