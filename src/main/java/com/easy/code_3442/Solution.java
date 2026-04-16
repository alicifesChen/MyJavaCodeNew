package com.easy.code_3442;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author chenyuxiang
 * @Date 2025/6/10
 * @Description
 */
public class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, 1);
            } else {
                charToIndex.put(c, charToIndex.get(c) + 1);
            }
        }
        int[] indexArray = new int[charToIndex.size()];
        int idx = 0;
        for (char c : charToIndex.keySet()) {
            indexArray[idx++] = charToIndex.get(c);
        }
        Arrays.sort(indexArray);
        int max = indexArray[indexArray.length - 1];
        int min = indexArray[0];
        int maxIndex = indexArray.length - 1;
        int minIndex = 0;
        while (max % 2 == 0 ) {
            maxIndex --;
            max = indexArray[maxIndex];
        }
        while (min % 2 > 0) {
            minIndex++;
            min = indexArray[minIndex];
        }
        return max - min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaaaabbc";
        int result = solution.maxDifference(s);
        System.out.println("The maximum difference is: " + result);
    }
}
