package com.middle.code_2288;

/**
 * @Author chenyuxiang
 * @Date 2024/6/18
 * @Description
 */
//public class Solution {
//    public String discountPrices(String sentence, int discount) {
//        String[] words = sentence.split(" ");
//        StringBuilder end = new StringBuilder();
//        double d = 1 - discount / 100.0;
//        for (int i = 0; i < words.length; i++) {
//            if (words[i].charAt(0) == '$' && words[i].length() > 1) {
//                int j = 1;
//                StringBuilder price = new StringBuilder();
//                boolean flag = false;
//                while (j < words[i].length()) {
//                    if (!Character.isDigit(words[i].charAt(j))) {
//                        flag = true;
//                    }
//                    price.append(words[i].charAt(j));
//                    j++;
//                }
//                if (!flag) {
//                    //保留两位小数
//                    double newPrice = Long.parseLong(price.toString()) * d;
//                    end.append("$").append(String.format("%.2f", newPrice));
//                } else {
//                    end.append(words[i]);
//                }
//            } else {
//                end.append(words[i]);
//            }
//            if (i != words.length - 1) {
//                end.append(" ");
//            }
//        }
//        return end.toString();
//    }
public class Solution {
    public String discountPrices(String sentence, int discount) {
        double d = 1 - discount / 100.0;
        String[] a = sentence.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (check(a[i])) {
                a[i] = String.format("$%.2f", Long.parseLong(a[i].substring(1)) * d);
            }
        }
        return String.join(" ", a);
    }

    private boolean check(String S) {
        if (S.length() == 1 || S.charAt(0) != '$') {
            return false;
        }
        char[] s = S.toCharArray();
        for (int i = 1; i < s.length; i++) {
            if (!Character.isDigit(s[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.discountPrices("The price of the item is $100", 100));
        System.out.println(solution.discountPrices("The price of the item is $200", 10));
        System.out.println(solution.discountPrices("$7383692 5q $5870426", 64)); //"$2658129.12 5q $2113353.36"
        System.out.println(solution.discountPrices("$76111 ab $6 $", 48)); //"$2658129.12 5q $2113353.36"
        System.out.println(solution.discountPrices("$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999", 0)); //"$2658129.12 5q $2113353.36"
        System.out.println(solution.discountPrices("$$$", 10)); //"$2658129.12 5q $2113353.36"
    }

}

