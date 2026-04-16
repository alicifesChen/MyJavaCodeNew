package com.easy.code_3216;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/10/30
 * @Description
 */
public class Solution {
    public String getSmallestString(String s) {
        if(s.length() <= 1) return s;
        StringBuffer stringBuffer = new StringBuffer();
        boolean isReverse = false;
        stringBuffer.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if((s.charAt(i) + s.charAt(i - 1)) % 2 == 0 && s.charAt(i) < s.charAt(i - 1) && !isReverse ) {
                stringBuffer.replace(stringBuffer.length() - 1, stringBuffer.length(), String.valueOf(s.charAt(i)));
                stringBuffer.append(s.charAt(i - 1));
                isReverse =true;
            } else {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "45320";
        System.out.println(solution.getSmallestString(s));
    }
}
