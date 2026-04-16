package com.middle.code_3305;

import java.util.Arrays;

/**
 * @Author chenyuxiang
 * @Date 2025/3/12
 * @Description
 */
public class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int res = 0;
        String[] aeiou = new String[]{"a", "e", "i", "o", "u"};
        int left = 0;
        int right = left;
        int[] count = new int[5];
        boolean flag = false;
        int countA = 0;
        while (right < n) {
            if(Arrays.asList(aeiou).contains(word.substring(right, right + 1))) {
                count[Arrays.asList(aeiou).indexOf(word.substring(right, right + 1))]++;
            }
            if(count[0] > 0 && count[1] > 0 && count[2] > 0 && count[3] > 0 && count[4] > 0) {
                flag = true;
            }
            if(flag) {
                if(!Arrays.asList(aeiou).contains(word.substring(right, right+ 1))) {
                    countA++;
                }
                if(countA == k) {
                    res++;
                    countA = 0;
                    if (Arrays.asList(aeiou).contains(word.substring(left, left + 1))) {
                        count[Arrays.asList(aeiou).indexOf(word.substring(left, left + 1))]--;
                    }
                    left++;
                    flag = false;
                }
            }
            right++;
        }
        return res;
    }
}
