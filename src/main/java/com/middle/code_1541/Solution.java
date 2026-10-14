package com.middle.code_1541;

/**
 * @Author chenyuxiang
 * @Date 2026-10-09
 * @Description 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * 请你返回让 s 平衡的最少插入次数。
 * 示例 1：
 * 输入：s = "(()))"
 * 输出：1
 * 解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))" 。
 * 示例 2：
 * 输入：s = "())"
 * 输出：0
 * 解释：字符串已经平衡了。
 * 示例 3：
 * 输入：s = "))())("
 * 输出：3
 * 解释：添加 '(' 去匹配最开头的 '))' ，然后添加 '))' 去匹配最后一个 '(' 。
 * 示例 4：
 * 输入：s = "(((((("
 * 输出：12
 * 解释：添加 12 个 ')' 得到平衡字符串。
 * 示例 5：
 * 输入：s = ")))))))"
 * 输出：5
 * 解释：在字符串开头添加 4 个 '(' 并在结尾添加 1 个 ')' ，字符串变成平衡字符串 "(((())))))))" 。
 */
public class Solution {
    public int minInsertions(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int left = 0; // 未配对的左括号个数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                left++;
            } else {
                if (i + 1 < n && s[i + 1] == ')') {
                    i++; // 跳过下一个右括号
                } else {
                    ans++; // 需要插入一个右括号
                }
                if (left > 0) {
                    left--; // 配对一个左括号
                } else {
                    ans++; // 需要插入一个左括号
                }
            }
        }
        ans += left * 2; // 每个未配对的左括号需要插入两个右括号
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "(()))";
        System.out.println(solution.minInsertions(s1)); // 输出: 1

        String s2 = "())";
        System.out.println(solution.minInsertions(s2)); // 输出: 0

        String s3 = "))())(";
        System.out.println(solution.minInsertions(s3)); // 输出: 3

        String s4 = "((((((";
        System.out.println(solution.minInsertions(s4)); // 输出: 12

        String s5 = ")))))))";
        System.out.println(solution.minInsertions(s5)); // 输出: 5
    }
}
