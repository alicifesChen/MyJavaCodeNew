package com.middle.code_1545;

/**
 * @Author chenyuxiang
 * @Date 2026-03-03
 * @Description S1 = "0"
 * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 */

public class Solution {
    public char findKthBit(int n, int k) {
        int count = 0;
        String s = "0";
        while (count < n) {
            count++;
            s = s + '1' + reverseAndInvert(s);
            System.out.println(s);
        }
        return s.charAt(k - 1);
    }

    private String reverseAndInvert(String s) {
        return new StringBuilder(s).reverse().toString().chars().map(c -> c == '0' ? '1' : '0').collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthBit(4, 11));
    }
}
