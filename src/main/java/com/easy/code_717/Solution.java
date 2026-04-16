package com.easy.code_717;

/**
 * @Author chenyuxiang
 * @Date 2025-11-18
 * @Description
 */
public class Solution {
//    public boolean isOneBitCharacter(int[] bits) {
//        int i = bits.length - 2; // 从倒数第二个开始
//        while (i >= 0 && bits[i] == 1) {
//            i--;
//        }
//        // 计算最后一个0前面连续1的个数
//        return (bits.length - 2 - i) % 2 == 0;
//    }
public boolean isOneBitCharacter(int[] bits) {
    int i = 0;
    while (i < bits.length - 1) {
        i += bits[i] + 1;  // 如果是1则+2，如果是0则+1
    }
    return i == bits.length - 1;
}


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bits = {0, 0};
        System.out.println(solution.isOneBitCharacter(bits));
    }
}
