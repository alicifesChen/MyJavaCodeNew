package com.middle.code_165;

/**
 * @Author chenyuxiang
 * @Date 2025/1/21
 * @Description
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        int n = 0, m = 0;
        int a = 0, b = 0;
        while (n < version1.length() && version1.charAt(n) != '.') {
            a = a * 10 + version1.charAt(n) - '0';
            n++;
        }
        while (m < version2.length() && version2.charAt(m) != '.') {
            b = b * 10 + version2.charAt(m) - '0';
            m++;
        }
        if (a > b) {
            return 1;
        }
        if (a < b) {
            return -1;
        }
        if (n == version1.length() && m == version2.length()) {
            return 0;
        }
        if (n == version1.length()) {
            return compareVersion("0", version2.substring(m + 1));
        }
        if (m == version2.length()) {
            return compareVersion(version1.substring(n + 1), "0");
        }
        return compareVersion(version1.substring(n + 1), version2.substring(m + 1));
    }
}
