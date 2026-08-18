package com.middle.code_3016;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author chenyuxiang
 * @Date 2026-07-31
 * @Description
 */
public class Solution {
    public int minimumPushes(String word) {
        Integer[] times = new Integer[26];
        Arrays.fill(times, 0);
        int n = word.length();
        for (int i = 0; i < n; i++) {
            times[word.charAt(i) - 'a']++;
        }
        // Sort in descending order
        Arrays.sort(times, Collections.reverseOrder());
        int result = 0;
        // There are 26 letters; group them in blocks of 8 for multiplier as before
        for (int i = 0; i < 26; i++) {
            if (times[i] == 0) break; // remaining letters don't contribute
            result += times[i] * (i / 8 + 1);
        }
        return result;
    }
}
