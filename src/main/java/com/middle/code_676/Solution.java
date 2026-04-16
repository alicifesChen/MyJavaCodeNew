package com.middle.code_676;

/**
 * @Author chenyuxiang
 * @Date 2024/8/12
 * @Description
 */
public class Solution {
    class MagicDictionary {
        private String[] str;

        public MagicDictionary() {
            this.str = new String[0];
        }

        public void buildDict(String[] dictionary) {
            this.str = dictionary;
        }

        public boolean search(String searchWord) {
            for (String s : str) {
                if (s.length() != searchWord.length()) {
                    continue;
                }
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != searchWord.charAt(i)) {
                        count++;
                    }
                }
                if (count == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
