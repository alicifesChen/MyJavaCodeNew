package com.easy.code_2452;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2026-04-22
 * @Description 给你两个字符串数组 queries 和 dictionary 。数组中所有单词都只包含小写英文字母，且长度都相同。
 * 一次 编辑 中，你可以从 queries 中选择一个单词，将任意一个字母修改成任何其他字母。
 * 从 queries 中找到所有满足以下条件的字符串：不超过 两次编辑内，字符串与 dictionary 中某个字符串相同。
 * 请你返回 queries 中的单词列表，这些单词距离 dictionary 中的单词 编辑次数 不超过 两次 。单词返回的顺序需要与 queries 中原本顺序相同。
 * 示例 1：
 * 输入：queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
 * 输出：["word","note","wood"]
 * 解释：
 * - 将 "word" 中的 'r' 换成 'o' ，得到 dictionary 中的单词 "wood" 。
 * - 将 "note" 中的 'n' 换成 'j' 且将 't' 换成 'k' ，得到 "joke" 。
 * - "ants" 需要超过 2 次编辑才能得到 dictionary 中的单词。
 * - "wood" 不需要修改（0 次编辑），就得到 dictionary 中相同的单词。
 * 所以我们返回 ["word","note","wood"] 。
 * 示例 2：
 * 输入：queries = ["yes"], dictionary = ["not"]
 * 输出：[]
 * 解释：
 * "yes" 需要超过 2 次编辑才能得到 "not" 。
 * 所以我们返回空数组。
 */
public class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String dictWord : dictionary) {
                if (isTwoEditDistance(query, dictWord)) {
                    result.add(query);
                    break; // 找到一个满足条件的单词后，跳出内层循环，继续检查下一个 query
                }
            }
        }
        return result;
    }

    private boolean isTwoEditDistance(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) {
                    return false; // 超过两次编辑，直接返回 false
                }
            }
        }
        return true; // 编辑次数不超过两次，返回 true
    }
}
